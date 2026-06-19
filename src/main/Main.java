package main;

import java.util.ArrayList;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n======= Bem-vindo! =======");
        System.out.println("\n- Informe abaixo os dados necessários para dar continuidade ao financiamento.\n");

        ArrayList<Financiamento> financiamentos = new ArrayList<>(); // Criando a ArrayList financiamentos para armazenar os financiamentos
        InterfaceUsuario novoFinanciamento = new InterfaceUsuario(); // Criando um novo objeto na classe util.InterfaceUsuario

        double valorImovel = novoFinanciamento.informarValorImovel(); // Informando o valor do imóvel
        double taxaJurosAnual = novoFinanciamento.informarTaxaJuros(); // Iformando a taxa de juros
        int prazoFinanciamento = novoFinanciamento.informarPrazoAnos(); // Informando o prazo do financiamento

        double areaDaCasa = novoFinanciamento.informarAreaDaCasa(); // Informando a area da casa (Somente para objetos do tipo Casa)
        double areaDoTerreno = novoFinanciamento.informarAreaDoTerreno(); // Informando a area do terreno (Somente para objetos do tipo Casa)

        financiamentos.add(new modelo.Casa(valorImovel, taxaJurosAnual, prazoFinanciamento, areaDaCasa, areaDoTerreno));
        financiamentos.add(new modelo.Casa(50000, 0.1, 10, 400.00, 700.00));

        financiamentos.add(new modelo.Apartamento(70000, 0.1, 10, 2,7));
        financiamentos.add(new modelo.Apartamento(800000, 0.1, 10, 1, 4));

        financiamentos.add(new modelo.Terreno(1000000, 0.1, 10, "Residencial"));


        novoFinanciamento.fecharScanner(); // Fechando o scanner, pois não será mais usado (eu acho)

        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int contador = 1;

        for (Financiamento f : financiamentos) { // Imprimindo os financiamentos
            System.out.format("\n===== Financiamento %d =====\n", contador);
            f.imprimirDados();

            somaImoveis += f.getValorImovel();
            somaFinanciamentos += f.calcularPagamentoTotal();
            contador++;
        }
        System.out.printf("Total da soma de todos os imóveis = R$%.2f%n", somaImoveis);
        System.out.printf("Total da soma dos financiamentos = R$%.2f%n", somaFinanciamentos);
        System.out.println("==========================================");
    }
}