package Operaciones;

import Clases.Ciudad;
import Clases.Color;
import Clases.Comuna;
import Clases.DuenoAuto;
import Clases.Marca;
import Clases.Modelo;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Esta Clase nos permite llenar los JComboBox con sus objetos correspondiente
 * objetos que seran asignados con infomacion de la BD
 *
 * @author rodrigo
 */
public class LlenarCombo {

    public LlenarCombo() {
    }

    /**
     * Metodo que permite traer los datos de Ciudad de la BD y asignarlos al
     * JCombo correspondiente
     *
     * @param jcCiudad recibe un JCombioBox que sera llenado con las ciudades
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboCiudad(JComboBox jcCiudad) throws SQLException {

        DefaultComboBoxModel modelo;
        Connection conec;
        Statement st;
        ResultSet rs;
        try {
            Conexion conn = new Conexion();
            conec = conn.conectar();
            st = conec.createStatement();
            String sql = "select * from taller_mecanico.ciudad";
            rs = st.executeQuery(sql);
            modelo = new DefaultComboBoxModel();//modelo que sera asignado al JCombo Correspondiente
            jcCiudad.setModel(modelo);
            jcCiudad.getModel();
            while (rs.next()) {
                if (rs.isFirst()) {
                    Ciudad ci = new Ciudad();
                    //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                    ci.setNombreCiudad("Seleccione Ciudad");//nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                    modelo.addElement(ci);
                }
                
                //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                modelo.addElement(new Ciudad(rs.getInt("ID_CIUDAD"), rs.getString("NOMBRE_CIUDAD")));
            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Metodo que permite traer los datos de Comuna de la BD y asignarlos al
     * JCombo correspondiente
     *
     * @param jcComuna recibe un JCombioBox que sera llenado con las comunas
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboComuna(JComboBox jcComuna, int id) throws SQLException {

        int idC = id;

        if (idC == 0) {
            DefaultComboBoxModel mode = new DefaultComboBoxModel();
            Comuna ci = new Comuna();
            ci.setNombreComuna("Seleccione Comuna");
            mode.addElement(ci);
            jcComuna.setModel(mode);

        } else {

            Connection conec;
            Statement st;
            ResultSet rs;

            try {
                Conexion conn = new Conexion();
                conec = conn.conectar();
                st = conec.createStatement();
                String sql = "select * from taller_mecanico.comuna where id_ciudad=" + idC;
                rs = st.executeQuery(sql);
                DefaultComboBoxModel modeloC = new DefaultComboBoxModel();//modelo que sera asignado al JCombo Correspondiente
                jcComuna.setModel(modeloC);
                while (rs.next()) {
                    if (rs.isFirst()) {
                        Comuna ci = new Comuna();
                         //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                        ci.setNombreComuna("Seleccione Comuna");
                        modeloC.addElement(ci);
                    }
                    
                    //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                    modeloC.addElement(new Comuna(rs.getInt("ID_COMUNA"), rs.getString("NOMBRE_COMUNA"), rs.getInt("ID_CIUDAD")));
                }
                conec.close();
                st.close();
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error " + e);
                Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
            }

        }
    }

    /**
     * Metodo que permite traer los datos de Marca de Automoviles de la BD y
     * asignarlos al JCombo correspondiente
     *
     * @param jcMarca recibe un JCombioBox que sera llenado con las Marcas
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboMarca(JComboBox jcMarca) throws SQLException {

        DefaultComboBoxModel modelo;
        Connection conec;
        Statement st;
        ResultSet rs;
        try {
            Conexion conn = new Conexion();
            conec = conn.conectar();
            st = conec.createStatement();
            String sql = "select * from taller_mecanico.marca";
            rs = st.executeQuery(sql);
            modelo = new DefaultComboBoxModel();//modelo que sera asignado al JCombo Correspondiente
            jcMarca.setModel(modelo);
            jcMarca.getModel();
            while (rs.next()) {
                if (rs.isFirst()) {
                    Marca marca = new Marca();
                     //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                    marca.setNombreMarca("Seleccione Marca");
                    modelo.addElement(marca);
                }
                
                //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                modelo.addElement(new Marca(rs.getInt("ID_MARCA"), rs.getString("NOMBRE_MARCA")));
            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Metodo que permite traer los datos de Modelos de marcas de auto de la BD
     * y asignarlos al JCombo correspondiente
     *
     * @param jcModelo recibe un JCombioBox que sera llenado con las Modelso
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboModelo(JComboBox jcModelo, int id) throws SQLException {

        int idC = id;

        if (idC == 0) {
            DefaultComboBoxModel mode = new DefaultComboBoxModel();
            Modelo mo = new Modelo();
            mo.setNombreModelo("Seleccione Modelo");
            mode.addElement(mo);
            jcModelo.setModel(mode);

        } else {

            Connection conec;
            Statement st;
            ResultSet rs;

            try {
                Conexion conn = new Conexion();
                conec = conn.conectar();
                st = conec.createStatement();
                String sql = "select * from taller_mecanico.modelo where id_marca=" + idC;
                rs = st.executeQuery(sql);
                DefaultComboBoxModel modeloM = new DefaultComboBoxModel();//modelo que sera asignado al JCombo Correspondiente
                jcModelo.setModel(modeloM);
                while (rs.next()) {
                    if (rs.isFirst()) {
                        Modelo mod = new Modelo();
                         //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                        mod.setNombreModelo("Seleccione Modelo");
                        modeloM.addElement(mod);
                    }
                    
                    //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                    modeloM.addElement(new Modelo(rs.getInt("ID_MODELO"), rs.getString("NOMBRE_MODELO"), rs.getInt("ID_MARCA")));
                }
                conec.close();
                st.close();
                rs.close();
            } catch (SQLException e) {
                System.out.println("Error " + e);
                Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
            }

        }

    }

    /**
     * Metodo que permite traer los datos de Color de la BD y asignarlos al
     * JCombo correspondiente
     *
     * @param jcColor recibe un JCombioBox que sera llenado con las colores
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboColor(JComboBox jcColor) throws SQLException {

        DefaultComboBoxModel modelo;
        Connection conec;
        Statement st;
        ResultSet rs;
        try {
            Conexion conn = new Conexion();
            conec = conn.conectar();
            st = conec.createStatement();
            String sql = "select * from taller_mecanico.color";
            rs = st.executeQuery(sql);
            modelo = new DefaultComboBoxModel();//modelo que sera asignado al JCombo Correspondiente
            jcColor.setModel(modelo);
            jcColor.getModel();
            while (rs.next()) {
                if (rs.isFirst()) {
                    Color color = new Color();
                     //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                    color.setNombreColor("Seleccione Color");
                    modelo.addElement(color);
                }
                
                //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                modelo.addElement(new Color(rs.getInt("ID_COLOR"), rs.getString("NOMBRE")));
            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    /**
     * Metodo que permite traer los datos de los Rut Almacenados en la BD y asignarlos al
     * JCombo correspondiente
     *
     * @param jcRutDueno  recibe un JCombioBox que sera llenado con las Rut's
     * correspondientes
     * @throws SQLException
     */
    public void llenarComboRutDueno(JComboBox jcRutDueno) throws SQLException {

        DefaultComboBoxModel modelo;
        Connection conec;
        Statement st;
        ResultSet rs;
        try {
            Conexion conn = new Conexion();
            conec = conn.conectar();
            st = conec.createStatement();
            String sql = "select ID_CLIENTE,CONCAT(RUT,'',DV)as RUTC from cliente;";
            rs = st.executeQuery(sql);
            modelo = new DefaultComboBoxModel();
            jcRutDueno.setModel(modelo);
            jcRutDueno.getModel();
            while (rs.next()) {
                if (rs.isFirst()) {
                    DuenoAuto dueno = new DuenoAuto();
                     //nombre por defecto del primer objeto que es asignado antes de recuperar la los datos del Resulset
                    dueno.setRutDueno("Seleccione Rut Dueño");
                    modelo.addElement(dueno);
                }
                
                //Creamos un objeto con los datos obtenidos de la consulat y lo agregamos al modelo(DefaultComboBoxModel)
                modelo.addElement(new DuenoAuto(rs.getInt("ID_CLIENTE"), rs.getString("RUTC")));
            }
            conec.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            Logger.getLogger(LlenarCombo.class.getName()).log(Level.SEVERE, null, e);
        }

    }

}
