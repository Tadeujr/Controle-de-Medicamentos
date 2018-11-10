/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tadeu
 */
public class OperarBd {
    private Connection c;
    private Statement stmt;
    String sql;
    
    public void OperarBd(String sql){
        this.sql = sql;
    }
    public void conetarBanco() throws SQLException, ClassNotFoundException{
        try{
            Class.forName("org.sqlite.JDBC");
            this.c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Opened database successfully");
            stmt.executeUpdate(this.sql); 
            this.stmt = c.createStatement();
            System.out.println("Operação realizada com sucesso.");
        
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + 
             e.getMessage()); 
        }
  }    
    
   public void desconectarBanco() throws SQLException{
      this.stmt.close();
      this.c.close();
    }   

    
    
    
}
