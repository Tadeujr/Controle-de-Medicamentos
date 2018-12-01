/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import posto.modelo.Funcionario;
import posto.modelo.Pessoa;


/**
 *
 * @author 20142bsi0429
 */
public class FuncionarioSql {
    /* CADASTRAR */
    protected Funcionario nFuncionario;
    
    public void cadastrarFuncionario(Funcionario funcionario) { // guarda em uma Stream
        
        // criar uma função para pegar o id do funcionário na tabela pessoa 
        Pessoa  nPessoa = new Pessoa(funcionario.getNome(),funcionario.getEmail(),funcionario.getTelefone(),funcionario.getEndereco(),funcionario.getCpf());
        PessoaSql nPessoaSql = new PessoaSql();
        try{
            nPessoaSql.cadastrarPessoa(nPessoa);

            int idPessoa =  nPessoa.getId_pessoa();
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "INSERT INTO Funcionario (login,senha,tipo,fk_id_pessoa)"
                    + "VALUES ('" + funcionario.getLogin() + 
                    "','" + funcionario.getSenha() + 
                    "','" + funcionario.getTipo() + "',"+
                                    idPessoa + ");";

            conexao.atualizarBanco();
        } catch (Exception ex) {
            Logger.getLogger(FuncionarioSql.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        conexao.rs = conexao.stmt.executeQuery("SELECT fk_id_pessoa FROM FUNCIONARIO WHERE login ='"+ login +"';");
        id = conexao.rs.getInt("fk_id_pessoa");
        conexao.fecharBanco();
        return id;
    
    }
    
    public Funcionario selecionarFuncionario(String login) throws SQLException, ClassNotFoundException{
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Funcionario inner join PESSOA on (FUNCIONARIO.fk_id_pessoa = PESSOA.id_pessoa) where fk_id_pessoa = " + buscarIdFuncionario(login));
        Funcionario funcionario = new Funcionario(conexao.rs.getString("LOGIN"),conexao.rs.getString("SENHA"),conexao.rs.getString("TIPO"),conexao.rs.getString("NOME"),
        conexao.rs.getString("EMAIL"),conexao.rs.getString("TELEFONE"),conexao.rs.getString("ENDERECO"),conexao.rs.getString("CPF"));
        
        conexao.fecharBanco();

        return funcionario;        

       
    }

      public Funcionario selecionarFuncionarioId(int idFuncionario) throws SQLException, ClassNotFoundException{
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Funcionario inner join PESSOA on (FUNCIONARIO.fk_id_pessoa = PESSOA.id_pessoa) where id_funcionario = " +idFuncionario +";");
        Funcionario funcionario = new Funcionario(conexao.rs.getString("LOGIN"),conexao.rs.getString("SENHA"),conexao.rs.getString("TIPO"),conexao.rs.getString("NOME"),
        conexao.rs.getString("EMAIL"),conexao.rs.getString("TELEFONE"),conexao.rs.getString("ENDERECO"),conexao.rs.getString("CPF"));
        
        conexao.fecharBanco();

        return funcionario;        

       
    }
    
}
