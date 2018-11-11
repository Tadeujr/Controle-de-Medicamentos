
package posto.control;


public class ExcluirCliente {
    public  void deleteId(int id_cliente) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql  = "DELETE FROM Cliente where id_cliente=" + id_cliente +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    } 
    
    public  void deleteCartaoSUS(int cartao_sus) {
        
        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Cliente where cartao_sus=" + cartao_sus +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }     
}
