/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.lacovdevelopers.showquality.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.lacovdevelopers.showquality.controller.ControllerProveedor;
import org.lacovdevelopers.showquality.model.Proveedor;

/**
 *
 * @author artur
 */

@Path("proveedor")
public class RESTProveedor extends Application{
    
    public static final int STATUS_ACTIVO = 1;
    public static final int STATUS_INACTIVO = 0;
    
    @POST
    @Path("insert")
    @Produces(MediaType.APPLICATION_JSON)
    
    public Response insert(
                    @FormParam("nomContacto") @DefaultValue("-") String nomContacto,
                    @FormParam("nomEmpresa") @DefaultValue("-") String nomEmpresa,
                    @FormParam("telContacto") @DefaultValue("-") String telContacto,
                    @FormParam("direccion") @DefaultValue("-") String direccion,
                    @FormParam("email") @DefaultValue("-") String email,
                    @FormParam("paginaWeb") @DefaultValue("-") String paginaWeb
                    ){
        
       ControllerProveedor ctrlP = new ControllerProveedor();
       Proveedor objP = new Proveedor();
            objP.setIdProveedor(ctrlP.obtenerId());
            objP.setNombreContacto(nomContacto);
            objP.setNombreEmpresa(nomEmpresa);
            objP.setTelefonoContacto(telContacto);
            objP.setDireccion(direccion);
            objP.setCorreoElectronico(email);
            objP.setPaginaWeb(paginaWeb);
            objP.setEstatus(STATUS_ACTIVO);
        
        String salida = null;
        try{
            ctrlP.insertProveedor(objP);
            salida = "{\"result\":\"OK\"}";
        }catch(Exception e){
            salida = "{\"error:\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(salida).build();
    
    }
    
    @GET
    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        ArrayList <Proveedor> proveedor = null;
        Gson json = new Gson();
        
        ControllerProveedor ctrlP= new ControllerProveedor();
        
        String salida = null;
        try{
            proveedor = ctrlP.selectAll();
            salida = json.toJson(proveedor);
        }catch(Exception e){
            e.printStackTrace();
            salida = "{\"error:\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(salida).build();
    }
    
    @POST
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(
                    @FormParam("nomContacto") @DefaultValue("-") String nomContacto,
                    @FormParam("nomEmpresa") @DefaultValue("-") String nomEmpresa,
                    @FormParam("telContacto") @DefaultValue("-") String telContacto,
                    @FormParam("direccion") @DefaultValue("-") String direccion,
                    @FormParam("email") @DefaultValue("-") String email,
                    @FormParam("paginaWeb") @DefaultValue("-") String paginaWeb,
                    @FormParam("idProveedor") @DefaultValue("0") int id
                    ){
        
       ControllerProveedor ctrlP = new ControllerProveedor();
       Proveedor objP = new Proveedor();
            objP.setIdProveedor(id);
            objP.setNombreContacto(nomContacto);
            objP.setNombreEmpresa(nomEmpresa);
            objP.setTelefonoContacto(telContacto);
            objP.setDireccion(direccion);
            objP.setCorreoElectronico(email);
            objP.setPaginaWeb(paginaWeb);
            
        
        String salida = null;
        try{
            ctrlP.updateProveedor(objP);
            salida = "{\"result\":\"OK\"}";
        }catch(Exception e){
            salida = "{\"error:\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(salida).build();
    
    }
    
    @POST
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(
                    @FormParam("id") @DefaultValue("0") int id
                    ){
        
       ControllerProveedor ctrlP = new ControllerProveedor();
       Proveedor objP = new Proveedor();
            objP.setIdProveedor(id);
            
        String salida = null;
        try{
            ctrlP.deleteProveedor(objP);
            salida = "{\"result\":\"OK\"}";
        }catch(Exception e){
            salida = "{\"error:\""+e.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(salida).build();
    
    }

}