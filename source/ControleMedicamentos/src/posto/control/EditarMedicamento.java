
package posto.control;

public class EditarMedicamento {
    public void alteraMedicamentoNome(String nomeAtual,String nomeAntigo){
        
        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Medicamento "+
                         "SET nome = '"+nomeAtual+"' "+
                         "Where nome='"+nomeAntigo+"';";
                        
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }        
    
        public void alteraMedicamentoDescricao(String nomeAtual,String descricaoAtual){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Medicamento "+
                         "SET descricao = '"+descricaoAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
                        
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
    
        
    public void alteraMedicamentoQtd(String nomeAtual,int qtdAtual){

        try {
            OperarBd conexao = new OperarBd();

            conexao.sql = "UPDATE Medicamento "+
                         "SET qtd_disponivel = '"+qtdAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
                        
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
}
