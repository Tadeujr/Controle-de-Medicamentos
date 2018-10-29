
package posto.modelo;


public class Cliente extends Pessoa{
    protected int cartaoSUS;
    
    public Cliente(String nome, String rg,String senha){
        super(nome,rg,senha);
    }
}
