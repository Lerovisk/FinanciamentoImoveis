package modelo;

public class Apartamento extends Financiamento { // Especificação

    // Atributos
    private final int vagasGaragem;
    private final int andar;

    // Construtor
    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, int vagas, int andar){
        super(valorImovel,taxaJurosAnual, prazoFinanciamento);
        this.vagasGaragem = vagas;
        this.andar = andar;
    }
    // Getters

    public int getVagasGaragem(){
        return vagasGaragem;
    }
    public int getAndar(){
        return andar;
    }
    // Metodos

    @Override
    public double calcularPagamentoTotal() {
        return getValorImovel() * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));
    }
    @Override
    public double calcularPagamentoMensal() { // Calculando pagamento mensal específico para apartamento
        return calcularPagamentoTotal() / (getPrazoFinanciamento() * 12);
    }

    @Override
    public void imprimirDados() {
        double pagamentoMensal = this.calcularPagamentoMensal(); // Chamando a função de calcular o pagamento mensal
        double pagamentoTotal = this.calcularPagamentoTotal(); // Chamando a função de calcular o pagamento total com a taxa aplicada

        System.out.println("Tipo: Apartamento");
        System.out.println("Vagas disponíveis: " + this.getVagasGaragem());
        System.out.println("Andares: " + this.getAndar());
        System.out.printf("\nPagamento mensal = R$%.2f%n\n", pagamentoMensal);

        System.out.printf("Valor do imóvel = R$%.2f%n", this.getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", this.getTaxaJurosAnual() * 100);
        System.out.println("Anos: " + this.getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");

    }
}