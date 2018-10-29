/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;

/**
 *
 * @author tadeu
 */
public class CadastrarFuncionario{
    protected Funcionario nFuncionario;
    
    
    public void cadastrarFuncionario(Funcionario funcionario){ // guarda em uma Stream

/*        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "INSERT INTO funcionario (NOME,DESCRICAO,QTD_DISPONIVEL,VALIDADE,LOTE)"
                    + "VALUES ('" + funcionario.getNome() + 
                    "','" + 
                        funcionario.getDescricao() + 
                    "'," +
                        funcionario.getQtdDisponivel() + 
                    ",'" +
                        funcionario.getValidade() +
                    "','" +
                        funcionario.getLote() + 
                    "');";                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Records created successfully");
    */
    }
    
}
