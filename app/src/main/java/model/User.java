package model;

public class User {
    private String CPF;
    private String nome;
    private String sobrenome;
    private String senha;

    public User (String CPF, String nome, String sobrenome, String senha){
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
