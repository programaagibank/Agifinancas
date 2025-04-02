package agifinancasfx.agifinancasfx.Model;

public class TelefoneUsuario {
    private int id_telefone;
    private int id_usuario;
    private int ddd_telefone;
    private double num_telefone;

    public TelefoneUsuario(int id_telefone, int id_usuario, int ddd_telefone, double num_telefone) {
        this.id_telefone = id_telefone;
        this.id_usuario = id_usuario;
        this.ddd_telefone = ddd_telefone;
        this.num_telefone = num_telefone;
    }

    public int getId_telefone() {
        return id_telefone;
    }

    public void setId_telefone(int id_telefone) {
        this.id_telefone = id_telefone;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getDdd_telefone() {
        return ddd_telefone;
    }

    public void setDdd_telefone(int ddd_telefone) {
        this.ddd_telefone = ddd_telefone;
    }

    public double getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(double num_telefone) {
        this.num_telefone = num_telefone;
    }
}
