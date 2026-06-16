package modelo;

public class Casa extends Financiamento { // Especificação
    // Construtor
    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
    }

    // Metodo
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para casa
        return super.calcularPagamentoMensal() + 240;
    }
}