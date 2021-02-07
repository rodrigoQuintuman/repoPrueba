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
public class Color {
    
    private int idColor;
    private String nombreColor;

    public Color(int idColor, String nombreColor) {
        this.idColor = idColor;
        this.nombreColor = nombreColor;
    }

    public Color() {
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getNombreColor() {
        return nombreColor;
    }

    public void setNombreColor(String nombreColor) {
        this.nombreColor = nombreColor;
    }
    
      public String toString(){
    
    return this.nombreColor;
    }
    
    
}
