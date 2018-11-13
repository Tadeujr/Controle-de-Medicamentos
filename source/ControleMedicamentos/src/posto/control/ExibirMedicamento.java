/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;
import java.sql.SQLException;

/**
 *
 * @author tadeu
 */
public class ExibirMedicamento {
    
    public void exibirMedicamento() throws SQLException, ClassNotFoundException{
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Medicamento;");
        System.out.println("id:\t"+" Nome do Medicamento:\t\t" + "Quatidade ");
        while(conexao.rs.next()) {
            
            String nome = conexao.rs.getString("nome");
            String id = conexao.rs.getString("id_medicamento");
            String qtd = conexao.rs.getString("qtd_disponivel");
            System.out.println(id+"\t\t " + nome +"\t\t\t "+qtd);
        }
            
        conexao.fecharBanco();
    }
    
}
