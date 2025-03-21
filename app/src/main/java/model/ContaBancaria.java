package model;

public class ContaBancaria {
    private double saldo;
    private double id_usuario;

    private int id_conta;


    public ContaBancaria(double saldo, double id_usuario, int id_conta) {

        this.saldo = saldo;
        this.id_usuario = id_usuario;
        this.id_conta = id_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(double id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }
}

