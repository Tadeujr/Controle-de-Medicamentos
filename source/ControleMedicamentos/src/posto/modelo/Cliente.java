
package posto.modelo;


public class Cliente extends Pessoa{
    protected int cartaoSUS;
    protected int id_cliente;
    public Cliente(String nome,String email,String telefone,String endereco,String cpf,int cartaoSUS){  
        super(nome, email, telefone, endereco, cpf);
        this.cartaoSUS = cartaoSUS;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    
    public int getCartaoSUS() {
        return cartaoSUS;
    }

    public void setCartaoSUS(int cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    
    
}
