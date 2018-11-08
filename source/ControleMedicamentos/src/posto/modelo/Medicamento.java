
package posto.modelo;

public class Medicamento {
    protected int id_medicamento;
    protected String descricao;
    protected String nome;
    protected String validade;
    protected String lote;
    protected int qtdDisponivel;
    
    public Medicamento(String nome,String descricao, String validade, String lote,int qtdDisponivel){
        this.nome = nome;
        this.descricao = descricao;
        this.validade = validade;
        this.lote = lote;
        this.qtdDisponivel = qtdDisponivel;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
    
    
    
    
}
