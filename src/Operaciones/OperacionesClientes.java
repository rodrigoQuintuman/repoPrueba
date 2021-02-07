/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Clases.Cliente;
import Clases.Direccion;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 * Esta clase permite realiar las operaciones CRUD del objeto Cliente
 *
 * @author rodrigo
 */
public class OperacionesClientes {

    public OperacionesClientes() {
    }

    /**
     * Este metodo realiza la operacion correspondiente para insertar un cliente
     * a la BD taller_mecanico
     *
     * @param dire recibe un objeto Direccion
     * @param cliente recibe un objeto Cliente
     * @return Devuelve un boolena true si ha ingresado un cliente con exito, un
     * null o false en caso de no completar la operacio
     */
    public boolean ingresarCliente(Cliente cliente, Direccion dire) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();//se genera la conexion a la BD
            st = conec.createStatement();

            //Query para ingresar una direccion
            String sql = "insert into direccion(NOMBRE_CALLE,NUMERO,ID_COMUNA) values ('" + dire.getNombreCalle() + "'," + dire.getNumeroCalle() + "," + dire.getIdComuna() + ")";
            System.out.println(sql);
            st.execute(sql);

            //Query para recuperar ultimo id ingresado a la BD
            String sql2 = "select last_insert_id()";
            System.out.println(sql2);
            rs = st.executeQuery(sql2);
            String id = "";
            while (rs.next()) {
                id = String.valueOf(rs.getInt("last_insert_id()"));//recupera el Id de la direccion para asignarsela al cliente 
            }

