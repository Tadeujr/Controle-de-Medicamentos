
package posto.modelo;


public class Retirada {
    protected String data;
    protected String hora;
    protected int qtdRetirada;
    Cliente clienteRetirada;
    Funcionario funcionarioRetirada;
    Medicamento medicamento;

    public Retirada(String data, String hora, int qtdRetirada, Cliente clienteRetirada, Funcionario funcionarioRetirada, Medicamento medicamento) {
        this.data = data;
        this.hora = hora;
        this.qtdRetirada = qtdRetirada;
        this.clienteRetirada = clienteRetirada;
        this.funcionarioRetirada = funcionarioRetirada;
        this.medicamento = medicamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getQtdRetirada() {
        return qtdRetirada;
    }

    public void setQtdRetirada(int qtdRetirada) {
        this.qtdRetirada = qtdRetirada;
    }

    public Cliente getClienteRetirada() {
        return clienteRetirada;
    }

    public void setClienteRetirada(Cliente clienteRetirada) {
        this.clienteRetirada = clienteRetirada;
    }

    public Funcionario getFuncionarioRetirada() {
        return funcionarioRetirada;
    }

    public void setFuncionarioRetirada(Funcionario funcionarioRetirada) {
        this.funcionarioRetirada = funcionarioRetirada;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }
    
    



    
}
