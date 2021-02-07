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
public class Modelo {
    
    private int idModelo;
    private String nombreModelo;
    private int idMarca;

    public Modelo(int idModelo, String nombreModelo, int idMarca) {
        this.idModelo = idModelo;
        this.nombreModelo = nombreModelo;
        this.idMarca = idMarca;
    }

    public Modelo() {
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }
    
     public String toString(){
    
    return this.nombreModelo;
    }
    
    
    
}
