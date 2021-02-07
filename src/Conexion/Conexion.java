package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *Esta clase permite generar la conexion a la BD en MySql
 * @author rodrigo
 */
public class Conexion {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String pass = "";
    private static final String url = "jdbc:mysql://localhost:3306/taller_mecanico";
    
    /**
     * Este metodo genera la conexion a la BD BDTallerMecanicoRyF
     * @throws SQLException 
     */
    public Conexion() throws SQLException{
    
        try{
        
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                
                System.out.println("Conectado.");
            }
        
        }catch(ClassNotFoundException | SQLException e){
        
           
              System.out.println("Error: "+e.toString());
        }
    
    }
    
    /**
     * este metodo devuelve un objeto Connection 
     * @return objeto Connection
     */
    protected Connection getConnection(){
    
        Connection cn = null;
        try{
              
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e) {
               System.out.println(e);
        }
        return cn;
    
    }
    
    public Connection conectar(){
       return conn;
 
    }

}

