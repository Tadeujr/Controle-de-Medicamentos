/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.adiciona;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AdicionaRetirada {
    
    public AdicionaRetirada() {
    }
    
    @Test
    public void adicionaRetirada(){
        Cliente cliente = new Cliente("Luiz Correia","luizoliveira@cuvox.de","80537658","Rua Trinta e Um 644 Poços de Caldas","22561833941","781223877040003");
        ClienteSql cadastra = new ClienteSql();
        cadastra.cadastrarCliente(cliente);
        Funcionario novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
        FuncionarioSql func = new FuncionarioSql();
        func.cadastrarFuncionario(novoFuncionario);
        Medicamento novoMedicamento = new Medicamento("Aradois","Losartana Potassica","25/08/1999","00035",85);
        MedicamentoSql medic = new MedicamentoSql();
        medic.cadastrarMedicamento(novoMedicamento);
        
        try{
            Retirada novaRetirada = new Retirada(1,cadastra.selecionarCliente("22561833941"),func.selecionarFuncionario("vitoriaCC"),medic.selecionarMedicamento("Aradois"));
            RetiradaSql cadRetirada = new RetiradaSql();
            cadRetirada.cadastrarRetirada(novaRetirada);
            ArrayList <Retirada> testa = cadRetirada.listarRetiradas(1,cadastra.selecionarCliente("22561833941"),func.selecionarFuncionario("vitoriaCC"),medic.selecionarMedicamento("Aradois"));
            int size = testa.size();
            assertEquals(1, size);
        }catch(SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
