package modelo;

public class Terreno extends Financiamento { // Especificação

    // Atributos
    String zona;

    // Construtor
    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, String zona){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
        this.zona = zona;
    }

    // Metodo
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para terreno
        return (getValorImovel() / (getPrazoFinanciamento() * 12.0)) * (1 + (getTaxaJurosAnual() / 12.0)) * (1 + (2.0/100)); // podia ser * 1.02, tanto faz.
    }
}