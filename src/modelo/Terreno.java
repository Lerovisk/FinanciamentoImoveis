package modelo;

public class Terreno extends Financiamento { // Especificação

    // Atributos
    private final String zona;

    // Construtor
    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, String zona){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
        this.zona = zona;
    }

    // Getters
    public String getZona(){
        return zona;
    }

    // Metodos
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para terreno
        return (getValorImovel() / (getPrazoFinanciamento() * 12.0)) * (1 + (getTaxaJurosAnual() / 12.0)) * (1 + (2.0/100)); // podia ser * 1.02, tanto faz.
    }

    @Override
    public void imprimirDados() {
        double pagamentoMensal = this.calcularPagamentoMensal(); // Chamando a função de calcular o pagamento mensal
        double pagamentoTotal = this.calcularPagamentoTotal(); // Chamando a função de calcular o pagamento total com a taxa aplicada

        System.out.println("Tipo: Terreno");
        System.out.println("Zona: " + this.getZona());
        System.out.printf("\nPagamento mensal + acréscimo de 2%% = R$%.2f%n\n", pagamentoMensal);

        System.out.printf("Valor do imóvel = R$%.2f%n", this.getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", this.getTaxaJurosAnual() * 100);
        System.out.println("Anos: " + this.getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");

    }
}