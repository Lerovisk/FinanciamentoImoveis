package modelo;

public class Casa extends Financiamento { // Especificação

    // Atributos
    private final double areaDaCasa;
    private final double areaDoTerreno;

    // Construtor
    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, double areaDaCasa, double areaDoTerreno){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
        this.areaDoTerreno = areaDoTerreno;
        this.areaDaCasa = areaDaCasa;
    }

    // Getters

    public double getAreaDaCasa(){
        return areaDaCasa;
    }
    public double getAreaDoTerreno(){
            return areaDoTerreno;
    }

    // Metodos
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para casa
        return (getValorImovel() / (getPrazoFinanciamento() * 12.0)) * (1 + (getTaxaJurosAnual() / 12.0)) + 240;
    }
}