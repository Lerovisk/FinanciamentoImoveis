package modelo;

public class Apartamento extends Financiamento { // Especificação

    // Atributos
    private final int vagas;
    private final int andar;

    // Construtor
    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, int vagas, int andar){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
        this.vagas = vagas;
        this.andar = andar;
    }
    // Getters

    public int getVagas(){
        return vagas;
    }
    public int getAndar(){
        return andar;
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