package org.example;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.example.Entidades.Departamentos;
import org.example.Entidades.Personas;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Utilidades {
    public static Document crearPersonaDocument(MongoDatabase db){
        MongoCollection<Document> collection= db.getCollection("departamentos");
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nombre de la persona");
        String nombrePersona=sc.next();

        System.out.println("Introduzca sus apellidos");
        sc.nextLine();
        String apellidosPersona=sc.nextLine();


        System.out.println("Introduzca su telefono");
        String telefonoPersona=sc.next();

        sc.nextLine();
        System.out.println("Introduzca su direccion");
        String direccionPersona=sc.nextLine();

        System.out.println("Introduzca la url de su foto");
        String fotoPersona=sc.next();

        Departamentos departamento=(Departamentos) CRUD.Read(collection, Departamentos.class);

        Personas personaNueva=new Personas(nombrePersona,apellidosPersona,telefonoPersona,direccionPersona,fotoPersona,departamento.getNombre());

        Document documentPesona = new Document();
        documentPesona.append("nombre", personaNueva.getNombre());
        documentPesona.append("apellidos", personaNueva.getApellidos());
        documentPesona.append("telefono", personaNueva.getTelefono());
        documentPesona.append("direccion", personaNueva.getDireccion());
        documentPesona.append("foto", personaNueva.getFoto());
        documentPesona.append("nombreDepartamento", personaNueva.getNombreDepartamento());

        return documentPesona;
    }
    public static Document crearDepartamentoDocument(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduzca el nombre del departamento");
        String nombreDpto= sc.nextLine();

        Departamentos nuevoDepartamento=new Departamentos(nombreDpto);
        Document documentDpto = new Document();
        documentDpto.append("nombre", nuevoDepartamento.getNombre());
        return documentDpto;
    }

    public static Document actualizarPersonaDocument(Personas persona){
        return null;
    }

    public static Document actualizarDepartamentoDocument(Departamentos departamento){
        return null;
    }


    /**
     * Metodo chapuza que obtiene el hexadecimal de la id de mongo,
     * el cual por defecto se lee como {$oid=numHexadecimal},
     * devolviendolo como unicamente numHexadecimal para que se inserte
     * bien en los objetos
     * @param _id
     * @return
     */
    public static String obtenerIdMongo(String _id){
        String [] primerFiltro= _id.split("=");
        String hexadecimalConLlave= primerFiltro[1]; // contenido de la cadena: numHexadecimal}
        String hexadecimalSinLLave = hexadecimalConLlave.substring(0, hexadecimalConLlave.length() -1); // Remuevo la llave recortando el ultimo caracter
        return hexadecimalSinLLave;
    }
}
