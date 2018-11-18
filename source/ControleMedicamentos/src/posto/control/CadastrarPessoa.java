
package posto.control;
import java.sql.SQLException;
import posto.modelo.Pessoa;


public class CadastrarPessoa {
   
    public  void cadastrarPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {            
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        
        conexao.sql = "INSERT INTO Pessoa (NOME,EMAIL,TELEFONE,ENDERECO,CPF)"
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
        conexao.fecharBanco();
    }   

}

