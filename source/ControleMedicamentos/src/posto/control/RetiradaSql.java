/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
import posto.modelo.Retirada;

/**
 *
 * @author 20142bsi0429
 */
public class RetiradaSql {
    /* CADASTRAR */
    // vai receber a id do funcionario no banco 
    public int id_funcionario;
    
    public  void cadastrarRetirada(Retirada retirada) throws SQLException, ClassNotFoundException {
        
        try{
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
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
                    retirada.getFuncionarioRetirada().getId_Funcionario()+
                "');";
            conexao.atualizarBanco();
        }catch(Exception  e){
            System.err.println("ERRO: Método Cadastrar Retirada"  +e.getClass().getName() + ": " + e.getMessage()); 
        }



    }
    
    /* ALTERAR Ta errado isso aqui */
    public void alteraEditaRetiradaQtd(int idRetirada,int qtdNova) throws SQLException, ClassNotFoundException{


        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "UPDATE Retirada "+
                     "SET qtd_retirada = '"+qtdNova+"' "+
                     "Where id_retirada='"+idRetirada+"';";
        conexao.atualizarBanco();

    }
    
    /* DELETAR */
    public  void deleteRetirada(int id) throws SQLException, ClassNotFoundException {

        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "DELETE FROM Retirada where id_retirada=" + id +";";
        conexao.atualizarBanco();

    }
    
}
