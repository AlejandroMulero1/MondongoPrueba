package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.Entidades.Departamentos;
import org.example.Entidades.Personas;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CRUD {
    /**
     * Método que inserta en una colección pasada por parámetro un documento también pasado por parámetro
     * @param collection : colección en la cual se quiere insertar
     * @param obj : registro a insertar
     */
    public static void Create(MongoCollection<Document> collection, Document obj){
        try {
            //Inserto a través del metodo insertOne de collection
            InsertOneResult result = collection.insertOne(obj);

            //Muestro la id del registro insertado
            System.out.println("Registro insertado con id: " + result.getInsertedId());
        } catch (MongoException me) {
            System.err.println("Ha ocurrido un error: " + me);
        }
    }

    /**
     * Método que lee todos los registros de una colección pasada por parámetro mostrandolos por pantalla
     * @param collection
     */
    public static Object Read(MongoCollection<Document> collection){
        //Lista en la que almaceno todos los datos de la tabla
        List<Object> listaRegistros=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        //Inicializo un cursor con el que recorrer la coleccion
        try (MongoCursor< Document > cur = collection.find().iterator()) {
            //Recorro la colección
            while (cur.hasNext()) {
                //Guardo el resgistro del cursor en un documento
                Document doc = cur.next();

                //Convierto el documento a json
                String json=doc.toJson();

                //Declaro un ObjectMapper con el que pasaré el json a un objeto
                ObjectMapper mapper = new ObjectMapper();
                Personas persona;
                try {
                    //Guardo en la Personas persona lo obtenido del json
                    persona=mapper.readValue(json, Personas.class);
                }
                //Controlo las posibles excepciones
                catch (JsonMappingException e){
                    System.err.println("Se ha producido un error leyendo el objeto");
                    persona=null;
                    e.printStackTrace();
                } catch (JsonProcessingException e){
                    System.out.println("Error al convertir el json");
                    persona=null;
                }
                listaRegistros=new ArrayList<>();
                listaRegistros.add(persona);
            }
            System.out.println("Seleccione un registro");
            for (int i=0; i<listaRegistros.size(); i++){
                System.out.println(i+": " + listaRegistros.get(i).toString());
            }
            int posicionRegistro=sc.nextInt();
            return listaRegistros.get(posicionRegistro);
        }
    }

    public static void Update(MongoCollection<Document> collection, Class claseObjActualizar){

    }
    public static void Delete(MongoCollection<Document> collection, Class claseObjBorrar){
        System.out.println("Borrar:");
        Object objBorrar=Read(collection);
        if (claseObjBorrar== Personas.class){
            Personas personaBorrar= (Personas) objBorrar;
            collection.deleteOne(new Document("_id", new ObjectId(personaBorrar.get_id())));
        }else {
            Departamentos dptoBorrar= (Departamentos) objBorrar;
            collection.deleteOne(new Document("_id", new ObjectId(dptoBorrar.get_id())));
        }
    }
}
