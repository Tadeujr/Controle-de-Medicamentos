
package posto.modelo;

import java.text.SimpleDateFormat;



public class Retirada {
    protected String data;
    protected String hora;
    protected int qtdRetirada;
    Cliente clienteRetirada;
    Funcionario funcionarioRetirada;
    Medicamento medicamento;
    
    public Retirada(int qtdRetirada, Cliente clienteRetirada, Funcionario funcionarioRetirada, Medicamento medicamento){
        String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                                        .format(System.currentTimeMillis());


        String dataAtual = dataFormatada.substring(0,10);

        String horarioAtual = dataFormatada.substring(11,19);    
        
        this.data = dataAtual; // Arrumar um jeito de pegar automaticamente e armazenar separadamente.
        this.hora = horarioAtual;
        this.qtdRetirada = qtdRetirada;
        this.clienteRetirada = clienteRetirada;
        this.funcionarioRetirada = funcionarioRetirada;
        this.medicamento = medicamento;        
    }
    

    
    public void armazenarRetirada(){// subir oara i banco de Dados
    
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
