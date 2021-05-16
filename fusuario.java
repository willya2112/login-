
package Control_BD;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fusuario {

        Connection cn = null;
 
    private String sSQL = "";
    private final String sSQL2 = "";
    public Integer totalregistros;

 
    public DefaultTableModel login(String usuario,String pasword) {
        cn= ConexionConBaseDatos.getConexion(); 
        DefaultTableModel modelo;
        String[] titulos = {"id", "usuario", "pasword", "tipo", "nombres", "apellidos", "dni", "telefono"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select p.id,p.usuario,p.pasword,p.tipo,"
                + "p.nombres,p.apellidos,p.dni,p.telefono from usuario p "
                + " where p.usuario='"
                + usuario + "' and p.pasword='" + pasword + "'";

        try {
            
            Statement st = cn.createStatement();
           
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                
                registro[0] = rs.getString("id");
                registro[1] = rs.getString("usuario");
                registro[2] = rs.getString("pasword");
                registro[3] = rs.getString("tipo");
                
                registro[4] = rs.getString("nombres");
                registro[5] = rs.getString("apellidos");
                registro[6] = rs.getString("dni");
                registro[7] = rs.getString("telefono");
               
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } 
        catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    
}
