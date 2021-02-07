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
public class Taller {
    
    private String idTaller;
    private String nombreSucursal;
    private String email;
    private String telefono;
    private String idDireccion;
    private String nombreCalle;
    private String numeroCalle;
    private int idComuna;
    private int idCiudad;

    public Taller(String idTaller, String nombreSucursal, String email, String telefono, String idDireccion, String nombreCalle, String numeroCalle, int idComuna, int idCiudad) {
        this.idTaller = idTaller;
        this.nombreSucursal = nombreSucursal;
        this.email = email;
        this.telefono = telefono;
        this.idDireccion = idDireccion;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.idComuna = idComuna;
        this.idCiudad = idCiudad;
    }

    public Taller() {
    }

    
    
    public String getIdTaller() {
        return idTaller;
    }

    public void setIdTaller(String idTaller) {
        this.idTaller = idTaller;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
    
}
