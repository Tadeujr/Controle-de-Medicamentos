/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import posto.modelo.Retirada;

/**
 *
 * @author 20142bsi0429
 */
public class RetiradaSql {
    /* CADASTRAR */
    // vai receber a id do funcionario no banco 
    private int id_funcionario;
    public  void cadastrarRetirada(Retirada retirada) {
        
        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO retirada (dataRetirada,horaRetirada,qtd_retirada,fk_id_medicamento,id_cliente,id_funcionario)"
                    + "VALUES ('" + 
                        retirada.getData() + 
                    "','" + 
                        retirada.getHora()+ 
                    "','" +
                        retirada.getQtdRetirada() + 
                    "'," +
                        retirada.getClienteRetirada().getId_cliente()+ 
                    ",'" +
                        id_funcionario + 
                    "');";                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* ALTERAR */
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
    
    /* DELETAR */
    public  void deleteRetirada(int id) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Retirada where id_retirada=" + id +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    
    /*
    / EXIBIR /
    public synchronized ArrayList selecionarMedicamento() throws SQLException, ClassNotFoundException{
        ArrayList listaMedicamento = new ArrayList();
        try{
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.rs = conexao.stmt.executeQuery("Select * from medicamento;");
            while(conexao.rs.next()){
                Medicamento drugs = new Medicamento();
                drugs.setId_medicamento(conexao.rs.getInt("ID_MEDICAMENTO"));
                drugs.setDescricao(conexao.rs.getString("DESCRICAO"));
                drugs.setNome(conexao.rs.getString("NOME"));
                drugs.setValidade(conexao.rs.getString("VALIDADE"));
                drugs.setLote(conexao.rs.getString("LOTE"));
                drugs.setQtdDisponivel(conexao.rs.getInt("QTD_DISPONIVEL"));
                listaMedicamento.add(drugs);
            }
            conexao.fecharBanco();
            return listaMedicamento;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Não foi possível conectar ao DB");
            return listaMedicamento;
        }  
    }
    */
}
