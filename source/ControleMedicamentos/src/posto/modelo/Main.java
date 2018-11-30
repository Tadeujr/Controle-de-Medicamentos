
package posto.modelo;

import posto.control.*;


public class Main {


    public static void main(String[] args) {
        //Variaveis teste.

        try{
            
            // criando Funcionario
            //Funcionario novoFuncionario = new Funcionario("tadeujunior","1234","gerente","Tadeu jr","tadeu_junior@outlook.com","3254331","rua 14 casa 35 Antonio Ferreira Borges","12345678900");
            FuncionarioSql cadFuncionario = new FuncionarioSql();
            Funcionario novo;
            //cadFuncionario.cadastrarFuncionario(novoFuncionario);
            novo = cadFuncionario.selecionarFuncionario("tadeujunior");
            
            System.out.println(novo.getCpf());
            System.out.println(novo.getEmail());
            System.out.println(novo.getEndereco());
            System.out.println(novo.getId_Funcionario());
            System.out.println(novo.getId_pessoa());
            System.out.println(novo.getLogin());
            System.out.println(novo.getNome());
            System.out.println(novo.getSenha());
            System.out.println(novo.getTelefone());
            System.out.println(novo.getTipo());
           /*
           
           // CRIANDO MEDICAMENTO / INSERINDO NO BANCO E BUSCANDO NO BANCO
           Medicamento nm = new Medicamento();
           MedicamentoSql m  = new MedicamentoSql();
           nm.setNome("Rivotril");
           nm.setDescricao("Remedio de Jadson");
           nm.setLote("10/02/1989");
           nm.setValidade("00014");
           nm.setQtdDisponivel(16);
           
           
           
           m.cadastrarMedicamento(nm);
           
           m.exibirMedicamento();
            nm = m.selecionarMedicamento("Rivotril");
            System.out.println("Esse Medicamento vem do banco de dados: " + nm.getValidade());
           */
            
            
        }catch(Exception  e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());            
        }

       
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
