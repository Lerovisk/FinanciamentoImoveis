package util;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.util.ArrayList;

public class RelatorioFinanciamento {
    // Métodos
    public void imprimirDados(Financiamento f){ // Imprimindo os valores a serem pagos após o cálculo
        double pagamentoMensal = f.calcularPagamentoMensal(); // Chamando a função de calcular o pagamento mensal
        double pagamentoTotal = f.calcularPagamentoTotal(); // Chamando a função de calcular o pagamento total com a taxa aplicada

        /* Escolhi fazer a apresentação desse jeito*/

        if (f instanceof Casa casa) {
            System.out.println("Tipo: Casa");
            System.out.printf("Área da construção da casa = %.2fm²%n", casa.getAreaDaCasa());
            System.out.printf("Área do terreno = %.2fm²%n", casa.getAreaDoTerreno());
            System.out.printf("Pagamento mensal + R$240,00 (seguro) = R$%.2f%n", pagamentoMensal);
            System.out.println();
        } else if (f instanceof Apartamento) {
            System.out.println("Tipo: Apartamento");
            System.out.printf("Pagamento mensal = R$%.2f%n", pagamentoMensal);
        } else if (f instanceof Terreno) {
            System.out.println("Tipo: Terreno");
            System.out.printf("Pagamento mensal + acréscimo de 2%% = R$%.2f%n", pagamentoMensal);
        }

        System.out.printf("Valor do imóvel = R$%.2f%n", f.getValorImovel());
        System.out.printf("Taxa aplicada anualmente = %.2f%%%n", f.getTaxaJurosAnual()*100);
        System.out.println("Anos = " + f.getPrazoFinanciamento() + " anos.");
        System.out.printf("Pagamento total = R$%.2f", pagamentoTotal);
        System.out.println("\n==========================");
    }

    public void imprimirSomaTotais(ArrayList<Financiamento> financiamentos){
        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        for (Financiamento f : financiamentos) {
            somaImoveis += f.getValorImovel();  // Calculando a soma do valor dos imóveis e a soma de seus financiamentos
            somaFinanciamentos += f.calcularPagamentoTotal();
        }
        System.out.printf("\nTotal da soma de todos os imóveis = R$%.2f\n", somaImoveis);
        System.out.printf("Total da soma dos financiamentos = R$%.2f", somaFinanciamentos);
    }
}