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
import posto.control.FuncionarioSql;
import posto.modelo.Funcionario;
import testes.adiciona.AdicionaFuncionario;

/**
 *
 * @author Leonardo
 */
public class AlteraFuncionario {
    
    public AlteraFuncionario() {
    }
    
    @Test
    public void alteraFuncionarioLogin(){
        try {
            Funcionario novoFuncionario;
            novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
            FuncionarioSql cadFuncionario = new FuncionarioSql();
            cadFuncionario.cadastrarFuncionario(novoFuncionario);
            cadFuncionario.alteraLogin("vitoriaCunhaC", "vitoriaCC");
            assertEquals("vitoriaCunhaC",cadFuncionario.selecionarFuncionario("vitoriaCC").getLogin());
        } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void alteraFuncionarioSenha(){
        try {
            Funcionario novoFuncionario;
            novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
            FuncionarioSql cadFuncionario = new FuncionarioSql();
            cadFuncionario.cadastrarFuncionario(novoFuncionario);
            cadFuncionario.alteraSenha("vitoriaCC", "senhadificil");
            assertEquals("senhadificil",cadFuncionario.selecionarFuncionario("vitoriaCC").getSenha());
        } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void alteraFuncionarioTipo(){
        try {
            Funcionario novoFuncionario;
            novoFuncionario = new Funcionario("vitoriaCC","Koebo3","funcionario","Vitoria Cunha","vitoriacc@superrito.com","76778520","Rua Joaquim Pereira Costa 1910 Guaratinguetá","42981008714");
            FuncionarioSql cadFuncionario = new FuncionarioSql();
            cadFuncionario.cadastrarFuncionario(novoFuncionario);
            cadFuncionario.alteraLogin("vitoriaCC", "gerente");
            assertEquals("gerente",cadFuncionario.selecionarFuncionario("vitoriaCC").getTipo());
        } catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
