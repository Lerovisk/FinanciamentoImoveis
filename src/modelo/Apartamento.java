package modelo;

public class Apartamento extends Financiamento {
    private final int vagasGaragem;
    private final int andar;

    public Apartamento(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, int vagas, int andar) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.vagasGaragem = vagas;
        this.andar = andar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getAndar() {
        return andar;
    }

    @Override
    public double calcularPagamentoMensal() {
        return calcularPrestacaoMensalPadrao();
    }

    @Override
    public String paraFormatoTexto() {
        return String.join(";",
                "Apartamento",
                String.valueOf(getValorImovel()),
                String.valueOf(getTaxaJurosAnual()),
                String.valueOf(getPrazoFinanciamento()),
                String.valueOf(vagasGaragem),
                String.valueOf(andar));
    }

    @Override
    public void imprimirDados() {
        double pagamentoMensal = calcularPagamentoMensal();
        double pagamentoTotal = calcularPagamentoTotal();

        System.out.println("Tipo: Apartamento");
        System.out.println("Vagas na garagem: " + getVagasGaragem());
        System.out.println("Andar: " + getAndar());
        System.out.printf("\nPagamento mensal = R$%.2f%n\n", pagamentoMensal);
        System.out.printf("Valor do imóvel = R$%.2f%n", getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", getTaxaJurosAnual() * 100);
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");
    }
}