/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.altera;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import posto.control.MedicamentoSql;
import posto.modelo.Medicamento;
import testes.adiciona.AdicionaFuncionario;

/**
 *
 * @author Leonardo
 */
public class AlteraMedicamento {
    
    public AlteraMedicamento() {
    }
    
    @Test
    public void alteraMedicamentoDescricao(){
        try{
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            cadMedicamento.alteraMedicamentoDescricao("Aradois", "Pressão Alta");
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aradois");
            String descMedic = testa.getDescricao();
            assertEquals("Pressão Alta",descMedic);
        }catch(SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void alteraMedicamentoNome(){
        try{
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            cadMedicamento.alteraMedicamentoNome("Aratres", "Aradois");
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aratres");
            String nomeMedic = testa.getNome();
            assertEquals("Aratres",nomeMedic);
        }catch(SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void alteraMedicamentoQtd(){
        try{
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            cadMedicamento.alteraMedicamentoQtd("Aradois", 5);
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aradois");
            int qtdMedic = testa.getQtdDisponivel();
            assertEquals(5,qtdMedic);
        }catch(SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
