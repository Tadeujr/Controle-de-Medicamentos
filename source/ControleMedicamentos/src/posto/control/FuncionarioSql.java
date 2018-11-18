/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;
import java.sql.SQLException;
import posto.modelo.Funcionario;
import posto.modelo.Pessoa;


/**
 *
 * @author 20142bsi0429
 */
public class FuncionarioSql {
    /* CADASTRAR */
    protected Funcionario nFuncionario;
    
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException{ // guarda em uma Stream
        
        // criar uma função para pegar o id do funcionário na tabela pessoa 
        Pessoa  nPessoa = new Pessoa(funcionario.getNome(),funcionario.getEmail(),funcionario.getTelefone(),funcionario.getEndereco(),funcionario.getCpf());
        PessoaSql nPessoaSql = new PessoaSql();
        nPessoaSql.cadastrarPessoa(nPessoa);
        
        int idPessoa =  nPessoaSql.buscarIdPessoa(nPessoa.getCpf());
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "INSERT INTO Funcionario (login,senha,tipo,fk_id_pessoa)"
                + "VALUES ('" + funcionario.getLogin() + 
                "','" + funcionario.getSenha() + 
                "','" + funcionario.getTipo() + "',"+
                                idPessoa + ");";
        
        conexao.atualizarBanco();
        
        
    }
    
    /* ALTERAR */
    public void alteraLogin(String loginAtual,String loginAntigo) throws SQLException, ClassNotFoundException{


        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "UPDATE Funcionario "+
                     "SET login = '"+loginAtual+"' "+
                     "Where login='"+loginAntigo+"';";
        conexao.atualizarBanco();
        conexao.fecharBanco();

    }     
    
    public void alteraSenha(String login,String senha) throws SQLException, ClassNotFoundException{
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("UPDATE Funcionario "+
                         "SET senha = '"+senha+"' "+
                         "Where login='"+login+"';");
                        
        conexao.fecharBanco();

    }  
    
    public void alteraTipo(String login,String tipo) throws SQLException, ClassNotFoundException{
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "UPDATE Funcionario "+
                         "SET tipo = '"+tipo+"' "+
                         "Where login='"+login+"';";
        conexao.atualizarBanco();
        conexao.fecharBanco();       

    }
    
    /* DELETAR */
    public  void deleteLogin(String login) throws SQLException, ClassNotFoundException {
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "DELETE FROM Funcionario where login=" + login +";";
        conexao.atualizarBanco();
        conexao.fecharBanco();    


    }  
    
    public int buscarIdFuncionario(String login) throws SQLException, ClassNotFoundException{
        int id;
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("SELECT id_funcionario FROM FUNCIONARIO WHERE login ='"+ login +"';");
        id = conexao.rs.getInt("id_funcionario");
        conexao.fecharBanco();
        return id;
    
    }
    

}
