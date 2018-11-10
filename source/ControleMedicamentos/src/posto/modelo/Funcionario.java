
package posto.modelo;


public class Funcionario extends Pessoa {
    protected int id_funcionario;
    protected String login;
    protected String senha;
    protected String tipo;
    
    public Funcionario(String nome,String email,String telefone,String endereco,String cpf,String login,String senha,String tipo){
        super( nome, email, telefone, endereco, cpf);
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

  
    
}
