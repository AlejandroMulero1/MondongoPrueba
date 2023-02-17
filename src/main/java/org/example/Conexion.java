package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class Conexion {
    private MongoClient clienteDB;

    public Conexion(){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://amulero:1234@cluster0.qrdhcw1.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        clienteDB = MongoClients.create(settings);
    }

    public MongoClient getClienteDB() {
        return clienteDB;
    }
}
