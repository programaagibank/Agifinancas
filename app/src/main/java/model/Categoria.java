package model;

public class Categoria {
    private int id_categoria;
    private int id_usuario;
    private String nome;
    private String tipo;
    private Double limite;
    private Double valor;

    public Categoria( String nome, String tipo, Double limite) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.tipo = tipo;
        this.limite = limite;
    }

    public Categoria(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Categoria(int idUsuario, String nome, String tipo, Double limite) {
        this.id_usuario = idUsuario;
        this.nome = nome;
        this.tipo = tipo;
        this.limite = limite;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLimite(double limite) { this.limite = limite; }

    public double getLimite() { return limite; }
}
