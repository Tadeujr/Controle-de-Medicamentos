
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/*
    DELETE FROM table_name
    WHERE conditions;
*/
public class DeletarMedicamento {
    //Deleta medicamento pelo nome.
    public  void deleteMedicamento(String nomeMedicamento) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Medicamento where nome= '"  + nomeMedicamento + "' ;";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Medicamento excluido com sucesso.");
    }   
    //deleta o medicamento pelo ID
    public  void deleteMedicamentoId(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            String sql = "DELETE FROM Medicamento where id_medicamento=" + id +";";
            stmt.executeUpdate(sql);            
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
        System.out.println(
                "Medicamento excluido com sucesso.");
    }
}
