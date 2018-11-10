
package posto.control;


public class ExcluirRetirada {
    public  void deleteRetirada(int id) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Retirada where id_retirada=" + id +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }    
}
