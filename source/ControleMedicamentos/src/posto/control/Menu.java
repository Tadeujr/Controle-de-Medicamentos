/*
Classe para aprsentação do trabalho
 */
package posto.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
        String menu = JOptionPane.showInputDialog("\t\t           Menu Principal"+ "\nCadastra Funcionario: 1 "
                        + "\nOpções Medicamento: 2"
                        + "\nDeletar Medicamento: 3" + "\nSair: 0");
        int opcao = Integer.parseInt(menu);
        //verificar login
        while (opcao != 0) {

            //Opções Menu
            if (opcao == 1) {//Cadastrar Funcionario FUNCIONANDO
                String nome = JOptionPane.showInputDialog("(1/8)\nNome");
                String cpf = JOptionPane.showInputDialog("(2/8)\nCPF (apenas números)");
                while ((cpf.length() != 11) || (!cpf.matches("[0-9]*"))) {
                    cpf = JOptionPane.showInputDialog("(2/8)\nCPF (apenas números)\nCPF inválido");
                }
                String senhaF = JOptionPane.showInputDialog("(3/8)\nSenha");
                String loginF = JOptionPane.showInputDialog("(4/8)\nLogin");
                String tipo = JOptionPane.showInputDialog("(5/8)\nTipo:Gerente [1] ou Atendente [2]");
                while ((!"1".equals(tipo)) && (!"2".equals(tipo))) {
                    tipo = JOptionPane.showInputDialog("(5/8)\nTipo:Gerente [1] ou Atendente [2]\nTipo inválido");
                }
                if ("1".equals(tipo)){
                    tipo = "GERENTE";
                }
                else{
                    tipo = "ATENDENTE";
                }
                String email = JOptionPane.showInputDialog("(6/8)\nEmail");
                String telefone = JOptionPane.showInputDialog("(7/8)\nTelefone");
                while (!telefone.matches("[0-9]*")) {
                    telefone = JOptionPane.showInputDialog("(7/8)\nTelefone\nTelefone inválido");
                }
                String endereco = JOptionPane.showInputDialog("(8/8)\nEndereço");

                Funcionario nFuncionario = new Funcionario(loginF, senhaF, tipo, nome.toUpperCase(), email, telefone, endereco.toUpperCase(), cpf); // pesquisa metodo de crptografia
                controleFuncionario.cadastrarFuncionario(nFuncionario);

            }

            if (opcao == 2) {//Cadastrar Medicamento FUNCIONANDO

                String opCrud = JOptionPane.showInputDialog("Cadastra Medicamento: 1 "
                        + "\nExibir Medicamento: 2"
                        + "\nCadastrar Cliente: 3" + "\nSair: 0");

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

                if (opcCrud == 2) {//MOSTRA MEDICAMENTO
                    controleMedicamento.exibirMedicamentos();
                }

                if (opcCrud == 3) {//Deletar Medicamento NOME FUNCIONANDO
                    String nomeMedicamento = JOptionPane.showInputDialog("Nome Medicamento");
                    controleMedicamento.deleteMedicamento(nomeMedicamento);
                }

                if (opcCrud == 4) {//voltar
                    menu = JOptionPane.showInputDialog("Senha");
                    opcao = Integer.parseInt(menu);
                }
            }

            if (opcao == 3) {//Cria Cliente FUNCIONANDO

                String nome = JOptionPane.showInputDialog("(1/6)\nNome");
                String cpf = JOptionPane.showInputDialog("(2/6)\nCPF (apenas números)");
                while ((cpf.length() != 11) || (!cpf.matches("[0-9]*"))) {
                    cpf = JOptionPane.showInputDialog("(2/6)\nCPF (apenas números)\nCPF inválido");
                }
                String email = JOptionPane.showInputDialog("(3/6)\nEmail");
                String telefone = JOptionPane.showInputDialog("(4/6)\nTelefone");
                while (!telefone.matches("[0-9]*")) {
                    telefone = JOptionPane.showInputDialog("(4/6)\nTelefone\nTelefone inválido");
                }
                String endereco = JOptionPane.showInputDialog("(5/6)\nEndereço");
                String cartaoSus = JOptionPane.showInputDialog("(6/6)\nCartão SUS");
                while (!cartaoSus.matches("[0-9]*")) {
                    cartaoSus = JOptionPane.showInputDialog("(6/6)\nCartão SUS");
                }
                Cliente cliente = new Cliente(nome.toUpperCase(), email, telefone, endereco.toUpperCase(), cpf, cartaoSus);
                controleCliente.cadastrarCliente(cliente);

            }

            if (opcao == 4) {// LISTA FUNCIONADO

            }

            if (opcao == 5) {//CRUD MEDICAMENTO

            }

                menu = JOptionPane.showInputDialog("Cadastra Medicamento: 1 "
                        + "\nExibir Medicamento: 2"
                        + "\nCadastrar Cliente: 3" + "\nSair: 0");

                opcao = Integer.parseInt(menu);
        }

    }
}
