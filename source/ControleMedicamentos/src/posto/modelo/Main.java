package posto.modelo;

import posto.control.*;

public class Main {

    public static void main(String[] args) {
        //Variaveis teste.

        try {
            Menu menu = new Menu();
            menu.Apresentacao();
            /*
            Funcionario novoFuncionario = new Funcionario("tadeujunior", "1234", "gerente", "Tadeu jr", "tadeu_junior@outlook.com", "3254331", "rua 14 casa 35 Antonio Ferreira Borges", "12345678900");
            Cliente novoCliente = new Cliente("Ediane Andrade", "tadeu_junior@outlook.com", "32544433", "Minha casa", "123456789011", "123456");
            // CRIANDO MEDICAMENTO / INSERINDO NO BANCO E BUSCANDO NO BANCO
            Medicamento novoMedicamento = new Medicamento("DorFlex", "Preciso de um", "1989-11-05", "172", 50);
            Retirada novaRetirada = new Retirada(3, novoCliente, novoFuncionario, novoMedicamento);
            RetiradaSql n = new RetiradaSql();
            n.cadastrarRetirada(novaRetirada);
            
            //Medicamento saida;
            MedicamentoSql m = new MedicamentoSql();
            m.exibirMedicamentos();
            /*
            m.deleteMedicamento("Dorsi");
            System.out.println(m.selecionarMedicamento("DorFlex").getId_medicamento());
                */
            // saida = m.selecionarMedicamento("DorFlex");
            // System.out.println("Esse Medicamento vem do banco de dados: " + saida.getValidade());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        /*    // criando Funcionario
            Funcionario novoFuncionario = new Funcionario("tadeujunior","1234","gerente","Tadeu jr","tadeu_junior@outlook.com","3254331","rua 14 casa 35 Antonio Ferreira Borges","12345678900");
           // FuncionarioSql cadFuncionario = new FuncionarioSql();
           // Funcionario novo;
            MedicamentoSql n = new MedicamentoSql();
            //cadFuncionario.cadastrarFuncionario(novoFuncionario);
            //novo = cadFuncionario.selecionarFuncionario("tadeujunior");
            n.exibirMedicamentos();
         */
        //exemplo inserção Cliente
        //CadastrarCliente pessoa = new CadastrarCliente();
        //pessoa.cadastrarCliente(ppl);
        //exemplo inserção Funcionario
        // CadastrarFuncionario n = new CadastrarFuncionario();
        //n.cadastrarFuncionario(func);
        //exemplo alterar funcionario
        /*EditarFuncionario altFunc = new EditarFuncionario();
        altFunc.alteraTipo("maria123", "Gerente");*/
        //exemplo inserção
        //insereMedicamento tst = new insereMedicamento();
        //tst.InsereMedicamentos(drugs);
        //exemplo delete
        //deletaMedicmaneto del = new deletaMedicmaneto();
        //del.deleteMedicamentoId(1);
        //exemplo alterar
        /*
        atualizarMedicamento at = new atualizarMedicamento();
        at.alteraMedicamentoNome("Teste", "Allahi akbar");
        at.alteraMedicamentoDescricao("Teste", "Testando a alteração");
        at.alteraMedicamentoQtd("Teste", 501);
         */
 /*
        //retirada exemplo
        Retirada takeOff = new Retirada(29,ppl,func,drugs);
        
        //cadastra retirada
        CadastrarRetirada retirada = new CadastrarRetirada();
        retirada.cadastrarRetirada(takeOff);
        
        //altera retirada
        
        EditaRetirada altRet = new EditaRetirada();
        altRet.alteraEditaRetiradaQtd(1, 40);
        
        //excluir retirada
        ExcluirRetirada del = new ExcluirRetirada();
        del.deleteRetirada(2);
        
            
         */
    }

}
