
package posto.modelo;

import posto.control.*;


public class Main {


    public static void main(String[] args) {
        //Variaveis teste.
        Cliente ppl = new Cliente("João Teste","joao.teste@hotmail.com","999595959","rua dos vales","475.885.777-30",1122);
        ppl.setId_pessoa(1);
        Medicamento drugs = new Medicamento("Allahi akbar","Teste","1992-02-01", "0014",(int)14);
        Funcionario func = new Funcionario("Maria Teste","maria.teste@hotmail.com","4444444","Rua testera","555.555.555-55","maria123","11222","Atendente");
        func.setId_pessoa(2);
        CadastrarMedicamento m = new CadastrarMedicamento();
        
        m.cadastrarMedicamento(drugs);
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
