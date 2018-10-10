
package posto.modelo;

import posto.control.*;


public class Main {

    /*String descricao, String nome, String validade, String lote, int qtdDisponivel*/
    public static void main(String[] args) throws IOException, ClassNotFoundException, java.io.IOException {
        
        /*CRIAÇÃO MEDICAMENTO -> SALVAnDO EM ARQUIVO E ABRINDO*/
        Medicamento nMedicamento = new Medicamento("blabla","Dipirona","10/05/2018","123/0004",50);
        CadastrarMedicamento cad = new CadastrarMedicamento();
        ExibirMedicamentos saida = new ExibirMedicamentos();
        Medicamento aMedicamento = null;
        
        /*enviando objeto para cadastrar*/
        cad.cadastrarMedicamento(nMedicamento);
        /*Abrindo  arquivo*/
        aMedicamento = (Medicamento)cad.buscarMedicamento(aMedicamento, "dadosfarmacia");        
        /*Mostrando na tela*/
        saida.exibirMedicamentos(aMedicamento);

    }   
}
