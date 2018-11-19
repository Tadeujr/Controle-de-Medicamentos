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
import posto.control.OperarBd;
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
        
        Cliente cliente = new Cliente("Luiz Correia","luizoliveiracorreia@cuvox.de","(35)8053-7658","Rua Trinta e Um 644, Poços de Caldas, MG, 37704-252","225.618.339-41","781223877040003");
        ClienteSql cadastra = new ClienteSql();
        cadastra.cadastrarCliente(cliente);
        
        OperarBd conexao = new OperarBd();
        try {
            conexao.conectarBanco();
            assertEquals(cadastra.selecionarCliente("Luiz Correia"),"Luiz Correia");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdicionaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
