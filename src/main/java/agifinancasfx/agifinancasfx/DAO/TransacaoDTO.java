package agifinancasfx.agifinancasfx.DAO;


import java.math.BigDecimal;
import java.util.Date;

public class TransacaoDTO {
    private String categoria;
    private BigDecimal valor;
    private Date dataTransacao;
    private String tipo;

    // Getters e setters
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Date getDataTransacao() { return dataTransacao; }
    public void setDataTransacao(Date dataTransacao) { this.dataTransacao = dataTransacao; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}


