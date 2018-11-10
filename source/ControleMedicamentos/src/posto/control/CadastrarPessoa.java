
package posto.control;
import posto.modelo.Pessoa;


public class CadastrarPessoa {
    public  void cadastrarPessoa(Pessoa pessoa) {

        try {
            
            OperarBd conexao = new OperarBd();
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

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }   
}
