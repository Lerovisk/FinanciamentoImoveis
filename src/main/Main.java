package main;

import java.util.ArrayList;
import modelo.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n======= Bem-vindo! =======");

        ArrayList<Financiamento> financiamentos = new ArrayList<>(); // Cria uma ArrayList financiamentos para armazenar os financiamentos
        InterfaceUsuario novoFinanciamento = new InterfaceUsuario(); // Cria um novo objeto na classe util.InterfaceUsuario

        int tipo = novoFinanciamento.informarTipoImovel();

        System.out.println("\n- Informe abaixo os dados necessários para dar continuidade ao financiamento.\n");

        double valorImovel = novoFinanciamento.informarValorImovel(); // Informa o valor do imóvel
        double taxaJurosAnual = novoFinanciamento.informarTaxaJuros(); // Iforma a taxa de juros
        int prazoFinanciamento = novoFinanciamento.informarPrazoAnos(); // Informa o prazo do financiamento

        // Possíveis financiamentos
        switch (tipo) {
            case 1: {
                double areaDaCasa = novoFinanciamento.informarAreaDaCasa(); // Informa a area da casa (Somente para objetos do tipo Casa)
                double areaDoTerreno = novoFinanciamento.informarAreaDoTerreno(); // Informa a area do terreno (Somente para objetos do tipo Casa)
                financiamentos.add(new modelo.Casa(valorImovel, taxaJurosAnual, prazoFinanciamento, areaDaCasa, areaDoTerreno ));
                // Adiciona um novo finaciamento do tipo Casa
                break;
            }
            case 2: {
                String zona = novoFinanciamento.informarZonaDoTerreno();
                financiamentos.add(new modelo.Terreno(valorImovel, taxaJurosAnual, prazoFinanciamento, zona));
                // Adiciona um novo finaciamento do tipo Terreno
                break;
            }
            case 3: {
                int vagas = novoFinanciamento.informarVagasApartamento();
                int andar = novoFinanciamento.informarAndarApartamento();
                financiamentos.add(new modelo.Apartamento(valorImovel, taxaJurosAnual, prazoFinanciamento, vagas, andar));
                // Adiciona um novo finaciamento do tipo Apartamento
                break;
            }
            default: System.out.println("Opção de imóvel inválida!");
                break;
        }

        // Financiamentos fixos
        financiamentos.add(new modelo.Apartamento(70000, 0.1, 10, 2,7));
        financiamentos.add(new modelo.Apartamento(800000, 0.1, 10, 1, 4));
        financiamentos.add(new modelo.Terreno(1000000, 0.1, 10, "Residencial"));

        novoFinanciamento.fecharScanner(); // Fecha o scanner, pois não será mais usado (eu acho ;-;)

        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int contador = 1;

        for (Financiamento f : financiamentos) { // Imprime os financiamentos
            System.out.format("\n===== Financiamento %d =====\n", contador);
            f.imprimirDados();

            somaImoveis += f.getValorImovel(); // Soma o valor dos imóveis
            somaFinanciamentos += f.calcularPagamentoTotal(); // Soma os financiamentos dos imóveis
            contador++;
        }
        // Imprime a soma total dos valores originais dos imóveis e a soma de seus financiamentos com taxas e outras aplicações
        System.out.printf("Total da soma de todos os imóveis = R$%.2f%n", somaImoveis);
        System.out.printf("Total da soma dos financiamentos = R$%.2f%n", somaFinanciamentos);
        System.out.println("==========================================");
    }
}