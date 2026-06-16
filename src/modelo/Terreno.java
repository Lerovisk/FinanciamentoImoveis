package modelo;

public class Terreno extends Financiamento { // Especificação
    // Construtor
    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
    }

    // Metodo
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para terreno
        return super.calcularPagamentoMensal() * (1 + (2.0/100)); // podia ser * 1.02, tanto faz.
    }
}