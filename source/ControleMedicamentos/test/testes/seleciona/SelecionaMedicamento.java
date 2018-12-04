/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.seleciona;


import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import posto.control.MedicamentoSql;
import posto.modelo.Medicamento;

/**
 *
 * @author Leonardo
 */
public class SelecionaMedicamento {
    
    public SelecionaMedicamento() {
    }
    
    @Test
     public void selecionaNome() throws SQLException, ClassNotFoundException{
        MedicamentoSql func = new MedicamentoSql();
        Medicamento testa = func.selecionarMedicamento("Aradois");
        String lote = testa.getLote();
        assertEquals("00035", lote);
    }
     
    @Test
     public void selecionaId() throws SQLException, ClassNotFoundException{
        MedicamentoSql func = new MedicamentoSql();
        Medicamento testa = func.selecionarMedicamentoId(1);
        int qtd = testa.getQtdDisponivel();
        assertEquals(47, qtd);
    }
}
