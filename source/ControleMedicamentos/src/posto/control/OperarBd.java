/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *this.rs = this.stmt.executeQuery(sql);
 * @author tadeu
 */

public class OperarBd {
    public Connection c;
    public Statement stmt;
    public ResultSet rs; 
    String sql;

    public void OperarBd(String sql){
        this.sql = sql;
    }
    
    public void conectarBanco() throws SQLException, ClassNotFoundException{
        
        Class.forName("org.sqlite.JDBC");
        this.c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
        System.out.println("Conexão aberta");
        this.stmt = c.createStatement();
        
        
    } 
    
    
    public void atualizarBanco() throws SQLException, ClassNotFoundException{
        this.conectarBanco();
        stmt.executeUpdate(sql);
        this.fecharBanco();
        
    }
    
            
    public void fecharBanco() throws SQLException{
        this.stmt.close();
        this.c.close();
        System.out.println("Operação realizada com sucesso.");
    }
    
}

