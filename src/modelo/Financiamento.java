package modelo;

public abstract class Financiamento { // Classe-pai - generalização

    // Atributos
    private final double valorImovel;
    private final double taxaJurosAnual;
    private final int prazoFinanciamento;

    // Construtor
    public Financiamento(double valorInicialImovel, double taxaInicialJurosAnual, int prazoInicialFinanciamento) {
        this.valorImovel = valorInicialImovel;
        this.taxaJurosAnual = taxaInicialJurosAnual;
        this.prazoFinanciamento = prazoInicialFinanciamento;
    }

    // Métodos abstratos
    public abstract double calcularPagamentoMensal();  // Define que as classes-filhas precisam calcular o pagamento mensal
    public abstract void imprimirDados(); // Define que as classes-filhas precisam imprimir seus dados

    // Métodos concretos e getters
    public double calcularPagamentoTotal() { // Calcula o total a ser pago de acordo com o prazo por ano
        return calcularPagamentoMensal() * getPrazoFinanciamento() * 12;
    }
    // Getters
    public double getValorImovel() { // Declara o acesso ao valor do imóvel
        return valorImovel;
    }
    public double getTaxaJurosAnual() { // Declara o acesso a taxa de juros
        return taxaJurosAnual;
    }
    public int getPrazoFinanciamento() { // Declara o acesso ao prazo do financiamento
        return prazoFinanciamento;
    }
}