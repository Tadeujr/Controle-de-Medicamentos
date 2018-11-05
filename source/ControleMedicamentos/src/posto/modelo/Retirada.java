
package posto.modelo;


public class Retirada {
    protected String data;
    protected String hora;
    protected int qtdRetirada;
    Cliente clienteRetirada;
    Funcionario funcionarioRetirada;
    Medicamento medicamento;
    
    
    public void armazenarRetirada(){// subir oara i banco de Dados
    
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
    
}
