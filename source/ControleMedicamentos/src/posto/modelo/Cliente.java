
package posto.modelo;


public class Cliente extends Pessoa{
    protected int cartaoSUS;
    
    public Cliente(String nome, String rg){
        super(nome,rg, null);
    }

    public int getCartaoSUS() {
        return cartaoSUS;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }
    
}
