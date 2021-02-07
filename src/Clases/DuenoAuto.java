package Clases;

/**
 *
 * @author rodrigo
 */
public class DuenoAuto {
    
    private int idDueno;
    private String rutDueno;

    public DuenoAuto(int idDueno, String rutDueno) {
        this.idDueno = idDueno;
        this.rutDueno = rutDueno;
    }

    public DuenoAuto() {
    }

    public int getIdDueno() {
        return idDueno;
    }

    public void setIdDueno(int idDueno) {
        this.idDueno = idDueno;
    }

    public String getRutDueno() {
        return rutDueno;
    }

    public void setRutDueno(String rutDueno) {
        this.rutDueno = rutDueno;
    }
    
      public String toString(){
    
    return this.rutDueno;
    }
    
    
}
