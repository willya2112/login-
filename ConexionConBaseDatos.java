
package Control_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionConBaseDatos {
     
    
    
    public static Connection conexion = null;
    public static Connection getConexion() {
        try {
           conexion = null;
          
           Class.forName("com.mysql.jdbc.Driver");
           
           conexion =DriverManager.getConnection("jdbc:mysql://localhost/nueva","root","");
           
          
           System.out.println("conexion establecida");
       } catch (ClassNotFoundException | SQLException e) {
           
           System.out.println("error de conexion");
           JOptionPane.showMessageDialog(null, "error de conexion "+e);
       }

        return conexion;
    }
    
}
