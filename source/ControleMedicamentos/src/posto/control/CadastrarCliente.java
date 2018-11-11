/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;
import posto.modelo.Cliente;

public class CadastrarCliente {
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
}


