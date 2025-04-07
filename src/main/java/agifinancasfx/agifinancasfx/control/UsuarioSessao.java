package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.Model.Usuario;

public class UsuarioSessao {
    private static UsuarioSessao instancia;
    private Usuario usuario;

    private UsuarioSessao() {}

    public static UsuarioSessao getInstance() {
        if (instancia == null) {
            instancia = new UsuarioSessao();
        }
        return instancia;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
