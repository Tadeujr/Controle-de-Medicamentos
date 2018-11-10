
package posto.control;

import posto.modelo.Funcionario;
import posto.modelo.Medicamento;


public class ExibirDados {
    
    public void exibirMedicamentos(Medicamento aMedicamento){
            
        System.out.println("Medicamento: " + aMedicamento.getNome()+
            "\nDescrição: " + aMedicamento.getDescricao()+ "\nLote: " + aMedicamento.getLote()+
            "\nValidade: "+ aMedicamento.getValidade()
            );
    }
    
    /*
    public void exibirFuncionario(Funcionario funcionario){
            
        System.out.println("Nome: " + funcionario.getNome()+
            "\nRg: " + funcionario.getRg()+ "\nSenha: " + funcionario.getSenha());
            
    }*/
}
