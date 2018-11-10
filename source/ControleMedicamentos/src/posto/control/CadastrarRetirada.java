
package posto.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import posto.modelo.Medicamento;
import posto.modelo.Retirada;

/*
    INSERT INTO medicamento (Data,qtd_retirada,cpf_cliente,fk_Pessoa_Cliente_Funcionario_id_pessoa) 
    VALUES ()

*/

public class CadastrarRetirada {
    public  void cadastrarRetirada(Retirada retirada) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO retirada (dataRetirada,horaRetirada,qtd_retirada,fk_id_medicamento,id_cliente,id_funcionario)"
                    + "VALUES ('" + 
                        retirada.getData() + 
                    "','" + 
                        retirada.getHora()+ 
                    "','" +
                        retirada.getQtdRetirada() + 
                    "'," +
                        retirada.getClienteRetirada().getId_cliente()+ 
                    ",'" +
                        retirada.getFuncionarioRetirada().getId_funcionario() + 
                    "');";                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
}
