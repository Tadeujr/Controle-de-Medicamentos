/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
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
    
    /* EXIBIR */
    public void exibirCliente() throws SQLException, ClassNotFoundException{
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.rs = conexao.stmt.executeQuery("Select * from Cliente;");
            while(conexao.rs.next()){
                String nome = conexao.rs.getString("nome");
                String email = conexao.rs.getString("email");
                String telefone = conexao.rs.getString("telefone");
                String endereco = conexao.rs.getString("endereco");
                String cpf = conexao.rs.getString("cpf");
                long cartaoSUS = conexao.rs.getLong("cartaoSus");
                System.out.println("nome:" + nome + "\n email: " + email + "\n telefone: " + telefone + "\n endereço: " + endereco + "\n cpf: " + cpf + "\n cartãoSUS" + cartaoSUS);
            }
            conexao.fecharBanco();  
    }
    
    /* SELECIONAR O CLIENTE DESEJADO*/
    public String selecionarCliente(String nomeCliente) throws SQLException, ClassNotFoundException{
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Cliente where nome ='" + nomeCliente+"'");
            while(conexao.rs.next()){
                String nome = conexao.rs.getString("nome");
                String email = conexao.rs.getString("email");
                String telefone = conexao.rs.getString("telefone");
                String endereco = conexao.rs.getString("endereco");
                String cpf = conexao.rs.getString("cpf");
                long cartaoSUS = conexao.rs.getLong("cartaoSus");
                //System.out.println("nome: " + nome + "\n email: " + email + "\n telefone: " + telefone + "\n endereço: " + endereco + "\n cpf: " + cpf + "\n cartãoSUS" + cartaoSUS);
            }
        return conexao.rs.getString("nome");
    }
     
}
