/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  *
 */
package posto.control;

import java.sql.SQLException;
import posto.modelo.Cliente;
import posto.modelo.Pessoa;

/**
 *
 * @author 20142bsi0429
 */
public class ClienteSql {
    /* CADASTRAR */
    public  void cadastrarCliente(Cliente cliente) {
          
        try {
            
            Pessoa nPessoa = new Pessoa(cliente.getNome(),cliente.getEmail(),cliente.getTelefone(),cliente.getEndereco(),cliente.getCpf());
            PessoaSql cadPessoa = new PessoaSql();
            cadPessoa.cadastrarPessoa(nPessoa);
            
            int idPessoa = cadPessoa.buscarIdPessoa(cliente.getCpf());
            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO Cliente (cartao_sus,fk_id_pessoa)"
                    + "VALUES ('" + cliente.getCartaoSUS() + 
                    "','" +
                                    idPessoa + 
                    "');";                        
            conexao.conectarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        
    }
    
    /* ALTERAR  acho qe esse metodo e inutil*/
    public void alteraClienteCartaoSUS(int SUSatual,String SUSantigo){

        try {
            
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "UPDATE Funcionario "+
                         "SET tipo = '"+SUSatual+"' "+
                         "Where login='"+SUSantigo+"';";
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* DELETAR acho que tambem nao tem necessidade */
    public  void deleteId(int id_cliente) {

        try {
            
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql  = "DELETE FROM Cliente where id_cliente=" + id_cliente +";";
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());     
            
        }

    } 
    
    public  void deleteCliente(int cartao_sus) {
        
        try {
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "DELETE FROM Cliente where cartao_sus=" + cartao_sus +";";
            conexao.atualizarBanco();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    

    public Cliente selecionarCliente(String cpf) throws SQLException, ClassNotFoundException{

        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        
        conexao.rs = conexao.stmt.executeQuery("select * from CLIENTE inner join PESSOA on (CLIENTE.fk_id_pessoa = PESSOA.id_pessoa) where cpf ='" + cpf +"'");
        Cliente cliente = new Cliente(conexao.rs.getNString("NOME"),conexao.rs.getNString("EMAIL"),
        conexao.rs.getNString("TELEFONE"),conexao.rs.getNString("ENDERECO"),conexao.rs.getNString("CPF"),
        conexao.rs.getNString("CARTAO_SUS"));

        return cliente;        

    }
 
    public Cliente selecionarClienteId(int idCliente) throws SQLException, ClassNotFoundException{

        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        
        conexao.rs = conexao.stmt.executeQuery("select * from CLIENTE inner join PESSOA on (CLIENTE.fk_id_pessoa = PESSOA.id_pessoa) where id_cliente ='" + idCliente +"'");
        Cliente cliente = new Cliente(conexao.rs.getNString("NOME"),conexao.rs.getNString("EMAIL"),
        conexao.rs.getNString("TELEFONE"),conexao.rs.getNString("ENDERECO"),conexao.rs.getNString("CPF"),
        conexao.rs.getNString("CARTAO_SUS"));
        
        conexao.fecharBanco();
        return cliente;        
    }
     
}
