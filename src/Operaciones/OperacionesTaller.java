package Operaciones;

import Clases.Direccion;
import Clases.Taller;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *Esta clase permite realiar las operaciones CRUD del objeto Taller
 * @author javierOrellana
 */
public class OperacionesTaller {

    public OperacionesTaller() {
    }

    /**
     * Este metodo realiza la operacion correspondiente para insertar un Taller
     * a la BD taller_mecanico
     *
     * @param dire recibe un objeto Direccion
     * @param taller recibe un objeto Cliente
     * @return Devuelve un boolena true si ha ingresado un Taller con exito, un
     * null o false en caso de no completar la operacion
     */
    public boolean ingresarTaller(Taller taller, Direccion dire) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();//se genera la conexion a la BD
            st = conec.createStatement();

            //Query para ingresar una direccion
            String sql = "insert into direccion(NOMBRE_CALLE,NUMERO,ID_COMUNA) values ('" + dire.getNombreCalle() + "'," + dire.getNumeroCalle() + "," + dire.getIdComuna() + ")";
            st.execute(sql);

            //Query para recuperar ultimo id ingresado a la BD
            String sql2 = "select last_insert_id()";     
            rs = st.executeQuery(sql2);
            String id = "";
            while (rs.next()) {
                id = String.valueOf(rs.getInt("last_insert_id()"));//recupera el Id de la direccion para asignarsela al taller 
            }

            //Query para ingresar un taller
            String sql3 = "insert into taller(NOMBRE_TALLER,EMAIL,ID_DIRECCION) values ("
                    + "'" + taller.getNombreSucursal() + "','" + taller.getEmail() + "'," + id + ")";
            st.execute(sql3);

            //Query para recuperar ultimo id ingresado a la BD
            String sql4 = "select last_insert_id()";
            rs = st.executeQuery(sql4);
            String idTaller = "";
            while (rs.next()) {
                idTaller = String.valueOf(rs.getInt("last_insert_id()"));//recupera el Id del taller para asignarsela a la tabla Contacto 
            }

            String sql5 = "insert into contacto(TELEFONO,ID_TALLER) values(" + taller.getTelefono() + "," + idTaller + ")";       
            st.execute(sql5);

