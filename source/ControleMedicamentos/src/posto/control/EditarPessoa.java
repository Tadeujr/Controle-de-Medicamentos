
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class EditarPessoa {
    public void alteraNome(String nomeAtual,String nomeAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Pessoa "+
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


    public void alteraEmail(String emailAtual,String emailAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Pessoa "+
                         "SET email = '"+emailAtual+"' "+
                         "Where email='"+emailAntigo+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }

    public void alteraCpf(String cpfAtual,String cpfAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Pessoa "+
                         "SET cpf = '"+cpfAtual+"' "+
                         "Where cpf='"+cpfAntigo+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }

    
    public void alteraEndereco(String enderecoAtual,String enderecoAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Pessoa "+
                         "SET endereco = '"+enderecoAtual+"' "+
                         "Where endereco='"+enderecoAntigo+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }    
    
     
    public void alteraTelefone(String telefoneAtual,String telefoneAntigo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Pessoa "+
                         "SET telefone = '"+telefoneAtual+"' "+
                         "Where telefone='"+telefoneAntigo+"';";
                        
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
