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
import posto.modelo.Retirada;

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
        RetiradaSql controleRetirada = new RetiradaSql();

        // String login = JOptionPane.showInputDialog("Login");
        String menu = JOptionPane.showInputDialog("\t\t           Menu Principal"+ "\nCadastra Funcionario: 1 "
                        + "\nOpções Medicamento: 2"
                        + "\nCadastrar Cliente: 3" 
                        + "\nCadastrar Retirada: 4" + "\nSair: 0");
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

            if (opcao == 2) {//Opções Medicamento FUNCIONANDO

                String opCrud = JOptionPane.showInputDialog("Cadastra Medicamento: 1 "
                        + "\nExibir Medicamento: 2"
                        + "\nDeletar Medicamento: 3" + "\nSair: 0");

                int opcCrud = Integer.parseInt(opCrud);

                if (opcCrud == 1) { //Cadastrar Medicamento FUNCIONANDO
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
                while ((telefone.length() != 9) || (!telefone.matches("[0-9]*"))) {
                    telefone = JOptionPane.showInputDialog("(4/6)\nTelefone\nTelefone inválido");
                }
                String endereco = JOptionPane.showInputDialog("(5/6)\nEndereço");
                String cartaoSus = JOptionPane.showInputDialog("(6/6)\nCartão SUS");
                while ((cartaoSus.length() != 15) || (!cartaoSus.matches("[0-9]*"))) {
                    cartaoSus = JOptionPane.showInputDialog("(6/6)\nCartão SUS");
                }
                Cliente cliente = new Cliente(nome.toUpperCase(), email, telefone, endereco.toUpperCase(), cpf, cartaoSus);
                controleCliente.cadastrarCliente(cliente);

            }

            if (opcao == 4) {// Retirada
                    int verificador = 0;
                    String funcLogin = JOptionPane.showInputDialog("(1/4)\nLogin Funcionario");
                        while(verificador == 0 ){
                            if (funcLogin != null){
                                try{
                                    Funcionario func = controleFuncionario.selecionarFuncionario(funcLogin);
                                    verificador = 1;
                                }catch(ClassNotFoundException | SQLException e){
                                    funcLogin = JOptionPane.showInputDialog("(1/4)\nLogin Inválido \nLogin Funcionario");
                                }
                            }
                        }
                    String cpf = JOptionPane.showInputDialog("(2/4)\nCPF (apenas números)");
                    while ((cpf.length() != 11) || (!cpf.matches("[0-9]*"))) {
                        cpf = JOptionPane.showInputDialog("(2/4)\nCPF (apenas números)\nCPF inválido");
                    }
                    while(verificador == 1 ){
                        if (cpf != null){
                            try{
                                Cliente cliente = controleCliente.selecionarCliente(cpf);
                                verificador = 2;
                            }catch(ClassNotFoundException | SQLException e){
                                cpf = JOptionPane.showInputDialog("(2/4)\nCliente Inexistente\n Insira CPF válido");
                                while ((cpf.length() != 11) || (!cpf.matches("[0-9]*"))) {
                                    cpf = JOptionPane.showInputDialog("(2/4)\nCPF (apenas números)\nCPF inválido");
                                }
                            }
                        }
                    }
                    String nomeMedicamento = JOptionPane.showInputDialog("(3/4)\nNome Medicamento");
                    while(verificador == 2 ){
                        if (nomeMedicamento != null){
                            try{
                                Medicamento medic = controleMedicamento.selecionarMedicamento(nomeMedicamento);
                                verificador = 3;
                            }catch(ClassNotFoundException | SQLException e){
                                nomeMedicamento = JOptionPane.showInputDialog("(3/4)\nNome Inválido \nNome Medicamento");
                            }
                        }    
                    }
                    int qtdDisponivel = controleMedicamento.selecionarMedicamento(nomeMedicamento).getQtdDisponivel();
                    String qtd = JOptionPane.showInputDialog("(4/4)\nQuantidade Retirada");
                    int qtdRetirada = Integer.parseInt(qtd);
                    while(qtdDisponivel < qtdRetirada ){
                        qtd = JOptionPane.showInputDialog("(4/4)\nQuantidade Inválida \nQuantidade no Sistema :" + qtdDisponivel + "\nQuantidade Retirada");
                        qtdRetirada = Integer.parseInt(qtd);
                    }
                    if (qtdRetirada == qtdDisponivel){
                        JOptionPane.showMessageDialog(null, "Medicamento agora possui 0 em estoque.");
                    }
                    Retirada nRetirada = new Retirada(qtdRetirada, controleCliente.selecionarCliente(cpf), controleFuncionario.selecionarFuncionario(funcLogin), controleMedicamento.selecionarMedicamento(nomeMedicamento));
                    controleRetirada.cadastrarRetirada(nRetirada);
                }


                menu = JOptionPane.showInputDialog("\t\t           Menu Principal"+ "\nCadastra Funcionario: 1 "
                        + "\nOpções Medicamento: 2"
                        + "\nCadastrar Cliente: 3" 
                        + "\nCadastrar Retirada: 4" + "\nSair: 0");
                opcao = Integer.parseInt(menu);
        }
    }      
}

