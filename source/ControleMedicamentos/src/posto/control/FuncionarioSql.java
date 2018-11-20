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
        conexao.rs = conexao.stmt.executeQuery("SELECT id_funcionario FROM FUNCIONARIO WHERE login ='"+ login +"';");
        id = conexao.rs.getInt("id_funcionario");
        conexao.fecharBanco();
        return id;
    
    }
    
    public Funcionario selecionarFuncionario(String cpf) throws SQLException, ClassNotFoundException{
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
         
        conexao.rs = conexao.stmt.executeQuery("select * from CLIENTE inner join PESSOA on (CLIENTE.fk_id_pessoa = PESSOA.id_pessoa) where cpf ='" + cpf +"'");
        Funcionario funcionario = new Funcionario(conexao.rs.getNString("LOGIN"),conexao.rs.getNString("SENHA"),conexao.rs.getNString("TIPO"),conexao.rs.getNString("NOME"),
        conexao.rs.getNString("EMAIL"),conexao.rs.getNString("TELEFONE"),conexao.rs.getNString("ENDERECO"),conexao.rs.getNString("CPF"));

        return funcionario;        

       
    }

}
