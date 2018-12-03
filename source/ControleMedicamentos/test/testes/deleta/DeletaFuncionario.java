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
import posto.control.FuncionarioSql;
import posto.modelo.Funcionario;

/**
 *
 * @author Leonardo
 */
public class DeletaFuncionario {
    
    public DeletaFuncionario() {
    }
    
    @Test
    public void deletaFuncionario(){
        try {
            Funcionario novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
            FuncionarioSql func = new FuncionarioSql();
            func.cadastrarFuncionario(novoFuncionario);
            func.deleteLogin("vitoriaCC");
            Funcionario testa = func.selecionarFuncionario("vitoriaCC");
            String nomeFunc = testa.getNome();
            assertEquals(null,nomeFunc);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DeletaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
