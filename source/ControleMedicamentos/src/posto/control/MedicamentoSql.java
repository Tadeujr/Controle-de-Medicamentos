/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
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
            conexao.conectarBanco();
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
            
            System.err.println("ERRO método cadastrar Medicamento" + e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* ALTERAR */
    public void alteraMedicamentoNome(String nomeAtual,String nomeAntigo){

        try {
        
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "UPDATE Medicamento "+
                      "SET nome = '"+nomeAtual+"' "+
                      "Where nome='"+nomeAntigo+"';";
            conexao.atualizarBanco();
            
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
            conexao.conectarBanco();
            conexao.sql = "UPDATE Medicamento "+
                         "SET qtd_disponivel = '"+qtdAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
            conexao.atualizarBanco();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        
    }
    
    /* DELETAR */
    public  void deleteMedicamento(String nomeMedicamento) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "DELETE FROM Medicamento where nome= '"  + nomeMedicamento + "' ;";
            conexao.atualizarBanco();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }   
    
    //deleta o medicamento pelo ID
    public  void deleteMedicamentoId(int id) throws SQLException, ClassNotFoundException {

        try {
            
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.rs = conexao.stmt.executeQuery("DELETE FROM Medicamento where id_medicamento=" + id +";");
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }




    }
    
    /* EXIBIR */
    public void exibirMedicamento() throws SQLException, ClassNotFoundException{
        
        try {
            
                OperarBd conexao = new OperarBd();
                conexao.conectarBanco();
                conexao.rs = conexao.stmt.executeQuery("select * from Medicamento;");
                System.out.println("id:\t"+" Nome do Medicamento:\t\t" + "Quatidade ");
                while(conexao.rs.next()) {

                    String nome = conexao.rs.getString("nome");
                    String id = conexao.rs.getString("id_medicamento");
                    String qtd = conexao.rs.getString("qtd_disponivel");
                    System.out.println(id+"\t\t " + nome +"\t\t\t "+qtd);
                }

                conexao.fecharBanco();
            
            } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }        


    }
    
    // selecionar Medicamento escolhido 
    public Medicamento selecionarMedicamento(String nomeMedicamento) throws SQLException, ClassNotFoundException{

        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Medicamento where nome ='" + nomeMedicamento+"'");
        //
        Medicamento drugs = new Medicamento();
        drugs.setNome(conexao.rs.getString("NOME"));
        drugs.setDescricao(conexao.rs.getString("DESCRICAO"));
        drugs.setQtdDisponivel(conexao.rs.getInt("QTD_DISPONIVEL")); 
        drugs.setValidade(conexao.rs.getString("VALIDADE"));
        drugs.setLote(conexao.rs.getString("LOTE"));
        drugs.setId_medicamento(conexao.rs.getInt("id_medicamento"));
           
        conexao.fecharBanco();

        return drugs;        

          

    }
    

}
