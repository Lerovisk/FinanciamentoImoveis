package modelo;

public abstract class Financiamento{ // Generalização

    // Atributos
    private final double valorImovel;
    private final double taxaJurosAnual;
    private final int prazoFinanciamento;

    // Construtor - itens obrigatórios
    public Financiamento(double valorInicialImovel, double taxaInicialJurosAnual, int  prazoInicialFinanciamento){
        this.valorImovel = valorInicialImovel;
        this.taxaJurosAnual = taxaInicialJurosAnual;
        this.prazoFinanciamento = prazoInicialFinanciamento;
    }
    // Getters
    public double getValorImovel(){ // Declarando o acesso ao valor do imóvel
        return valorImovel;
    }
    public double getTaxaJurosAnual() { // Declarando o acesso a taxa de juros
        return taxaJurosAnual;
    }
    public int getPrazoFinanciamento(){ // Declarando o acesso ao prazo do financiamento
        return prazoFinanciamento;
    }

    // Métodos
    public abstract double calcularPagamentoMensal();// Calculando o valor do pagamento mensal (em relação a taxa)

    public double calcularPagamentoTotal() { // Calculando o total a ser pago de acordo com o prazo
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }
}