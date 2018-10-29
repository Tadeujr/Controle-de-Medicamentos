
package posto.control;

import posto.modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/*
    INSERT INTO table_name (variaveis)
    VALUES (values);
    
*/

public class CadastrarMedicamento {

    public  void InsereMedicamentos(Medicamento medicamento) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO Medicamento (NOME,DESCRICAO,QTD_DISPONIVEL,VALIDADE,LOTE)"
                    + "VALUES ('" + medicamento.getNome() + 
                    "','" + 
                        medicamento.getDescricao() + 
                    "'," +
                        medicamento.getQtdDisponivel() + 
                    ",'" +
                        medicamento.getValidade() +
                    "','" +
                        medicamento.getLote() + 
                    "');";                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Records created successfully");
    }
}