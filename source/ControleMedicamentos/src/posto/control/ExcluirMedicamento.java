
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/*
    DELETE FROM table_name
    WHERE conditions;
*/
public class ExcluirMedicamento {
    //Deleta medicamento pelo nome.
    public  void deleteMedicamento(String nomeMedicamento) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Medicamento where nome= '"  + nomeMedicamento + "' ;";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }   
    
    //deleta o medicamento pelo ID
    public  void deleteMedicamentoId(int id) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Medicamento where id_medicamento=" + id +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
}
