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
import static org.junit.Assert.*;
import posto.control.MedicamentoSql;
import posto.modelo.Medicamento;

/**
 *
 * @author Leonardo
 */
public class AdicionaMedicamento {
    
    public AdicionaMedicamento() {
    }
    
    @Test
    public void adicionaMedicamento(){
        try{
            Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
            MedicamentoSql cadMedicamento = new MedicamentoSql();
            cadMedicamento.cadastrarMedicamento(novoMedicamento);
            Medicamento testa = cadMedicamento.selecionarMedicamento("Aradois");
            String nomeMedic = testa.getNome();
            assertEquals("Aradois",nomeMedic);
        }catch(SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
