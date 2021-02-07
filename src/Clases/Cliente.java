/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author rodrigo
 */
public class Cliente {
    
    private String idCliente;
    private String rut;
    private String dv;
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String telefono;
    private String idDireccion;
    private String nombreCalle;
    private String numeroCalle;
    private int idComuna;
    private int idCiudad;

    public Cliente(String idCliente,String rut,String dv, String nombre, String apePaterno, String apeMaterno, String telefono, String idDireccion, String nombreCalle, String numeroCalle, int idComuna, int idCiudad) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.telefono = telefono;
        this.idDireccion = idDireccion;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.idComuna = idComuna;
        this.idCiudad = idCiudad;    
       
    }
    
    public Cliente(){
    
    }    
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

       public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
    
}
