/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lacovdevelopers.showquality.datos;

import com.mongodb.DB;
import com.mongodb.MongoClient;


/**
 *
 * @author artur
 */
public class Conexion {
    
   private final String server = "localhost";
   private final int puerto = 27017;
   private final String dbMongo = "Showquality";
   
   MongoClient mongoClient = null;
    
   public MongoClient abrirConexion(){
       
       try{
           
         // PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
         mongoClient = new MongoClient(server, puerto);          
           
       }catch(Exception e){
           e.printStackTrace();
           // PASO FINAL: Cerrar la conexion
             mongoClient.close();
       }
       return mongoClient;
   }
   
   public void cerrarConexion(MongoClient mongo){
       try{
           
        if (mongo != null) {
            mongo.close();
            mongo = null;
        }
       
       }catch(Exception e){
           e.printStackTrace();
           
       }
   }
   
   public DB conexionBaseDatos(MongoClient mongo){
       DB db = null;
       try{
           
          db = mongo.getDB(dbMongo);
          System.out.println("Base de datos a conectar -> "+db.toString());
       }catch(Exception ex){
           ex.printStackTrace();
           cerrarConexion(mongo);
       }
       return db;
   }
   
   
}
