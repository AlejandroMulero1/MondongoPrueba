package org.example;

import com.mongodb.client.*;
import org.bson.Document;
import org.example.Entidades.Departamentos;
import org.example.Entidades.Personas;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Conexion a la db
        Conexion conexionDB= new Conexion();
        MongoClient mongoClient=conexionDB.getClienteDB();
        MongoDatabase database = mongoClient.getDatabase("amulero");
        MongoCollection<Document> collection;
        //Programa
        Class classElegida;
        int opcion=menuEntidades();
        if (opcion==1){
            classElegida= Personas.class;
            collection= database.getCollection("personas");
        }else {
            classElegida = Departamentos.class;
            collection= database.getCollection("departamentos");
        }
        int opcionCrud=menuCrud();
        switch (opcionCrud){
            case 1:
                Document registroInsercion=Utilidades.crearPersonaDocument(database);
                CRUD.Create(collection, registroInsercion);
                break;
            case 2:
                Object registroLectura=CRUD.Read(collection, classElegida);
                System.out.println(registroLectura);
                break;
            case 3:

                break;
            case 4:
                CRUD.Delete(collection, classElegida);
                break;
        }
       mongoClient.close();
    }

    public static int menuEntidades(){
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Con que entidad desea trabajar");
            System.out.println("1:Personas");
            System.out.println("2:Departamentos");
             opcion= sc.nextInt();
        } while(opcion<1 && opcion>2);
        return opcion;
    }
    public static int menuCrud(){
        Scanner sc=new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Que operacion desea hacer");
            System.out.println("1:Crear");
            System.out.println("2:Leer");
            System.out.println("3:Actualizar");
            System.out.println("4:Borrar");
            opcion= sc.nextInt();
        } while(opcion<1 && opcion>4);
        return opcion;
    }
}