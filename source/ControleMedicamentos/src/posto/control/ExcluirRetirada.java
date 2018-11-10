
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExcluirRetirada {
    public  void deleteRetirada(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Retirada where id_retirada=" + id +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Retirada excluida com sucesso.");
    }    
}
