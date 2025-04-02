package agifinancasfx.agifinancasfx.control;

import agifinancasfx.agifinancasfx.DAO.TransacaoContaDAO;
import agifinancasfx.agifinancasfx.Model.TransacaoConta;
import agifinancasfx.agifinancasfx.Model.Usuario;
//import view.TransacaoConta.TransacaoContaView;

public class TransacaoContaController {
    //private TransacaoContaView view;
    private TransacaoContaDAO dao;

    public TransacaoContaController(/*TransacaoContaView view, */ TransacaoContaDAO dao) {
//        this.view = view;
        this.dao = dao;
    }

    public void cadastrarTransacao(Usuario usuario) {
//        try {
//            char tipo = view.solicitarTipoTransacao();
//            double valor = view.solicitarValor();
//            String data = view.solicitarData();
//            int idConta = view.solicitarConta();
//
//            // muda o valor para negativo se for despesa
//            if (tipo == 'D') {
//                valor = -Math.abs(valor);
//            }

//            TransacaoConta transacao = new TransacaoConta(
//                    usuario.getIdUsuario(),
//                    idConta,
//                    valor,
//                    data,
//                    String.valueOf(tipo)
//            );
//
//            dao.inserirTransacao(transacao);
//            view.mostrarSucesso();
//
//        } catch (Exception e) {
//            view.mostrarErro(e.getMessage());
//        }
    }
}

