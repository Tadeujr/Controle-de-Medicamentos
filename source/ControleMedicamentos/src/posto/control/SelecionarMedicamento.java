
package posto.control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import posto.modelo.Medicamento;

public class SelecionarMedicamento {
    public synchronized ArrayList selecionarMedicamento() throws SQLException, ClassNotFoundException{
        ArrayList listaMedicamento = new ArrayList();
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
    }
}
