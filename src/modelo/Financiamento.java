package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private final double valorImovel;
    private final double taxaJurosAnual;
    private final int prazoFinanciamento;

    public Financiamento(double valorInicialImovel, double taxaInicialJurosAnual, int prazoInicialFinanciamento) {
        if (valorInicialImovel <= 0) {
            throw new IllegalArgumentException("O valor do imóvel deve ser positivo.");
        }
        if (taxaInicialJurosAnual <= 0 || taxaInicialJurosAnual > 1) {
            throw new IllegalArgumentException("A taxa de juros deve estar entre 0 e 1.");
        }
        if (prazoInicialFinanciamento <= 0 || prazoInicialFinanciamento > 35) {
            throw new IllegalArgumentException("O prazo deve estar entre 1 e 35 anos.");
        }

        this.valorImovel = valorInicialImovel;
        this.taxaJurosAnual = taxaInicialJurosAnual;
        this.prazoFinanciamento = prazoInicialFinanciamento;
    }

    public abstract double calcularPagamentoMensal();
    public abstract void imprimirDados();
    public abstract String paraFormatoTexto();

    protected double calcularPrestacaoMensalPadrao() {
        int meses = getPrazoFinanciamento() * 12;
        double taxaMensal = getTaxaJurosAnual() / 12.0;

        if (taxaMensal == 0.0) {
            return getValorImovel() / meses;
        }

        return getValorImovel() * taxaMensal / (1 - Math.pow(1 + taxaMensal, -meses));
    }

    public double calcularPagamentoTotal() {
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }
}