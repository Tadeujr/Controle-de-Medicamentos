
package posto.modelo;


public class Funcionario extends Pessoa {
    
    
    public Funcionario(String nome, String rg, String senha){
        super(nome,rg, senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSenha() {
        return this.senha;
    }
    
    
}
