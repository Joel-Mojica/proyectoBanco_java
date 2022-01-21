
package ConeccionBaseDatos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;
    
    
    public static Connection getConexion(){
        status = false;
        String url = "jdbc:sqlserver://LAPTOP-OPAODBPM:1433;databaseName=curso";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "La conexion no pudo ser establecida... revisar driver" + ex.getMessage(), "error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        try{
            contacto = DriverManager.getConnection(url,Conexion.usuario,Conexion.password);
            status = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public static void setCuenta(String usuario,String password){
        Conexion.usuario = usuario;
        Conexion.password = password;
    }
    
    public static boolean getStatus(){
        return status;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null; 
    }
    
}



  