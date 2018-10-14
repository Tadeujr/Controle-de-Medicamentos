/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posto.control;

import java.io.IOException;
import posto.modelo.Funcionario;


/**
 *
 * @author tadeu
 */
public class CadastrarFuncionario{
       

public void cadastrarFuncionario(Funcionario nFuncionario) throws IOException{ // guarda em uma Stream
      IPersistencia salvar = new OperacoesArq("funcionario");
      salvar.salvarDados(nFuncionario);
    }


public Funcionario buscarFuncionario(Funcionario funcionario, String nomeArq) throws IOException, ClassNotFoundException{
      IPersistencia abrir = new OperacoesArq(nomeArq);
      funcionario = (Funcionario) abrir.trazerDados(funcionario);
      
      return funcionario;
    }
    
}
