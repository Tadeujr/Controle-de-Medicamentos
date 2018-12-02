package posto.control;
import java.sql.SQLException;
import java.util.ArrayList;
import posto.modelo.Medicamento;
/**
 *
 * @author 20142bsi0216
 */
public class MedicamentoSql {
    /* CADASTRAR */
    public  void cadastrarMedicamento(Medicamento medicamento) {
        try {
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "INSERT INTO Medicamento (NOME,DESCRICAO,QTD_DISPONIVEL,VALIDADE,LOTE)"
                    + "VALUES ('" + medicamento.getNome() + 
                    "','" + 
                        medicamento.getDescricao() + 
                    "'," +
                        medicamento.getQtdDisponivel() + 
                    ",'" +
                        medicamento.getValidade() +
                    "','" +
                        medicamento.getLote() + 
                    "');";
            
            conexao.atualizarBanco();
        } catch (ClassNotFoundException | SQLException e) {
            
            System.err.println("ERRO método cadastrar Medicamento" + e.getClass().getName() + ": " + e.getMessage());            
        }
    }
    
    /* ALTERAR */
    public void alteraMedicamentoNome(String nomeAtual,String nomeAntigo){
        try {
        
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "UPDATE Medicamento "+
                      "SET nome = '"+nomeAtual+"' "+
                      "Where nome='"+nomeAntigo+"';";
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        
    }        
    
    public void alteraMedicamentoDescricao(String nomeAtual,String descricaoAtual){
        try {
            OperarBd conexao = new OperarBd();
            conexao.sql = "UPDATE Medicamento "+
                         "SET descricao = '"+descricaoAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
            
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        
        }
        
    }    
    
        
    public void alteraMedicamentoQtd(String nomeAtual,int qtdAtual){
        try {
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "UPDATE Medicamento "+
                         "SET qtd_disponivel = '"+qtdAtual+"' "+
                         "Where nome='"+nomeAtual+"';";
            conexao.atualizarBanco();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }
        
    }
    
    /* DELETAR */
    public  void deleteMedicamento(String nomeMedicamento) {
        try {
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "DELETE FROM Medicamento where nome= '"  + nomeMedicamento + "' ;";
            conexao.atualizarBanco();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }   
    
    //deleta o medicamento pelo ID
    public  void deleteMedicamentoId(int id) throws SQLException, ClassNotFoundException {
        try {
            
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.rs = conexao.stmt.executeQuery("DELETE FROM Medicamento where id_medicamento=" + id +";");
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
    
    /* EXIBIR */
    public void exibirMedicamentos() throws SQLException, ClassNotFoundException{
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Medicamento;");
        System.out.println("Nome \t\t Descricao \t\tLote \t\t Quantidade");
        
        while(conexao.rs.next()){
        
            Medicamento drugs = new Medicamento(conexao.rs.getString("NOME"),conexao.rs.getString("DESCRICAO"),conexao.rs.getString("VALIDADE"),conexao.rs.getString("LOTE"),conexao.rs.getInt("QTD_DISPONIVEL"));
            System.out.println(drugs.getNome()+"\t\t"+ drugs.getDescricao() +" \t\t"+  drugs.getLote() +"\t\t\t"+ drugs.getQtdDisponivel());
        }
          
        conexao.fecharBanco();       
    }
    
    // selecionar Medicamento escolhido 
    public Medicamento selecionarMedicamento(String nomeMedicamento) throws SQLException, ClassNotFoundException {
        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        
        conexao.rs = conexao.stmt.executeQuery("select * from Medicamento where nome = '" + nomeMedicamento +"'");
        Medicamento drugs = new Medicamento(conexao.rs.getString("NOME"),conexao.rs.getString("DESCRICAO"),conexao.rs.getString("VALIDADE"),conexao.rs.getString("LOTE"),conexao.rs.getInt("QTD_DISPONIVEL"));
        drugs.setIdMedicamento(conexao.rs.getInt("id_medicamento"));
        conexao.fecharBanco();
       return drugs;        
          
    }
    
    public Medicamento selecionarMedicamentoId(int idMedicamento) throws SQLException, ClassNotFoundException{

        
        OperarBd conexao = new OperarBd();
        conexao.conectarBanco();
        conexao.rs = conexao.stmt.executeQuery("select * from Medicamento where id_medicamento ='" + idMedicamento+"'");
        Medicamento drugs = new Medicamento(conexao.rs.getString("NOME"),conexao.rs.getString("DESCRICAO"),conexao.rs.getString("VALIDADE"),conexao.rs.getString("LOTE"),conexao.rs.getInt("QTD_DISPONIVEL"));
        drugs.setIdMedicamento(conexao.rs.getInt("id_medicamento"));          
        conexao.fecharBanco();
        return drugs;        
    }    
 
    
    public void entregarMedicamento(String nome, int quantidade){
        try {
            
            OperarBd conexao = new OperarBd();
            conexao.conectarBanco();
            conexao.sql = "UPDATE Medicamento SET QTD_DISPONIVEL = QTD_DISPONIVEL-" + quantidade+ " WHERE nome ='" + nome +"'";
            conexao.atualizarBanco();
            
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + 
                    e.getMessage());            
        }
    }
}
