/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import posto.modelo.Cliente;

/**
 *
 * @author 20142bsi0429
 */
public class ClienteSql {
    /* CADASTRAR */
    public  void cadastrarCliente(Cliente cliente) {
          
        try {
            OperarBd conexao = new OperarBd(); 
            conexao.sql = "INSERT INTO Cliente (cartao_sus,fk_id_pessoa)"
                    + "VALUES ('" + cliente.getCartaoSUS() + 
                    "','" +
                                    cliente.getId_pessoa() + 
                    "');";                        
            conexao.conectarBanco();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        
    }
    
    /* ALTERAR */
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
    
    /* DELETAR */
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
