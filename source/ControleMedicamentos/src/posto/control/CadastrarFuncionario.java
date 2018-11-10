
package posto.control;
import posto.modelo.Funcionario;


public class CadastrarFuncionario{
    protected Funcionario nFuncionario;
    
    
    public void cadastrarFuncionario(Funcionario funcionario){ // guarda em uma Stream

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO Funcionario (login,senha,tipo,fk_id_pessoa)"
                    + "VALUES ('" + funcionario.getLogin() + 
                    "'," +
                                    funcionario.getSenha() + 
                    ",'" +
                                    funcionario.getTipo() +
                    "','" +
                                    funcionario.getId_pessoa() + 
                    "');";                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
}
