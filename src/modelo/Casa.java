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
    public double calcularPagamentoMensal() { // Calcula o pagamento mensal específico para casa
        return (getValorImovel() / (getPrazoFinanciamento() * 12.0)) * (1 + (getTaxaJurosAnual() / 12.0)) + 240;
    }
    @Override
    public void imprimirDados() { // Imprime os dados de casa
        double pagamentoMensal = this.calcularPagamentoMensal(); // Chama a função de calcular o pagamento mensal
        double pagamentoTotal = this.calcularPagamentoTotal(); // Chama a função de calcular o pagamento total com a taxa aplicada

        System.out.println("Tipo: Casa");
        System.out.printf("Área da construção da casa = %.2fm²%n", this.getAreaDaCasa());
        System.out.printf("Área do terreno = %.2fm²%n", this.getAreaDoTerreno());
        System.out.printf("\nPagamento mensal + R$240,00 (seguro) = R$%.2f\n", pagamentoMensal);
        System.out.println();

        System.out.printf("Valor do imóvel = R$%.2f%n", this.getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", this.getTaxaJurosAnual() * 100);
        System.out.println("Prazo do financiamento: " + this.getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");

    }
}