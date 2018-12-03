package testes.adiciona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import posto.control.ClienteSql;
import posto.modelo.Cliente;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Leonardo
 */
public class AdicionaCliente {
    
    public AdicionaCliente() {
    }
    
    @Test
    public void adicionaCliente() {
        
        try {
            Cliente cliente = new Cliente("Luiz Correia","luizoliveira@cuvox.de","80537658","Rua Trinta e Um 644 Poços de Caldas","22561833941","781223877040003");
            ClienteSql cadastra = new ClienteSql();
            cadastra.cadastrarCliente(cliente);
            Cliente testa = cadastra.selecionarCliente("22561833941");
            String nomeCliente = testa.getNome();
            assertEquals("Luiz Correia",nomeCliente);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdicionaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
