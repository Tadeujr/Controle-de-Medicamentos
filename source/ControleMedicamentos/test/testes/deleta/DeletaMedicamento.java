/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.deleta;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;
import posto.control.MedicamentoSql;
import posto.modelo.Medicamento;

/**
 *
 * @author Leonardo
 */
public class DeletaMedicamento {
    
    public DeletaMedicamento() {
    }
    
    @Test
    public void deletaMedicamento(){
        try {
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            cadMedicamento.deleteMedicamento("Aradois");
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aradois");
            String nomeMedic = testa.getNome();
            assertEquals(null,nomeMedic);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeletaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void deletaMedicamentoId(){
        try {
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aradois");
            int id = testa.getIdMedicamento();
            cadMedicamento.deleteMedicamentoId(id);
            Medicamento testa1 = cadMedicamento.selecionarMedicamento("Aradois");
            String nomeMedic = testa1.getNome();
            assertEquals(null,nomeMedic);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeletaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
