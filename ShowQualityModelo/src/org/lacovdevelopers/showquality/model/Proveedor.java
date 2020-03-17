/*
 * Se creó el modelo del proveedor, y se agregarón
 * los Getters y Setter asi como su toString
 * 
 */
package org.lacovdevelopers.showquality.model;

/**
 *
 * @author artur
 */
public class Proveedor {
    
    private int idProveedor;
    private String nombreEmpresa;
    private String nombreContacto;
    private String telefonoContacto;
    private String direccion;
    private String correoElectronico;
    private String paginaWeb;
    private int estatus;

    public Proveedor(int idProveedor, String nombreEmpresa, String nombreContacto, String telefonoContacto, String direccion, String correoElectronico, String paginaWeb, int estatus) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.paginaWeb = paginaWeb;
        this.estatus = estatus;
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombreEmpresa=" + nombreEmpresa + ", nombreContacto=" + nombreContacto + ", telefonoContacto=" + telefonoContacto + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + ", paginaWeb=" + paginaWeb + ", estatus=" + estatus + '}';
    }

    
    
    
}
