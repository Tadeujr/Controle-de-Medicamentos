
package posto.control;

public class ExcluirPessoa {
 
    public  void deleteId(int id_pessoa) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Pessoa where id_pessoa=" + id_pessoa +";";
 
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    public  void deleteNome(String nome) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Pessoa where nome=" + nome +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }    
    
}
