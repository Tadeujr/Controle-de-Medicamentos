/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.seleciona;

import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;
import posto.control.FuncionarioSql;
import posto.modelo.Funcionario;

/**
 *
 * @author Leonardo
 */
public class SelecionaFuncionario {
    
    public SelecionaFuncionario() {
    }
    
    @Test
     public void selecionaLogin() throws SQLException, ClassNotFoundException{
        FuncionarioSql func = new FuncionarioSql();
        Funcionario testa = func.selecionarFuncionario("tadeujunior");
        String tipo = testa.getTipo();
        assertEquals("gerente", tipo);
    }
     
    @Test
     public void selecionaId() throws SQLException, ClassNotFoundException{
        FuncionarioSql func = new FuncionarioSql();
        Funcionario testa = func.selecionarFuncionarioId(2);
        String login = testa.getLogin();
        assertEquals("tadeujunior", login);
    }
}
