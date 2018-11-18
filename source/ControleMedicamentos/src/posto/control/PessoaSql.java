/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;
import java.sql.SQLException;
import posto.modelo.Pessoa;

/**
 *
 * @author 20142bsi0429
 */
public class PessoaSql {
    /* CADASTRAR */
    public  void cadastrarPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {

        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.sql = "INSERT INTO Pessoa (NOME,EMAIL,TELEFONE,ENDERECO,CPF)"
                + "VALUES ('" + pessoa.getNome() + 
                "','" + 
                    pessoa.getEmail() + 
                "'," +
                    pessoa.getTelefone() + 
                ",'" +
                    pessoa.getEndereco() +
                "','" +
                    pessoa.getCpf() + 
                "');";                        
        conexao.atualizarBanco();


    }
    
    /* ALTERAR */
    public void alteraNome(String nomeAtual,String nomeAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET nome = '"+nomeAtual+"' "+
                         "Where nome='"+nomeAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    


    public void alteraEmail(String emailAtual,String emailAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET email = '"+emailAtual+"' "+
                         "Where email='"+emailAntigo+"';";
                        

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }

    public void alteraCpf(String cpfAtual,String cpfAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET cpf = '"+cpfAtual+"' "+
                         "Where cpf='"+cpfAntigo+"';";
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }

    
    public void alteraEndereco(String enderecoAtual,String enderecoAntigo){

        try {
            
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET endereco = '"+enderecoAtual+"' "+
                         "Where endereco='"+enderecoAntigo+"';";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }    
    
     
    public void alteraTelefone(String telefoneAtual,String telefoneAntigo){

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Pessoa "+
                         "SET telefone = '"+telefoneAtual+"' "+
                         "Where telefone='"+telefoneAntigo+"';";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

    }
    
    /* DELETAR */
    public  void deleteId(int id_pessoa) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Pessoa where id_pessoa=" + id_pessoa +";";
 
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
    public  void deleteNome(String nome) {

        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "DELETE FROM Pessoa where nome=" + nome +";";

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }

    }
   
    public int buscarIdPessoa (String cpf) throws SQLException, ClassNotFoundException{
        int id;
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("SELECT * FROM PESSOA WHERE cpf='"+ cpf +"';");        
        id = conexao.rs.getInt("id_pessoa");
        conexao.fecharBanco();
        return id;
    
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
