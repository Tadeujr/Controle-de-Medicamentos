
package posto.modelo;

import java.io.Serializable;


public class Pessoa implements Serializable{
    public String nome;
    public String rg;
    protected String senha;
    //protected String endereco;
    //protected String email;

    public Pessoa(String nome, String rg,String senha) {
        this.nome = nome;
        this.rg = rg;
        this.senha = senha;
    }

    
    
}
