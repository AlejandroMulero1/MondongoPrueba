package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.example.Entidades.Personas;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CRUD {
    public static void Create(MongoCollection<Document> collection){}



    public static void Read(MongoCollection<Document> collection){
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

                //Muestro el valor
                System.out.printf("%s: %s%n", persona.get_id(), persona.getNombre());
            }
        }
    }

    public static void Update(MongoCollection<Document> collection,Serializable key, String registroActualizado){}
    public static void Delete(MongoCollection<Document> collection,Serializable key){}
}
