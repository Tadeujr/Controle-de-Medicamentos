
package posto.control;


public class EditarCliente {
    public void alteraClienteCartaoSUS(int SUSatual,String SUSantigo){

        try {
            OperarBd conexao = new OperarBd();

            conexao.sql = "UPDATE Funcionario "+
                         "SET tipo = '"+SUSatual+"' "+
                         "Where login='"+SUSantigo+"';";
                        
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }         
}
