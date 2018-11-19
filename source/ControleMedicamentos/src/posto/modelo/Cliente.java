
package posto.modelo;


public class Cliente extends Pessoa{

    protected String cartaoSUS;
    protected int id_cliente;
    
    public Cliente(String nome,String email,String telefone,String endereco,String cpf,String cartaoSUS){  

        super(nome, email, telefone, endereco, cpf);
        this.cartaoSUS = cartaoSUS;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }


    

    public String getCartaoSUS() {

        return cartaoSUS;
    }

    public void setCartaoSUS(String cartaoSUS) {
        this.cartaoSUS = cartaoSUS;
    }

    @Override
    public int getId_pessoa() {
        return id_pessoa;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    
    
}
