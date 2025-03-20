package model;

public class User {
    private int idUsuario;
    private String CPF;
    private String nome;
    private String sobrenome;
    private String senha;
    private String email;


    public User (int id, String CPF, String nome, String sobrenome, String senha, String email) {
        this.idUsuario = id;
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.email = email;
    }
    public User (String CPF, String nome, String sobrenome, String senha, String email) {
        this.CPF = CPF;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.senha = senha;
        this.email = email;
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

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getId() {return idUsuario;}

    public void setId(int id) {this.idUsuario = id;}
}
