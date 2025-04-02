package agifinancasfx.agifinancasfx.Model;

import java.util.Date;

public class Transacao_meta {
    private int idUsuario;
    private int idMeta;
    private int idTransacao;
    private int idConta;
    private double valor;
    private Date dataTransacao;
    private String tipoTransacao;

    public Transacao_meta(int id, int idMeta, int idTransacao, int idConta, double valor, Date dataTransacao, String tipoTransacao) {
        this.idUsuario = idUsuario;
        this.idMeta = idMeta;
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }
    public Transacao_meta( int idMeta, int idTransacao, int idConta, double valor, Date dataTransacao, String tipoTransacao) {
        this.idMeta = idMeta;
        this.idTransacao = idTransacao;
        this.idConta = idConta;
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(int idMeta) {
        this.idMeta = idMeta;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public java.sql.Date getDataTransacao() {
        return (java.sql.Date) dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(String tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
