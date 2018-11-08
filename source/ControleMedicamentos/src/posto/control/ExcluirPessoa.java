
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class ExcluirPessoa {
 
    public  void deleteId(int id_pessoa) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Pessoa where id_pessoa=" + id_pessoa +";";
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
    public  void deleteNome(String nome) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Pessoa where nome=" + nome +";";
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
