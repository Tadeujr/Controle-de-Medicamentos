/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.sql.SQLException;
import java.util.ArrayList;
import posto.modelo.Cliente;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;
import posto.modelo.Retirada;

/**
 *
 * @author 20142bsi0429
 */
public class RetiradaSql {

    /* CADASTRAR */
    // vai receber a id do funcionario no banco 
    public int id_funcionario;

    public void cadastrarRetirada(Retirada retirada) throws SQLException, ClassNotFoundException {

        try {
            OperarBd conexao = new OperarBd();
            ClienteSql nc = new ClienteSql();
            FuncionarioSql nf = new FuncionarioSql();
            int id_cliente = nc.selecionarCliente(retirada.getClienteRetirada().getCpf()).getId_cliente();// retirada.getClienteRetirada().getCpf()
            System.out.println(nf.selecionarFuncionario(retirada.getFuncionarioRetirada().getNome()));
            /*conexao.conectarBanco();
            conexao.sql = "INSERT INTO retirada (dataRetirada, horaRetirada, qtd_retirada, fk_id_medicamento, fk_id_cliente, fk_id_funcionario)"
                    + "VALUES ('"
                    + retirada.getData()
                    + "','"
                    + retirada.getHora()
                    + "','"
                    + retirada.getQtdRetirada()
                    + retirada.getMedicamento().getId_medicamento()
                    + "',"
                    + nc.selecionarCliente(retirada.getClienteRetirada().getCpf())
                    + ",'"
                    + nf.selecionarFuncionario(retirada.getFuncionarioRetirada().getLogin())
                    + "');";
            conexao.atualizarBanco();*/
        } catch (Exception e) {
            System.err.println("ERRO: Método Cadastrar Retirada" + e.getClass().getName() + ": " + e.getMessage());
        }

    }

    /* ALTERAR Ta errado isso aqui */
    public void alteraEditaRetiradaQtd(int idRetirada, int qtdNova) throws SQLException, ClassNotFoundException {

        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "UPDATE Retirada "
                + "SET qtd_retirada = '" + qtdNova + "' "
                + "Where id_retirada='" + idRetirada + "';";
        conexao.atualizarBanco();

    }

    /* DELETAR */
    public void deleteRetirada(int id) throws SQLException, ClassNotFoundException {

        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "DELETE FROM Retirada where id_retirada=" + id + ";";
        conexao.atualizarBanco();

    }

    public synchronized ArrayList listarRetiradas(int qtdRetirada, Cliente clienteRetirada, Funcionario funcionarioRetirada, Medicamento medicamento) throws SQLException, ClassNotFoundException {
        ArrayList<Retirada> listarRetiradas = new ArrayList();

        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from retirada;");

        while (conexao.rs.next()) {

            Retirada retirada = new Retirada(qtdRetirada, clienteRetirada, funcionarioRetirada, medicamento);
            retirada.setData(conexao.rs.getString("dataRetirada"));
            retirada.setHora(conexao.rs.getString("horaRetirada"));
            retirada.setId_Retirada(conexao.rs.getInt("id_retirada"));
            retirada.setQtdRetirada(conexao.rs.getInt("qtd_retirada"));
            int idMedicamento = conexao.rs.getInt("fk_id_medicamento");
            MedicamentoSql registro = new MedicamentoSql();
            retirada.setMedicamento(registro.selecionarMedicamentoId(idMedicamento));
            int idFuncionario = conexao.rs.getInt("fk_id_funcionario");
            FuncionarioSql funcionario = new FuncionarioSql();
            retirada.setFuncionarioRetirada(funcionario.selecionarFuncionarioId(idFuncionario));
            int idCliente = conexao.rs.getInt("fk_id_cliente");
            ClienteSql cliente = new ClienteSql();
            retirada.setClienteRetirada(cliente.selecionarClienteId(idMedicamento));

            listarRetiradas.add(retirada);
        }

        conexao.fecharBanco();

        return listarRetiradas;

    }
    
    
    public void ExibirRetirada(ArrayList<Retirada> lstRetirada){
        if(lstRetirada.size() != 0){
            
            for(int i=0;i<lstRetirada.size();i++){
                System.out.println("id:"+lstRetirada.get(i).getId_Retirada());
                System.out.println("Data da Retirada:"+lstRetirada.get(i).getData());
                System.out.println("Hora da Retirada:"+lstRetirada.get(i).getHora());
                System.out.println("Quantidade retirada:"+lstRetirada.get(i).getQtdRetirada());
                System.out.println("Medicamento:"+lstRetirada.get(i).getMedicamento().getNome());
                System.out.println("Cliente:"+lstRetirada.get(i).getClienteRetirada().getNome());
                System.out.println("Funcionario:"+lstRetirada.get(i).getFuncionarioRetirada().getNome());
            }
        }else{
            System.out.println("Lista Vazia.");
    }

}
