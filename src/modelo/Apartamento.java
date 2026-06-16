package modelo;

public class Apartamento extends Financiamento { // Especificação
    // Construtor
    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
    }

    // Metodo
    @Override
    public double calcularPagamentoTotal() {
        return getValorImovel() * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));
    }
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para apartamento
        return calcularPagamentoTotal() / (getPrazoFinanciamento() * 12);
    }
}