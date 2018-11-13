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
import posto.modelo.Funcionario;

/**
 *
 * @author 20142bsi0429
 */
public class FuncionarioSql {
    /* CADASTRAR */
    protected Funcionario nFuncionario;
    
    public void cadastrarFuncionario(Funcionario funcionario){ // guarda em uma Stream
        
        // criar uma função para pegar o id do funcionário na tabela pessoa 
        String fk_id_pessoa = "";
        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "INSERT INTO Funcionario (login,senha,tipo,fk_id_pessoa)"
                    + "VALUES ('" + funcionario.getLogin() + 
                    "'," +
                                    funcionario.getSenha() + 
                    ",'" +
                                    funcionario.getTipo() +
                    "','" +
                                    fk_id_pessoa + 
                    "');";                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* ALTERAR */
    public void alteraLogin(String loginAtual,String loginAntigo){

        try {
            OperarBd conexao = new OperarBd();

            conexao.sql = "UPDATE Funcionario "+
                         "SET login = '"+loginAtual+"' "+
                         "Where login='"+loginAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
  
    }     
    
    public void alteraSenha(String login,String senha){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Funcionario "+
                         "SET senha = '"+senha+"' "+
                         "Where login='"+login+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }  
    
    public void alteraTipo(String login,String tipo){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:controlePosto.db");            
            System.out.println("Base de dados aberta");                        
            stmt = c.createStatement();
            String sql = "UPDATE Funcionario "+
                         "SET tipo = '"+tipo+"' "+
                         "Where login='"+login+"';";
                        
            stmt.executeUpdate(sql);
            stmt.close();
            //c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        System.out.println("Dados alterados com sucesso.");
    }
    
    /* DELETAR */
    public  void deleteLogin(String login) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Funcionario where login=" + login +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }  
    
    public  void deleteId(int id_funcionario) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Funcionario where id_funcionario=" + id_funcionario +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    
    /*
    / EXIBIR /
    
    public synchronized ArrayList selecionarMedicamento() throws SQLException, ClassNotFoundException{
        ArrayList listaMedicamento = new ArrayList();
        try{
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.rs = conexao.stmt.executeQuery("Select * from medicamento;");
            while(conexao.rs.next()){
                Medicamento drugs = new Medicamento();
                drugs.setId_medicamento(conexao.rs.getInt("ID_MEDICAMENTO"));
                drugs.setDescricao(conexao.rs.getString("DESCRICAO"));
                drugs.setNome(conexao.rs.getString("NOME"));
                drugs.setValidade(conexao.rs.getString("VALIDADE"));
                drugs.setLote(conexao.rs.getString("LOTE"));
                drugs.setQtdDisponivel(conexao.rs.getInt("QTD_DISPONIVEL"));
                listaMedicamento.add(drugs);
            }
            conexao.fecharBanco();
            return listaMedicamento;
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Não foi possível conectar ao DB");
            return listaMedicamento;
        }  
    }
    
    */
}
