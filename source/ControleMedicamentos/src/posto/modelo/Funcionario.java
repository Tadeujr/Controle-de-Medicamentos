
package posto.modelo;


public class Funcionario extends Pessoa {
    protected String login;
    protected String senha;
    protected String tipo;
    public int id_Funcionario;

    public Funcionario(String login, String senha, String tipo, String nome, String email, String telefone, String endereco, String cpf) {
        super(nome, email, telefone, endereco, cpf);
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        
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

    public int getIdFuncionario() {
        return id_Funcionario;
    }

    public void setIdFuncionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }




  
    
}
