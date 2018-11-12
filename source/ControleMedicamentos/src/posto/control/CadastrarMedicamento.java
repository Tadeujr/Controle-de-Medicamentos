
package posto.control;

import posto.modelo.Medicamento;




public class CadastrarMedicamento {

    public  void cadastrarMedicamento(Medicamento medicamento) {

        try {

            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO Medicamento (NOME,DESCRICAO,QTD_DISPONIVEL,VALIDADE,LOTE)"
                    + "VALUES ('" + medicamento.getNome() + 
                    "','" + 
                        medicamento.getDescricao() + 
                    "'," +
                        medicamento.getQtdDisponivel() + 
                    ",'" +
                        medicamento.getValidade() +
                    "','" +
                        medicamento.getLote() + 
                    "');";
            
            conexao.atualizarBanco();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
}