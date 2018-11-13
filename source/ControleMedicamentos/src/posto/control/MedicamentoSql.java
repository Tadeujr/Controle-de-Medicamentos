/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
import java.util.ArrayList;
import posto.modelo.Medicamento;

/**
 *
 * @author 20142bsi0216
 */
public class MedicamentoSql {
    /* CADASTRAR */
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

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* ALTERAR */
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
    
    /* DELETAR */
    public  void deleteMedicamento(String nomeMedicamento) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Medicamento where nome= '"  + nomeMedicamento + "' ;";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }   
    
    //deleta o medicamento pelo ID
    public  void deleteMedicamentoId(int id) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Medicamento where id_medicamento=" + id +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    
    /* EXIBIR */
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
}
