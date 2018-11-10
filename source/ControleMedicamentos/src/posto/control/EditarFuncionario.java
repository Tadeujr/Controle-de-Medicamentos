
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class EditarFuncionario {
    public void alteraLogin(String loginAtual,String loginAntigo){

        try {
            OperarBd conexao = new OperarBd();

            conexao.sql = "UPDATE Funcionario "+
                         "SET login = '"+loginAtual+"' "+
                         "Where login='"+loginAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
  
    }     
    
    public void alteraSenha(String login,String senha){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Funcionario "+
                         "SET senha = '"+senha+"' "+
                         "Where login='"+login+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }  
    
    public void alteraTipo(String login,String tipo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Funcionario "+
                         "SET tipo = '"+tipo+"' "+
                         "Where login='"+login+"';";
                        
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
