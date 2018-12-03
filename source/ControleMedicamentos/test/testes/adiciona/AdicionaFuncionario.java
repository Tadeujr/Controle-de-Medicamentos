package testes.adiciona;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import java.util.logging.*;
import org.junit.Test;
import static org.junit.Assert.*;
import posto.control.FuncionarioSql;
import posto.modelo.Funcionario;

/**
 *
 * @author Leonardo
 */
public class AdicionaFuncionario {
    
    public AdicionaFuncionario() {
    }
    
    @Test
    public void adicionaFuncionario() throws SQLException, ClassNotFoundException{
        try {
            Funcionario novoFuncionario;
            novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
            FuncionarioSql cadFuncionario = new FuncionarioSql();
            cadFuncionario.cadastrarFuncionario(novoFuncionario);
            assertEquals("Vitoria Cunha",cadFuncionario.selecionarFuncionario("vitoriaCC").getNome());
        } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
