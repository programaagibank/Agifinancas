
package model;

import java.util.Date;

public class Cartao {
    private String nome;
    private double limite;
    private String dataFechamento;
    private String dataValidade;
    private int idCartao;
    private int idUsuario;

    public Cartao(String nome, double limite, String dataFechamento, String dataValidade, int idCartao, int idUsuario){
        this.nome = nome;
        this.limite = limite;
        this.dataFechamento = dataFechamento;
        this.dataValidade = dataValidade;
        this.idCartao = idCartao;
        this.idUsuario = idUsuario;
    }

    public String getNome(){
        return "Nome: " + nome;
    }

    public double getLimite(){
        return limite;
    }

    public String getDataFechamento(){
        return dataFechamento;
    }

    public Cartao(String nome, double limite, String dataFechamento, String dataValidade, int idUsuario) {
        this.nome = nome;
        this.limite = limite;
        this.dataFechamento = dataFechamento;
        this.dataValidade = dataValidade;
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataValidade(){
        return dataValidade;
    }

    public int getIdCartao(){
        return idCartao;
    }

    public int getIdUsuario(){
        return idUsuario;
    }
}
