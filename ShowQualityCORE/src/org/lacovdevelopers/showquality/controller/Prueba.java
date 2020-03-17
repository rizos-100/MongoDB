/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lacovdevelopers.showquality.controller;

/**
 *
 * @author artur
 */
public class Prueba {
    
    public static void main(String[] args) {
        ControllerProveedor objP = new ControllerProveedor();
           int id = objP.obtenerId();
           System.out.println("ID: -> "+id);
           
           objP.selectAll().toString();
    }
    
}
