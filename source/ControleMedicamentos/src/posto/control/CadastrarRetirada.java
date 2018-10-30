
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Medicamento;
import posto.modelo.Retirada;

/*
    INSERT INTO medicamento () 
    VALUES ()
*/

public class CadastrarRetirada {
    public  void cadastrarRetirada(Retirada retirada) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Conexão Aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO retirada (data,qtd_retirada,id_Medicamento,id_pessoa)"
                    + "VALUES ('" + retirada.getData() + 
                    "','" + 
                        retirada.getQtdRetirada() + 
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
        System.out.println("Dados salvos com sucesso.");
    }    
}
