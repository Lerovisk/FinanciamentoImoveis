package modelo;

public class Casa extends Financiamento {
    private final double areaDaCasa;
    private final double areaDoTerreno;

    public Casa(double valorImovel, double taxaJurosAnual, int prazoFinanciamento, double areaDaCasa, double areaDoTerreno) {
        super(valorImovel, taxaJurosAnual, prazoFinanciamento);
        this.areaDaCasa = areaDaCasa;
        this.areaDoTerreno = areaDoTerreno;
    }

    public double getAreaDaCasa() {
        return areaDaCasa;
    }

    public double getAreaDoTerreno() {
        return areaDoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        return calcularPrestacaoMensalPadrao() + 240;
    }

    @Override
    public String paraFormatoTexto() {
        return String.join(";",
                "Casa",
                String.valueOf(getValorImovel()),
                String.valueOf(getTaxaJurosAnual()),
                String.valueOf(getPrazoFinanciamento()),
                String.valueOf(areaDaCasa),
                String.valueOf(areaDoTerreno));
    }

    @Override
    public void imprimirDados() {
        double pagamentoMensal = calcularPagamentoMensal();
        double pagamentoTotal = calcularPagamentoTotal();

        System.out.println("Tipo: Casa");
        System.out.printf("Área da construção da casa = %.2fm²%n", getAreaDaCasa());
        System.out.printf("Área do terreno = %.2fm²%n", getAreaDoTerreno());
        System.out.printf("\nPagamento mensal + R$240,00 (seguro) = R$%.2f\n", pagamentoMensal);
        System.out.println();
        System.out.printf("Valor do imóvel = R$%.2f%n", getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", getTaxaJurosAnual() * 100);
        System.out.println("Prazo do financiamento: " + getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f\n", pagamentoTotal);
        System.out.println("\n==========================");
    }
}