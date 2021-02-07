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
public class Direccion {
    private String idDireccion;
    private String nombreCalle;
    private String numeroCalle;
    private String idComuna;
    
    public Direccion (){
    }

    public Direccion(String idDireccion, String nombreCalle, String numeroCalle, String idComuna) {
        this.idDireccion = idDireccion;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.idComuna = idComuna;
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

    public String getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(String idComuna) {
        this.idComuna = idComuna;
    }
    
    
    
}
