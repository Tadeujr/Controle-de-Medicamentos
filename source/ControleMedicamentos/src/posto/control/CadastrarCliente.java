/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Cliente;
import posto.modelo.Pessoa;


public class CadastrarCliente {
       public  void cadastrarCliente(Cliente cliente) {

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Conexão Aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO Cliente (cartao_sus,fk_id_pessoa)"
                    + "VALUES ('" + cliente.getCartaoSUS() + 
                    "','" +
                                    cliente.getId_pessoa() + 
                    "');";                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados salvos com sucesso.");
    }     
}


