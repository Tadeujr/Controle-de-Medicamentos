/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.seleciona;


import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import posto.control.ClienteSql;
import posto.control.FuncionarioSql;
import posto.control.MedicamentoSql;
import posto.control.RetiradaSql;
import posto.modelo.Cliente;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;
import posto.modelo.Retirada;

/**
 *
 * @author Leonardo
 */
public class SelecionaRetirada {
    
    public SelecionaRetirada() {
    }

    @Test
     public void selecionaRetirada(){
        RetiradaSql retirada = new RetiradaSql();
        MedicamentoSql medic = new MedicamentoSql();
        ClienteSql cliente = new ClienteSql();
        FuncionarioSql func = new FuncionarioSql();
        try{
            Cliente cli = cliente.selecionarCliente("123456789011");
            Funcionario funcionario = func.selecionarFuncionario("EdlaineBraga");
            Medicamento medicamento = medic.selecionarMedicamentoId(1);

            ArrayList <Retirada> testa = retirada.listarRetiradas(3,cli,funcionario,medicamento);
            int size = testa.size();
            assertEquals(1, size);
        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
    }
}
