package org.example;

import com.mongodb.client.*;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {

        /**
         * Tochazo pa sacar la colección
         */
        Conexion conexionDB= new Conexion();
        MongoClient mongoClient=conexionDB.getClienteDB();

        MongoDatabase database = mongoClient.getDatabase("amulero");
        System.out.println(database.getName());

       MongoCollection< Document > collection = database.getCollection("alumnos");
       CRUD.Read(collection);
       mongoClient.close();
    }

}