package model;

import DAO.LancamentoCartaoDAO;

import java.util.ArrayList;
import java.util.List;

public class LancamentosCartao {
        private int idLancamento;
        private int idCartao;
        private double valor;
        private String data;
        private boolean recorrencia;

        public LancamentosCartao(int idLancamento, int idCartao, double valor, String data, boolean recorrencia) {
            this.idLancamento = idLancamento;
            this.idCartao = idCartao;
            this.valor = valor;
            this.data = data;
            this.recorrencia = recorrencia;
        }

        // Getters e Setters
        public int getIdLancamento() {
            return idLancamento;
        }

        public void setIdLancamento(int idLancamento) {
            this.idLancamento = idLancamento;
        }

        public int getIdCartao() {
            return idCartao;
        }

        public void setIdCartao(int idCartao) {
            this.idCartao = idCartao;
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

        public boolean isRecorrencia() {
            return recorrencia;
        }

        public void setRecorrencia(boolean recorrencia) {
            this.recorrencia = recorrencia;
        }

        @Override
        public String toString() {
            return "Lançamento{" +
                    "ID do Lançamento=" + idLancamento +
                    ", ID do Cartão=" + idCartao +
                    ", Valor=" + valor +
                    ", Data=" + data +
                    ", Recorrente=" + (recorrencia ? "Sim" : "Não") +
                    '}';
        }

    public int getIdLancamentoCartao() {
        return 0;
    }
}







