
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Cliente;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;


public class CadastrarFuncionario{
    protected Funcionario nFuncionario;
    
    
    public void cadastrarFuncionario(Funcionario funcionario){ // guarda em uma Stream

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Conexão Aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO Funcionario (login,senha,tipo,fk_id_pessoa)"
                    + "VALUES ('" + funcionario.getLogin() + 
                    "'," +
                                    funcionario.getSenha() + 
                    ",'" +
                                    funcionario.getTipo() +
                    "','" +
                                    funcionario.getId_pessoa() + 
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
