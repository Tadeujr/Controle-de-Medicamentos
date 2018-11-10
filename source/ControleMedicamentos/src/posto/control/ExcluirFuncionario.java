
package posto.control;

public class ExcluirFuncionario {
    public  void deleteLogin(String login) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Funcionario where login=" + login +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }  
    
    public  void deleteId(int id_funcionario) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Funcionario where id_funcionario=" + id_funcionario +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }      

}
