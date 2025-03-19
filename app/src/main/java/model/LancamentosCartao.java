package model;

public class LancamentosCartao {
    private int recorrencia;
    private int valor;
    private int data;
    private int idCartao;
    private int idLancamento;

    public void Cartao(int recorrencia, int valor, int data, int idCartao, int idLancamento){
        this.recorrencia = recorrencia;
        this.valor = valor;
        this.data = data;
        this.idCartao = idCartao;
        this.idLancamento = idLancamento;
    }

    public int getNome(){
        return recorrencia;
    }

    public void setIdLancamento(int idLancamento) {
        this.idLancamento = idLancamento;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setRecorrencia(int recorrencia) {
        this.recorrencia = recorrencia;
    }

    public int getLimite(){
        return valor;
    }

    public int getData(){
        return data;
    }

    public int getIdCartao(){
        return idCartao;
    }

    public int getIdLancamento(){
        return idLancamento;
    }
}
