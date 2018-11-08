
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ExcluirCliente {
    public  void deleteId(int id_cliente) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Cliente where id_cliente=" + id_cliente +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Cliente excluido com sucesso.");
    } 
    
    public  void deleteCartaoSUS(int cartao_sus) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Cliente where cartao_sus=" + cartao_sus +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Cliente excluido com sucesso.");
    }     
}
