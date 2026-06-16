package main;

import java.util.ArrayList;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.RelatorioFinanciamento;
import util.InterfaceUsuario;

public class Main { // Criando a classe Main
    public static void main(String[] args) {

        System.out.println("\n======= Bem-vindo! =======");
        System.out.println("\n- Informe abaixo os dados necessários para dar continuidade ao financiamento.\n");

        ArrayList<Financiamento> financiamentos = new ArrayList<>(); // Criando a ArrayList financiamentos
        InterfaceUsuario novosDados = new InterfaceUsuario(); // Criando um novo objeto na classe util.InterfaceUsuario

        double valorImovel = novosDados.informarValorImovel(); // Informando o valor do imóvel
        double taxaJurosAnual = novosDados.informarTaxaJuros(); // Iformando a taxa de juros
        int prazoFinanciamento = novosDados.informarPrazoAnos(); // Informando o prazo do financiamento

        financiamentos.add(new modelo.Casa(valorImovel, taxaJurosAnual, prazoFinanciamento));
        financiamentos.add(new modelo.Casa(50000, 0.1, 10));
        financiamentos.add(new modelo.Apartamento(70000, 0.1, 10));
        financiamentos.add(new modelo.Apartamento(800000, 0.1, 10));
        financiamentos.add(new modelo.Terreno(1000000, 0.1, 10));


        RelatorioFinanciamento relatorio = new RelatorioFinanciamento(); // Criando um objeto do tipo RelatorioFinanciamento
        int contador = 1;
        novosDados.fecharScanner(); // Fechando o scanner, pois não será mais usado (eu acho)

        for (Financiamento f : financiamentos) { // Imprimindo os financiamentos
            System.out.format("\n===== Financiamento %d =====\n", contador);
            relatorio.imprimirDados(f);
            contador ++;
        }
        relatorio.imprimirTotais(financiamentos); // Imprimindo a soma total dos financiamentos
    }
}