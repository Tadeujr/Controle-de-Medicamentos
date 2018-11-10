
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class EditarRetirada {
    public void alteraEditaRetiradaQtd(int idRetirada,int qtdNova){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Retirada "+
                         "SET qtd_retirada = '"+qtdNova+"' "+
                         "Where id_retirada='"+idRetirada+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }    
}
