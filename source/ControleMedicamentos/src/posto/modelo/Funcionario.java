
package posto.modelo;

import java.io.Serializable;


public class Funcionario extends Pessoa implements Serializable {
    
    public Funcionario(String nome, String rg, String senha){
        super(nome,rg,senha);
      
        
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public String getSenha() {
        return senha;
    }


    
    
}
