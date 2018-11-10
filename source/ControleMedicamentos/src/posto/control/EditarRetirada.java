
package posto.control;

public class EditarRetirada {
    public void alteraEditaRetiradaQtd(int idRetirada,int qtdNova){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Retirada "+
                         "SET qtd_retirada = '"+qtdNova+"' "+
                         "Where id_retirada='"+idRetirada+"';";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
}
