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
public class Automovil {
    private String idAuto;
    private String patente;
    private String nMotor;
    private String kilometraje;
    private String ano;
    private String idModelo;
    private String idMarca;
    private String idColor;
    private String idCliente;
    private String rutDueno;
    
    public Automovil(){
    }

    public Automovil(String idAuto, String patente, String nMotor, String kilometraje,String ano, String idModelo,String idMarca, String idColor, String idCliente, String rutDueno) {
        this.idAuto = idAuto;
        this.patente = patente;
        this.nMotor = nMotor;
        this.kilometraje = kilometraje;
        this.ano = ano;
        this.idModelo = idModelo;
        this.idMarca = idMarca;
        this.idColor = idColor;
        this.idCliente = idCliente;
        this.rutDueno = rutDueno;
    }
    
    
    
     public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public String getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(String idAuto) {
        this.idAuto = idAuto;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getnMotor() {
        return nMotor;
    }

    public void setnMotor(String nMotor) {
        this.nMotor = nMotor;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(String idModelo) {
        this.idModelo = idModelo;
    }

    public String getIdColor() {
        return idColor;
    }

    public void setIdColor(String idColor) {
        this.idColor = idColor;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public String getRutDueno() {
        return rutDueno;
    }

    public void setRutDueno(String rutDueno) {
        this.rutDueno = rutDueno;
    }
    
    
    
}
