package modelo;

public class Terreno extends Financiamento {
    private final String zona;

    public Terreno(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, String zona) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return calcularPrestacaoMensalPadrao() * 1.02;
    }

    @Override
    public String paraFormatoTexto() {
        return String.join(";",
                "Terreno",
                String.valueOf(getValorImovel()),
                String.valueOf(getTaxaJurosAnual()),
                String.valueOf(getPrazoFinanciamento()),
                zona);
    }

    @Override
    public void imprimirDados() {
        double pagamentoMensal = calcularPagamentoMensal();
        double pagamentoTotal = calcularPagamentoTotal();

        System.out.println("Tipo: Terreno");
        System.out.println("Zona: " + getZona());
        System.out.printf("\nPagamento mensal + acréscimo de 2%% = R$%.2f%n\n", pagamentoMensal);
        System.out.printf("Valor do imóvel = R$%.2f%n", getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", getTaxaJurosAnual() * 100);
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");
    }
}