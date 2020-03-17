/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lacovdevelopers.showquality.datos;

import com.mongodb.MongoClient;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author artur
 */
public class Prueba {
    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        try{
             verBasesDatos(conexion.abrirConexion());
             conexion.cerrarConexion(conexion.abrirConexion());
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.toString());
            conexion.cerrarConexion(conexion.abrirConexion());
        }
       
        
        
    }
    
    public static void verBasesDatos(MongoClient mongo) {
        List dbs = mongo.getDatabaseNames();
        String bases = "";
        for (Object db : dbs) {
            
            bases += " - " + db+"\n";
        }
        
        JOptionPane.showMessageDialog(null, "Bases de datos exitentes\n"+bases,"Consulta de bases" , JOptionPane.INFORMATION_MESSAGE,null);
    }
}
