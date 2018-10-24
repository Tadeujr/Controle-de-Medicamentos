
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
    UPDATE table_name
    SET column1 = value1, column2 = value2, ...
    WHERE condition;
*/

public class atualizarMedicamento {
    public void alteraMedicamentoNome(String nomeAtual,String nomeAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Medicamento "+
                         "SET nome = '"+nomeAtual+"' "+
                         "Where nome='"+nomeAntigo+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }        
    
        public void alteraMedicamentoDescricao(String nomeAtual,String descricaoAtual){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Medicamento "+
                         "SET descricao = '"+descricaoAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }    
    
        
    public void alteraMedicamentoQtd(String nomeAtual,int qtdAtual){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Medicamento "+
                         "SET qtd_disponivel = '"+qtdAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }    
}
