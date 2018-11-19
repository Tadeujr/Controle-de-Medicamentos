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
import posto.control.OperarBd;
import posto.modelo.Funcionario;

/**
 *
 * @author Leonardo
 */
public class AdicionaFuncionario {
    
    public AdicionaFuncionario() {
    }
    
    @Test
    public void adicionaFuncionario(){
        
        Funcionario funcionario = new Funcionario("vitoriaCC","coom6Koebo3","funcionario","Vitória Cunha","vitoriacccunha@superrito.com","(12)7677-8520","Rua Joaquim Pereira Costa 1910, Guaratinguetá, SP, 12514-070","429.810.087-14");
        FuncionarioSql cadastra = new FuncionarioSql();
        cadastra.cadastrarFuncionario(funcionario);
        
        OperarBd conexao = new OperarBd();
        try {
            conexao.conectarBanco();
            assertEquals(cadastra.selecionarFuncionario("vitoriaCC"),"vitoriaCC");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdicionaFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
