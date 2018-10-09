/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.io.IOException;
import posto.modelo.Medicamento;

/**
 *
 * @author tadeu
 */
public class CadastrarMedicamento {
    
  public void cadastrarMedicamento(Medicamento novoMedicamento) throws IOException{
      IPersistencia salvar = new OperacoesArq("dadosfarmacia");
      salvar.salvarDados(novoMedicamento);
  }
  
  public Medicamento buscarMedicamento(Medicamento retorno, String nomeArq) throws IOException, ClassNotFoundException{
      
      IPersistencia abrir = new OperacoesArq(nomeArq);
      
      retorno = (Medicamento) abrir.trazerDados(retorno);
      
      return retorno;
  }
    
}
