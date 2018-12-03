/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.deleta;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import posto.control.ClienteSql;
import posto.modelo.Cliente;

/**
 *
 * @author Leonardo
 */
public class DeletaCliente {
    
    public DeletaCliente() {
    }
    
    @Test
    public void deletaClienteCartaoSus(){
        try {
            Cliente cliente = new Cliente("Luiz Correia","luizoliveira@cuvox.de","80537658","Rua Trinta e Um 644 Poços de Caldas","22561833941","781223877040003");
            ClienteSql cadastra = new ClienteSql();
            cadastra.cadastrarCliente(cliente);
            cadastra.deleteCliente("781223877040003");
            Cliente testa = cadastra.selecionarCliente("22561833941");
            String nomeCliente = testa.getNome();
            assertEquals(null,nomeCliente);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeletaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deletaClienteId(){
        try {
            Cliente cliente = new Cliente("Luiz Correia","luizoliveira@cuvox.de","80537658","Rua Trinta e Um 644 Poços de Caldas","22561833941","781223877040003");
            ClienteSql cadastra = new ClienteSql();
            cadastra.cadastrarCliente(cliente);
            int id = cadastra.selecionarCliente("22561833941").getIdCliente();
            cadastra.deleteId(id);
            Cliente testa = cadastra.selecionarCliente("22561833941");
            String nomeCliente = testa.getNome();
            assertEquals(null,nomeCliente);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeletaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
