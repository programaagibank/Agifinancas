package model;

import java.sql.Date;

public class Meta {
    private int id;
    private int id_usuario;
    private String nome;
    private String valor;
    private Date validade;

    // Construtor explícito
    public Meta(int id, int id_usuario, String nome, String valor, Date validade) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.valor = valor;
        this.validade = validade;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
