package Operaciones;

import Clases.Automovil;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase permite realiar las operaciones CRUD del objeto Automovi
 *
 * @author byron
 */
public class OperacionesAuto {

    /**
     * Este metodo ingresa un los datos de un Automovil a la BD
     *
     * @param auto recibe un objeto Automovil con los datos a ingresar
     * @return true o false segun corresponda
     */
    public boolean ingresarAuto(Automovil auto) {

        Connection conec = null;
        Statement st;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();//se genera la conexion a la BD
            st = conec.createStatement();

            //Query para ingresar una direccion
            String sql = "insert into automovil(PATENTE,ANO,N_MOTOR,KILOMETRAJE,ID_CLIENTE,ID_COLOR,ID_MODELO) values ('" + auto.getPatente() + "'," + auto.getAno() + "," + auto.getnMotor() + "," + auto.getKilometraje() + "," + auto.getIdCliente() + "," + auto.getIdColor() + "," + auto.getIdModelo() + ")";
            st.execute(sql);

            st.close();
            conec.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }
        return true;
    }

    /**
     * Este metodo obtener un los datos de un Automovil a la BD
     *
     * @param patente recibe como parametro la patente del auto a traer
     * @return retorna un bjeto Automovil o null segun corresponda
     */
    public Automovil obtenerAuto(String patente) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();

            String sql = "select ID_AUTO,PATENTE,ANO,N_MOTOR,KILOMETRAJE,a.ID_MODELO,ma.ID_MARCA,a.ID_COLOR,CONCAT(RUT,'',DV)as RUTDV "
                    + "FROM automovil a, modelo mo,marca ma, color co, cliente cl "
                    + "where a.ID_MODELO=mo.ID_MODELO and a.ID_COLOR=co.ID_COLOR and a.ID_CLIENTE=cl.ID_CLIENTE and ma.ID_MARCA=mo.ID_MARCA and PATENTE='" + patente + "'";

            st = conec.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                //Guardamos los datos recuperados del Resulset y los asignamos al objeto correspondientes
                Automovil auto = new Automovil();
                auto.setIdAuto(String.valueOf(rs.getInt("ID_AUTO")));
                auto.setPatente(rs.getString("PATENTE"));
                auto.setAno(String.valueOf(rs.getInt("ANO")));
                auto.setnMotor(String.valueOf(rs.getString("N_MOTOR")));
                auto.setKilometraje(String.valueOf(rs.getString("KILOMETRAJE")));
                auto.setIdModelo(String.valueOf(rs.getString("ID_MODELO")));
                auto.setIdMarca(String.valueOf(rs.getString("ID_MARCA")));
                auto.setIdColor(String.valueOf(rs.getString("ID_COLOR")));
                auto.setRutDueno(rs.getString("RUTDV"));

                st.close();
                rs.close();
                conec.close();
                return auto;
            }

            st.close();
            rs.close();
            conec.close();
            return null;

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
            return null;

        }

    }

    /**
     * Este metodo modifica los datos de un Automovil en la BD
     *
     * @param auto recibe un objeto Automovil con los datos a modificar
     * @return retorna true o false segun corresponda
     */
    public boolean modificarAuto(Automovil auto) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            st = conec.createStatement();
            String sql = "UPDATE automovil SET N_MOTOR=" + auto.getnMotor() + ",KILOMETRAJE=" + auto.getKilometraje() + ",ID_MODELO=" + auto.getIdModelo() + ",ID_COLOR=" + auto.getIdColor() + ",ANO=" + auto.getAno() + " WHERE PATENTE='" + auto.getPatente() + "'";
            st.execute(sql);

            st.close();
            conec.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }

        return true;

    }

    /**
     * Este metodo permite llenar una tabla con los datos de los Automoviles en
     * la BD
     *
     * @param modelo recibe un objeto DefaultTableModel que sera llenado
     * @throws SQLException
     */
    public void llenarTablaAuto(DefaultTableModel modelo) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;
        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            String sql = "select ID_AUTO,PATENTE,KILOMETRAJE,ANO,N_MOTOR,NOMBRE_MARCA,NOMBRE_MODELO,co.NOMBRE,CONCAT(RUT,'',DV)as RUTDV "
                    + "FROM automovil a, modelo mo,marca ma, color co, cliente cl "
                    + "where a.ID_MODELO=mo.ID_MODELO and a.ID_COLOR=co.ID_COLOR and a.ID_CLIENTE=cl.ID_CLIENTE and ma.ID_MARCA=mo.ID_MARCA";

            st = conec.createStatement();
            rs = st.executeQuery(sql);
            Object datos[] = new Object[9];//arreglo de tipo Object donde se almacnaran los registros de la BD de 9 columnas

            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getObject(i + 1);//agregamos el objeto y lo agregamos al arreglo
                }
                modelo.addRow(datos);//agregamos el arreglo a una fila del modelo

            }

            st.close();
            rs.close();
            conec.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

    }

    /**
     * Este metodo busca los datos de un Automovil en la BD y los asigna al
     * objeto DefaultTableModel
     *
     * @param modelo recibe un objeto DefaultTableModel que sera llenado de la
     * BD
     * @param patente recibe como parametro la patente del auto a traer
     * @throws SQLException
     */
    public void buscarAuto(DefaultTableModel modelo, String patente) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        Conexion con = new Conexion();
        conec = con.conectar();
        String sql = "select ID_AUTO,PATENTE,KILOMETRAJE,ANO,N_MOTOR,NOMBRE_MARCA,NOMBRE_MODELO,co.NOMBRE,CONCAT(RUT,'',DV)as RUTDV "
                + "FROM automovil a, modelo mo,marca ma, color co, cliente cl "
                + "where a.ID_MODELO=mo.ID_MODELO and a.ID_COLOR=co.ID_COLOR and a.ID_CLIENTE=cl.ID_CLIENTE and ma.ID_MARCA=mo.ID_MARCA and a.PATENTE='" + patente + "'";

        st = conec.createStatement();
        rs = st.executeQuery(sql);
        Object datos[] = new Object[9];

        while (rs.next()) {
            for (int i = 0; i < datos.length; i++) {

                datos[i] = rs.getObject(i + 1);
            }
            modelo.addRow(datos);
        }

        st.close();
        rs.close();
        conec.close();
    }

    /**
     * Este metodo permite eliminar el registro de un Automovil en la BD
     * @param patente recibe como parametro la patente del auto a eliminar
     * @return retorna true o false segun corresponda
     */
    public boolean eliminarAuto(String patente) {

        Connection conec;
        Statement st;
        ResultSet rs;
        try {

            Conexion con = new Conexion();
            conec = con.conectar();
            st = conec.createStatement();
            String sql3 = "DELETE FROM automovil WHERE patente='" + patente + "'";
            st.execute(sql3);

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;

        }

        return true;

    }

}
