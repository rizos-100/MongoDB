/*
 *  
 *
 */
package org.lacovdevelopers.showquality.controller;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import org.lacovdevelopers.showquality.datos.Conexion;
import org.lacovdevelopers.showquality.model.Proveedor;

/**
 *
 * @author artur
 */
public class ControllerProveedor {
    
    public static final int STATUS_ACTIVO = 1;
    public static final int STATUS_INACTIVO = 0;
    
    public void insertProveedor(Proveedor p) {
         
         // Conexión con mongoDB
         Conexion objConn = new Conexion();
         // Conexión con la base de datos 
         MongoClient mongo = objConn.abrirConexion();
         
         try{

            // Se obtienen todo los metadatos para hacer la inserción, modificación, eliminación y modificación
            DB db = objConn.conexionBaseDatos(mongo);

            // Se crea la conexion con la tabla o coleccion a la cual se agregara la información
            DBCollection coleccion = db.getCollection("proveedores");



            BasicDBObject proveedor = new BasicDBObject();
               proveedor.put("idProveedor", p.getIdProveedor());
               proveedor.put("nombreContacto", p.getNombreContacto());
               proveedor.put("nombreEmpresa", p.getNombreEmpresa());
               proveedor.put("telefonoContacto", p.getTelefonoContacto());
               proveedor.put("direccion", p.getDireccion());
               proveedor.put("correoElectronico", p.getCorreoElectronico());
               proveedor.put("paginaWeb", p.getPaginaWeb());
               proveedor.put("estatus", p.getEstatus());

            coleccion.insert(proveedor);
         
         
         }catch(Exception e){
             e.printStackTrace();
             System.out.println(e.toString());
             
         }finally{
             objConn.cerrarConexion(mongo);
         }

      }
     
    public int obtenerId(){
         
         // Conexión con mongoDB
          Conexion objConn = new Conexion();
         // Conexión con la base de datos 
           MongoClient mongo = objConn.abrirConexion();
         
         int id = 0;
           
         try{
       
            // Se obtienen todo los metadatos para hacer la inserción, modificación, eliminación y modificación
            DB db = objConn.conexionBaseDatos(mongo);

                // Se crea la conexion con la tabla o coleccion a la cual se agregara la información
                   DBCollection coleccion = db.getCollection("proveedores");

                   DBCursor cur = coleccion.find();

                      while (cur.hasNext()){
                        System.out.println(cur.next());
                        id++;
                      }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.toString());
            }finally{
                
                objConn.cerrarConexion(mongo);
            }
         
           return id+1;
     }
     
    public ArrayList<Proveedor> selectAll(){
         
         ArrayList<Proveedor> proveedor = new ArrayList<>();
         
          // Conexión con mongoDB
          Conexion objConn = new Conexion();
         // Conexión con la base de datos 
           MongoClient mongo = objConn.abrirConexion();
           
            JsonParser jp = new JsonParser();
            JsonObject jso;
           
         try{
       
            // Se obtienen todo los metadatos para hacer la inserción, modificación, eliminación y modificación
            DB db = objConn.conexionBaseDatos(mongo);
            // Se crea la conexion con la tabla o coleccion a la cual se agregara la información
            DBCollection coleccion = db.getCollection("proveedores");

            DBCursor cur = coleccion.find();

            while (cur.hasNext()){
                 jso = (JsonObject) jp.parse(String.valueOf(cur.next()));
                 
                 int idProveedor = jso.get("idProveedor").getAsInt();
                 String nomContacto = jso.get("nombreContacto").getAsString();
                 String nomEmpresa = jso.get("nombreEmpresa").getAsString();
                 String telContacto = jso.get("telefonoContacto").getAsString();
                 String direccion = jso.get("direccion").getAsString();
                 String email = jso.get("correoElectronico").getAsString();
                 String web = jso.get("paginaWeb").getAsString();
                 int estatus = jso.get("estatus").getAsInt();
                 
                 if (estatus == STATUS_ACTIVO) {
                     
                     Proveedor objP = new Proveedor(idProveedor,
                                                    nomEmpresa,
                                                    nomContacto,
                                                    telContacto,
                                                    direccion,
                                                    email,
                                                    web,
                                                    estatus);
                     proveedor.add(objP);
                }
               // jso.get("_id").getAsJsonObject().get("$oid").getAsString();

                 
                           
              }

            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.toString());
            }finally{
                
                objConn.cerrarConexion(mongo);
            }
         
         return proveedor;
     }
    
    public void updateProveedor(Proveedor p) {
         
         // Conexión con mongoDB
         Conexion objConn = new Conexion();
         // Conexión con la base de datos 
         MongoClient mongo = objConn.abrirConexion();
         
         try{

            // Se obtienen todo los metadatos para hacer la inserción, modificación, eliminación y modificación
            DB db = objConn.conexionBaseDatos(mongo);

            // Se crea la conexion con la tabla o coleccion a la cual se agregara la información
            DBCollection coleccion = db.getCollection("proveedores");



            BasicDBObject update = new BasicDBObject();
                update.put("$set", new BasicDBObject().
                       append("nombreEmpresa", p.getNombreEmpresa()).
                       append("nombreContacto", p.getNombreContacto()).
                       append("telefonoContacto", p.getTelefonoContacto()).
                       append("direccion", p.getDireccion()).
                       append("correoElectronico", p.getCorreoElectronico()).
                       append("paginaWeb", p.getPaginaWeb())
                        
                );

                BasicDBObject query = new BasicDBObject().append("idProveedor", p.getIdProveedor());

                coleccion.update(query, update);
         
         
         }catch(Exception e){
             e.printStackTrace();
             System.out.println(e.toString());
             
         }finally{
             objConn.cerrarConexion(mongo);
         }

      }
    
    public void deleteProveedor(Proveedor p) {
         
         // Conexión con mongoDB
         Conexion objConn = new Conexion();
         // Conexión con la base de datos 
         MongoClient mongo = objConn.abrirConexion();
         
         try{

            // Se obtienen todo los metadatos para hacer la inserción, modificación, eliminación y modificación
            DB db = objConn.conexionBaseDatos(mongo);

            // Se crea la conexion con la tabla o coleccion a la cual se agregara la información
            DBCollection coleccion = db.getCollection("proveedores");



            BasicDBObject update = new BasicDBObject();
                update.put("$set", new BasicDBObject().
                       append("estatus", STATUS_INACTIVO)   
                );

                BasicDBObject query = new BasicDBObject().append("idProveedor", p.getIdProveedor());

                coleccion.update(query, update);
         
         
         }catch(Exception e){
             e.printStackTrace();
             System.out.println(e.toString());
             
         }finally{
             objConn.cerrarConexion(mongo);
         }

      }

    
}
