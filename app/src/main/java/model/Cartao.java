
package model;

public class Cartao {
    private String nome;
    private int limite;
    private int dataFechamento;
    private int dataValidade;
    private int idCartao;
    private int idUsuario;

    Cartao(String nome, int limite, int dataFechamento, int dataValidade, int idCartao, int idUsuario){
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

    public int getLimite(){
        return limite;
    }

    public int getDataFechamento(){
        return dataFechamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public void setDataFechamento(int dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setDataValidade(int dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDataValidade(){
        return dataValidade;
    }

    public int getIdCartao(){
        return idCartao;
    }

    public int getIdUsuario(){
        return idUsuario;
    }
}