            rs.close();
            st.close();
            conec.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }

        return true;

    }

    /**
     * Este metodo agrega los datos del taller de la BD y los almacena en la
     * Tbla correspondiente
     *
     * @param modelo recibe un DefaultTableModel el cual se le almacenaran datos
     */
    public void llenarTablaTaller(DefaultTableModel modelo) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;
        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            String sql = "select t.ID_TALLER,NOMBRE_TALLER,EMAIL,NOMBRE_CALLE,NUMERO,NOMBRE_COMUNA,NOMBRE_CIUDAD,TELEFONO "
                    + "FROM taller t,direccion d, comuna co, ciudad ci, contacto con "
                    + "WHERE t.ID_DIRECCION=d.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD and con.ID_TALLER=t.ID_TALLER ";

            st = conec.createStatement();
            rs = st.executeQuery(sql);
            Object datos[] = new Object[8];//arreglo de tipo Object donde se almacnaran los registros de la BD

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
     * Este metodo busca los datos de un Taller en la BD y los asigna al
     * objeto DefaultTableModel
     *
     * @param modelo recibe un objeto DefaultTableModel que sera llenado de la
     * BD
     * @param nombre recibe como parametro el nombre del Taller a traer
     * @throws SQLException
     */
    public void buscarTaller(DefaultTableModel modelo, String nombre) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        Conexion con = new Conexion();
        conec = con.conectar();
        String sql = "select t.ID_TALLER,NOMBRE_TALLER,EMAIL,NOMBRE_CALLE,NUMERO,NOMBRE_COMUNA,NOMBRE_CIUDAD,con.TELEFONO "
                + "FROM taller t,direccion d, comuna co, ciudad ci, contacto con "
                + "WHERE t.ID_DIRECCION=d.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD and con.ID_TALLER=t.ID_TALLER and NOMBRE_TALLER='" + nombre + "'";
        
        st = conec.createStatement();
        rs = st.executeQuery(sql);
        Object datos[] = new Object[8];

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
     * Este metodo obtener un los datos de un Taller de la BD
     * @param nombre recibe como parametro el nombre del Taller a traer
     * @return retorna un bjeto Taller o null segun corresponda
     */
    public Taller obtenerTaller(String nombre) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();

            String sql = "select t.ID_TALLER,NOMBRE_TALLER,EMAIL,NOMBRE_CALLE,NUMERO,co.ID_COMUNA,ci.ID_CIUDAD,con.TELEFONO "
                    + "FROM taller t,direccion d, comuna co, ciudad ci, contacto con "
                    + "WHERE t.ID_DIRECCION=d.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD and con.ID_TALLER=t.ID_TALLER and NOMBRE_TALLER='" + nombre + "'";
            
            st = conec.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Taller taller = new Taller();
             
                taller.setNombreSucursal(rs.getString("NOMBRE_TALLER"));
                taller.setEmail(rs.getString("EMAIL"));
                taller.setNombreCalle(rs.getString("NOMBRE_CALLE"));
                taller.setNumeroCalle(String.valueOf(rs.getString("NUMERO")));
                taller.setIdComuna(rs.getInt("ID_COMUNA"));
                taller.setIdCiudad(rs.getInt("ID_CIUDAD"));
                taller.setTelefono(String.valueOf(rs.getString("TELEFONO")));

                st.close();
                rs.close();
                conec.close();
                return taller;
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
     * Este metodo permite eliminar el registro de un Taller en la BD
     * @param nombre recibe como parametro el nombre del Taller a eliminar
     * @return retorna true o false segun corresponda
     */
    public boolean eliminarTaller(String nombre) {

        Connection conec;
        Statement st;
        ResultSet rs;
        try {

            Conexion con = new Conexion();
            conec = con.conectar();

            String sql0 = "select ID_TALLER from taller where NOMBRE_TALLER='" + nombre + "'";
            st = conec.createStatement();
            rs = st.executeQuery(sql0);
            int idTaller = 0;
            if (rs.next()) {
                idTaller = rs.getInt("ID_TALLER");
            }

            String sqll = "DELETE from contacto where ID_TALLER=" + idTaller;
            st.execute(sqll);

            String sql = "select ID_DIRECCION from taller where NOMBRE_TALLER='" + nombre + "'";
            st = conec.createStatement();
            rs = st.executeQuery(sql);
            int idDireccion = 0;
            if (rs.next()) {
                idDireccion = rs.getInt("ID_DIRECCION");
            }

            String sql2 = "DELETE from taller where NOMBRE_TALLER='" + nombre + "'";
            st.execute(sql2);

            String sql3 = "DELETE from direccion where ID_DIRECCION=" + idDireccion;
            st.execute(sql3);

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
            return false;

        }

        return true;

    }
    
    /**
     * Este metodo modifica los datos de un Taller en la BD
     * @param taller recibe un objeto Taller con los datos a modificar
     * @param dire recibe un objeto Direccion con los datos a modificar
     * @return retorna true o false segun corresponda
     */
    public boolean modificarTaller(Taller taller, Direccion dire) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            st = conec.createStatement();

            String sql2 = "SELECT ID_DIRECCION FROM taller WHERE NOMBRE_TALLER='" + taller.getNombreSucursal() + "'";
            rs = st.executeQuery(sql2);
            String id = "";
            while (rs.next()) {

                id = String.valueOf(rs.getInt("ID_DIRECCION"));
            }
            String sql3 = "UPDATE direccion SET NOMBRE_CALLE='" + dire.getNombreCalle() + "',NUMERO=" + dire.getNumeroCalle() + ",ID_COMUNA=" + dire.getIdComuna() + " WHERE ID_DIRECCION=" + id;

            st.execute(sql3);

            String sql4 = "SELECT ID_TALLER FROM taller WHERE NOMBRE_TALLER='" + taller.getNombreSucursal() + "'";
            rs = st.executeQuery(sql4);
            String idTaller = "";
            while (rs.next()) {

                idTaller = String.valueOf(rs.getInt("ID_TALLER"));
            }
            String sql5 = "UPDATE contacto SET TELEFONO=" + taller.getTelefono() + " WHERE ID_TALLER=" + idTaller;
            st.execute(sql5);

            String sql = "UPDATE taller SET NOMBRE_TALLER='" + taller.getNombreSucursal() + "',EMAIL='" + taller.getEmail() + "' WHERE NOMBRE_TALLER='" + taller.getNombreSucursal() + "'";
            st.execute(sql);

            st.close();
            conec.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }

        return true;

    }

}
