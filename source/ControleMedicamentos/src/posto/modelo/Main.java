
package posto.modelo;

import posto.control.*;


public class Main {


    public static void main(String[] args) {
        Medicamento drugs = new Medicamento("Allahi akbar","Teste","17-10-1992", "0014",14);
        //exemplo inserção
        CadastrarMedicamento tst = new CadastrarMedicamento();
        tst.InsereMedicamentos(drugs);
        
        //exemplo delete
        //deletaMedicmaneto del = new deletaMedicmaneto();
        //del.deleteMedicamentoId(1);
    
        //exemplo alterar
        /*atualizarMedicamento at = new atualizarMedicamento();
        at.alteraMedicamentoNome("Teste", "Allahi akbar");
        at.alteraMedicamentoDescricao("Teste", "Testando a alteração");
        at.alteraMedicamentoQtd("Teste", 501);
        */
    }
    
}
