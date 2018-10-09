
package posto.modelo;

import java.io.IOException;
import posto.control.*;


public class Main {

    /*String descricao, String nome, String validade, String lote, int qtdDisponivel*/
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Medicamento nMedicamento = new Medicamento("blabla","Dipirona","10/05/2018","123/0004",50);
        
        Medicamento aMedicamento = null;
        /*salvando em arquivo*/
        
        IPersistencia salvar = new OperarcoesArq("dadosfarmacia");
        salvar.salvarDados( nMedicamento);
        
        
        /*trazendo as informações de volta*/
        aMedicamento = (Medicamento) salvar.trazerDados(aMedicamento);
        
        System.out.println("Medicamento: " + aMedicamento.getNome()+
               "\nDescrição: " + aMedicamento.getDescricao()+ "\nLote: " + aMedicamento.getLote()+
                "\nValidade"+ aMedicamento.getValidade()
        );
        
        
        
        
    }
    
}
