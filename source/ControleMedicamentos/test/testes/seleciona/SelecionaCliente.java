/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.seleciona;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import posto.control.ClienteSql;
import posto.modelo.Cliente;

/**
 *
 * @author Leonardo
 */
public class SelecionaCliente {
    
    public SelecionaCliente() {
    }
    
    @Test
    public void selecionaCpf() throws SQLException, ClassNotFoundException{
        ClienteSql cliente = new ClienteSql();
        Cliente testa = cliente.selecionarCliente("2424242425");
        String cartaoSus = testa.getCartaoSUS();
        assertEquals("123445678907", cartaoSus);
    }
    
    @Test
     public void selecionaId() throws SQLException, ClassNotFoundException{
        ClienteSql cliente = new ClienteSql();
        Cliente testa = cliente.selecionarClienteId(2);
        String cartaoSus = testa.getCartaoSUS();
        assertEquals("123456", cartaoSus);
    }
}
