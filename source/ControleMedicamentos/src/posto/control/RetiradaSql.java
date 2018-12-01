/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
import java.util.ArrayList;
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
        public synchronized ArrayList listarRetiradas() throws SQLException, ClassNotFoundException{
        ArrayList<Retirada> listarRetiradas = new ArrayList();    
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from retirada;");
        //
                //
        while(conexao.rs.next()){
            Retirada retirada = new Retirada();
            retirada.setData(conexao.rs.getString("dataRetirada"));
            retirada.setHora(conexao.rs.getString("horaRetirada"));
            retirada.setId_Retirada(conexao.rs.getInt("id_retirada")); 
            retirada.setQtdRetirada(conexao.rs.getInt("qtd_retirada"));
            int idMedicamento = conexao.rs.getInt("fk_id_medicamento");
            MedicamentoSql medicamento = new MedicamentoSql();
            retirada.setMedicamento(medicamento.selecionarMedicamentoId(idMedicamento));
            int idFuncionario = conexao.rs.getInt("fk_id_funcionario");
            FuncionarioSql funcionario = new FuncionarioSql();
            retirada.setFuncionarioRetirada(funcionario.selecionarFuncionarioId(idFuncionario));
            int idCliente = conexao.rs.getInt("fk_id_cliente");
            ClienteSql cliente = new ClienteSql();
            retirada.setClienteRetirada(cliente.selecionarClienteId(idMedicamento));
            
            listarRetiradas.add(retirada);
        }
          
        conexao.fecharBanco();

        conexao.fecharBanco();

        return listarRetiradas;        

    }

}
