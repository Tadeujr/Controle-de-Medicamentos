/*
Classe para aprsentação do trabalho
 */
package posto.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import posto.modelo.Cliente;
import posto.modelo.Funcionario;
import posto.modelo.Medicamento;

/**
 *
 * @author tadeu
 */
public class Menu {

    public void Apresentacao() throws IOException, ClassNotFoundException, SQLException {
        Medicamento medicamento;
        Funcionario fucionario;

        MedicamentoSql controleMedicamento = new MedicamentoSql();
        ClienteSql controleCliente = new ClienteSql();
        FuncionarioSql controleFuncionario = new FuncionarioSql();

        // String login = JOptionPane.showInputDialog("Login");
        String menu = JOptionPane.showInputDialog("Senha");
        int opcao = Integer.parseInt(menu);
        //verificar login
        // while (opcao != 0) {

        //Opções Menu
        if (opcao == 1) {//Cadastrar Funcionario            
            String nome = JOptionPane.showInputDialog("Nome");
            String cpf = JOptionPane.showInputDialog("CPF");
            String senhaF = JOptionPane.showInputDialog("Senha");
            String loginF = JOptionPane.showInputDialog("Login");
            String tipo = JOptionPane.showInputDialog("Tipo:(Gerente ou Atendente");
            String email = JOptionPane.showInputDialog("Email");
            String telefone = JOptionPane.showInputDialog("Telefone");
            String endereco = JOptionPane.showInputDialog("Endereço");

            Funcionario nFuncionario = new Funcionario(loginF, senhaF, tipo, nome, email, telefone, endereco, cpf); // pesquisa metodo de crptografia
            controleFuncionario.cadastrarFuncionario(nFuncionario);

        }

        if (opcao == 2) {//Cadastrar Medicamento FUNCIONANDO

            String opCrud = JOptionPane.showInputDialog("Cadastra Medicamento: 1 "
                    + "\nCadastrar Medicamento: 2"
                    + "\nMostrar Medicamentos: 3"
                    + "\nMostrar Funcionário: 4"
                    + "\nSair: 0");
            
            int opcCrud = Integer.parseInt(opCrud);

            if (opcCrud == 1) {
                String nomeMedicamento = JOptionPane.showInputDialog("Medicamento");
                String validade = JOptionPane.showInputDialog("validade");
                String lote = JOptionPane.showInputDialog("lote");
                String qtd = JOptionPane.showInputDialog("Quantidade");
                String descricao = JOptionPane.showInputDialog("Descricao");
                int qtdDisponivel = Integer.parseInt(qtd);

                /*CRIAÇÃO MEDICAMENTO -> SALVAnDO EM ARQUIVO E ABRINDO*/
                Medicamento nMedicamento = new Medicamento(nomeMedicamento, descricao, validade, lote, qtdDisponivel);

                /*enviando objeto para cadastrar*/
                controleMedicamento.cadastrarMedicamento(nMedicamento);
            }

        }

        if (opcao == 3) {//Cria Cliente FUNCIONANDO

            String nome = JOptionPane.showInputDialog("Nome");
            String cpf = JOptionPane.showInputDialog("CPF");
            String senhaF = JOptionPane.showInputDialog("Senha");
            String loginF = JOptionPane.showInputDialog("Login");
            String tipo = JOptionPane.showInputDialog("Tipo:(Gerente ou Atendente");
            String email = JOptionPane.showInputDialog("Email");
            String telefone = JOptionPane.showInputDialog("Telefone");
            String endereco = JOptionPane.showInputDialog("Endereço");
            String cartaoSus = JOptionPane.showInputDialog("Cartão SUS");
            Cliente cliente = new Cliente(nome, email, telefone, endereco, cpf, cartaoSus);
            controleCliente.cadastrarCliente(cliente);

        }

        if (opcao == 4) {// LISTA FUNCIONADO
            controleMedicamento.exibirMedicamentos();
        }

        if (opcao == 5) {//CRUD MEDICAMENTO

        }
        menu = JOptionPane.showInputDialog("Cadastra Fucionário: 1 "
                + "\nCadastrar Medicamento: 2"
                + "\nMostrar Medicamentos: 3"
                + "\nMostrar Funcionário: 4"
                + "\nSair: 0");

        opcao = Integer.parseInt(menu);
    }

    //}
}
