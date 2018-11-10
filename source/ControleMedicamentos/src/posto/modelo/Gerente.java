
package posto.modelo;


public class Gerente extends Pessoa{
     
    protected int id_gerente;
    protected String login;
    protected String senha;
    
    public Gerente(String nome,String email,String telefone,String endereco,String cpf,String login,String senha){
        super( nome, email, telefone, endereco, cpf);
        this.login = login;
        this.senha = senha;
    }

    public int getId_gerente() {
        return id_gerente;
    }

    public void setId_gerente(int id_gerente) {
        this.id_gerente = id_gerente;
    }

    
}
