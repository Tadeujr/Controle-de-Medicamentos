
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Medicamento;


public class deletaMedicmaneto {
    //Deleta medicamento pelo nome.
    public  void deleteMedicamento(String nomeMedicamento) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE from Medicamento where nome=" + nomeMedicamento +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Operation done successfully");
    }   
    //deleta o medicamento pelo ID
    public  void deleteMedicamento(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE from Medicamento where ID=" + id +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Operation done successfully");
    }
}
