
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Medicamento;
import posto.modelo.Pessoa;


public class CadastrarPessoa {
    public  void cadastrarPessoa(Pessoa pessoa) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Conexão Aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO Pessoa (NOME,EMAIL,TELEFONE,ENDERECO,CPF)"
                    + "VALUES ('" + pessoa.getNome() + 
                    "','" + 
                        pessoa.getEmail() + 
                    "'," +
                        pessoa.getTelefone() + 
                    ",'" +
                        pessoa.getEndereco() +
                    "','" +
                        pessoa.getCpf() + 
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
