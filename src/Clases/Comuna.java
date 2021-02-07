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
public class Comuna {
    
    private int idComuna;
    private String nombreComuna;
    private int idCiudad;

    public Comuna() {
    }

    public Comuna(int idComuna, String nombreComuna, int idCiudad) {
        this.idComuna = idComuna;
        this.nombreComuna = nombreComuna;
        this.idCiudad = idCiudad;
    }

    public int getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(int idComuna) {
        this.idComuna = idComuna;
    }

    public String getNombreComuna() {
        return nombreComuna;
    }

    public void setNombreComuna(String nombreComuna) {
        this.nombreComuna = nombreComuna;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    public String toString(){
    
        return this.nombreComuna;
    }    
    
}
