package model;

public class ModelCartao {
    private String nome;
    private int limite;
    private int dataFechamento;
    private int dataValidade;
    private int idCartao;
    private int idUsuario;

    ModelCartao(String nome, int limite, int dataFechamento, int dataValidade, int idCartao, int idUsuario){
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