            //Query para ingresar un cliente
            String sql3 = "insert into cliente(RUT,DV,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,TELEFONO,ID_DIRECCION) values ("
                    + "'" + cliente.getRut() + "','" + cliente.getDv() + "','" + cliente.getNombre() + "','" + cliente.getApePaterno() + "','" + cliente.getApeMaterno() + "'," + cliente.getTelefono() + "," + id + ")";
            System.out.println(sql3);
            st.execute(sql3);

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
     * Este metodo agregas los datos de los clientes de la BD y los almacena en
     * la Tbla correspondiente
     *
     * @param modelo recibe un DefaultTableModel el cual se le almacenaran datos
     */
    public void llenarTablaCliente(DefaultTableModel modelo) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;
        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            String sql = "select ID_CLIENTE,CONCAT(RUT,'',DV)as RUTC,CONCAT(NOMBRE,' ',APELLIDO_PATERNO,' ',APELLIDO_MATERNO) as Nombre,TELEFONO,NOMBRE_CALLE,NUMERO,NOMBRE_COMUNA,NOMBRE_CIUDAD "
                    + "FROM cliente c,direccion d, comuna co, ciudad ci "
                    + "WHERE c.ID_DIRECCION=D.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD";

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
     * Este metodo busca los datos de un Cliente en la BD y los asigna al
     * objeto DefaultTableModel
     *
     * @param modelo recibe un objeto DefaultTableModel que sera llenado de la
     * BD
     * @param rut recibe como parametro el RUT del cliente a traer
     * @param dv recibe como parametro el Digito Verificador del Cliente a traer
     * @throws SQLException
     */
    public void buscarCliente(DefaultTableModel modelo, String rut, String dv) throws SQLException {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        Conexion con = new Conexion();
        conec = con.conectar();
        String sql = "select ID_CLIENTE,CONCAT(RUT,'',DV)as RUTDV,CONCAT(NOMBRE,' ',APELLIDO_PATERNO,' ',APELLIDO_MATERNO) as Nombre,TELEFONO,NOMBRE_CALLE,NUMERO,NOMBRE_COMUNA,NOMBRE_CIUDAD "
                + "FROM cliente c,direccion d, comuna co, ciudad ci "
                + "WHERE c.ID_DIRECCION=D.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD and c.RUT='" + rut + "'";
        System.out.println(sql);
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
     * Este metodo obtener un los datos de un Cliente a la BD
     *
     * @param rut recibe como parametro el rut del Cliente a traer
     * @param dv recibe como parametro el Digito Verificador del Cliente a traer
     * @return retorna un bjeto Cliente o null segun corresponda
     */
    public Cliente obtenerCliente(String rut, String dv) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();

            String sql = "select ID_CLIENTE,RUT,DV,NOMBRE,APELLIDO_PATERNO,APELLIDO_MATERNO,TELEFONO,NOMBRE_CALLE,NUMERO,co.ID_COMUNA,ci.ID_CIUDAD "
                    + "from cliente c,direccion d, comuna co, ciudad ci "
                    + "where c.ID_DIRECCION=D.ID_DIRECCION and d.ID_COMUNA=co.ID_COMUNA and co.ID_CIUDAD=ci.ID_CIUDAD and RUT='" + rut + "'";

            st = conec.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(String.valueOf(rs.getInt("ID_CLIENTE")));
                cliente.setRut(rs.getString("RUT"));
                cliente.setDv(rs.getString("DV"));
                cliente.setNombre(rs.getString("NOMBRE"));
                cliente.setApePaterno(rs.getString("APELLIDO_PATERNO"));
                cliente.setApeMaterno(rs.getString("APELLIDO_MATERNO"));
                cliente.setTelefono(String.valueOf(rs.getInt("TELEFONO")));
                cliente.setNombreCalle(rs.getString("NOMBRE_CALLE"));
                cliente.setNumeroCalle(String.valueOf(rs.getInt("NUMERO")));
                cliente.setIdComuna(rs.getInt("ID_COMUNA"));
                cliente.setIdCiudad(rs.getInt("ID_CIUDAD"));
                st.close();
                rs.close();
                conec.close();
                return cliente;
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
     * Este metodo permite eliminar el registro de un Cliente en la BD
     * @param rut recibe como parametro el Rut del auto a eliminar
     * @return retorna true o false segun corresponda
     */
    public boolean eliminarCliente(String rut) {

        Connection conec;
        Statement st;
        ResultSet rs;
        try {
            String rutSinDV = rut.substring(0, rut.length() - 1);

            Conexion con = new Conexion();
            conec = con.conectar();
            String sql = "select ID_DIRECCION from cliente where RUT='" + rutSinDV + "'";
            st = conec.createStatement();
            rs = st.executeQuery(sql);
            int idDireccion = 0;
            if (rs.next()) {
                idDireccion = rs.getInt("ID_DIRECCION");
            }

            String sql2 = "DELETE from cliente where RUT='" + rutSinDV + "'";
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
     * Este metodo modifica los datos de un Cliente en la BD
     *
     * @param cliente recibe un objeto Cliente con los datos a modificar
     * @param dire recibe un objeto Direccion con los datos a modificar
     * @return retorna true o false segun corresponda
     */
    public boolean modificarCliente(Cliente cliente, Direccion dire) {

        Connection conec = null;
        Statement st;
        ResultSet rs;

        try {
            Conexion con = new Conexion();
            conec = con.conectar();
            st = conec.createStatement();
            String sql = "UPDATE cliente SET TELEFONO=" + cliente.getTelefono() + " WHERE RUT='" + cliente.getRut() + "'";
            st.execute(sql);

            String sql2 = "SELECT ID_DIRECCION FROM cliente WHERE RUT='" + cliente.getRut() + "'";
            rs = st.executeQuery(sql2);
            String id = "";
            while (rs.next()) {

                id = String.valueOf(rs.getInt("ID_DIRECCION"));
            }
            String sql3 = "UPDATE direccion SET NOMBRE_CALLE='" + dire.getNombreCalle() + "',NUMERO=" + dire.getNumeroCalle() + ",ID_COMUNA=" + dire.getIdComuna() + " WHERE ID_DIRECCION=" + id;

            st.execute(sql3);
            st.close();
            conec.close();
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }

        return true;

    }

}
