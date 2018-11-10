
package posto.control;


public class EditarPessoa {
    public void alteraNome(String nomeAtual,String nomeAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET nome = '"+nomeAtual+"' "+
                         "Where nome='"+nomeAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    


    public void alteraEmail(String emailAtual,String emailAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET email = '"+emailAtual+"' "+
                         "Where email='"+emailAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }

    public void alteraCpf(String cpfAtual,String cpfAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET cpf = '"+cpfAtual+"' "+
                         "Where cpf='"+cpfAntigo+"';";
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }

    
    public void alteraEndereco(String enderecoAtual,String enderecoAntigo){

        try {
            
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET endereco = '"+enderecoAtual+"' "+
                         "Where endereco='"+enderecoAntigo+"';";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
    
     
    public void alteraTelefone(String telefoneAtual,String telefoneAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET telefone = '"+telefoneAtual+"' "+
                         "Where telefone='"+telefoneAntigo+"';";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }     
    
}
