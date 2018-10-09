
package posto.modelo;

import java.io.Serializable;

public class Medicamento implements Serializable  {
    /* criar um ArrayList? */
    protected String descricao;
    protected String nome;
    protected String validade;
    protected String lote;
    protected int qtdDisponivel;

    public Medicamento(String descricao, String nome, String validade, String lote, int qtdDisponivel) {
        this.descricao = descricao;
        this.nome = nome;
        this.validade = validade;
        this.lote = lote;
        this.qtdDisponivel = qtdDisponivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getValidade() {
        return validade;
    }

    public String getLote() {
        return lote;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    
    
    
    
}
