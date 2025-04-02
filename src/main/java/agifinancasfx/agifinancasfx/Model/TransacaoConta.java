package agifinancasfx.agifinancasfx.Model;

public class TransacaoConta {
    private int id;
    private int idUsuario;
    private int idConta;
    private double valor;
    private String data;
    private String tipo;

    public TransacaoConta(int idUsuario, int idConta, double valor, String data, String tipo) {
        this.idUsuario = idUsuario;
        this.idConta = idConta;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
