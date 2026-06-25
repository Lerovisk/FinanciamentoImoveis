package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Financiamento;
import util.InterfaceUsuario;
import util.PersistenciaFinanciamentos;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n======= Bem-vindo! =======");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> financiamentos = coletarFinanciamentos(interfaceUsuario);

        if (financiamentos.isEmpty()) {
            System.out.println("Nenhum financiamento foi cadastrado.");
        } else {
            salvarDados(financiamentos);
            imprimirRelatorioFinal(financiamentos);
        }

        interfaceUsuario.fecharScanner();
        System.out.println("==========================================");
    }

    private static List<Financiamento> coletarFinanciamentos(InterfaceUsuario ui) {
        List<Financiamento> financiamentos = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n- Informe abaixo os dados necessários para dar continuidade ao financiamento.\n");

            int tipo = ui.informarTipoImovel();
            double valorImovel = ui.informarValorImovel();
            double taxaJurosAnual = ui.informarTaxaJuros();
            int prazoFinanciamento = ui.informarPrazoAnos();

            switch (tipo) {
                case 1: {
                    double areaDaCasa = ui.informarAreaDaCasa();
                    double areaDoTerreno = ui.informarAreaDoTerreno();
                    financiamentos.add(new modelo.Casa(valorImovel, taxaJurosAnual, prazoFinanciamento, areaDaCasa, areaDoTerreno));
                    break;
                }
                case 2: {
                    String zona = ui.informarZonaDoTerreno();
                    financiamentos.add(new modelo.Terreno(valorImovel, taxaJurosAnual, prazoFinanciamento, zona));
                    break;
                }
                case 3: {
                    int vagas = ui.informarVagasApartamento();
                    int andar = ui.informarAndarApartamento();
                    financiamentos.add(new modelo.Apartamento(valorImovel, taxaJurosAnual, prazoFinanciamento, vagas, andar));
                    break;
                }
                default:
                    // Este caso é teoricamente inalcançável devido à validação em informarTipoImovel()
                    System.out.println("Opção de imóvel inválida!");
                    break;
            }

            continuar = ui.informarContinuar();
        }
        return financiamentos;
    }

    private static void salvarDados(List<Financiamento> financiamentos) {
        PersistenciaFinanciamentos persistencia = new PersistenciaFinanciamentos("dados");
        try {
            persistencia.salvarTexto(financiamentos);
            persistencia.salvarSerializado(financiamentos);
            System.out.println("\nDados salvos com sucesso em 'dados/financiamentos.txt' e 'dados/financiamentos.ser'.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    private static void imprimirRelatorioFinal(List<Financiamento> financiamentos) {
        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int contador = 1;

        for (Financiamento financiamento : financiamentos) {
            System.out.printf("\n===== Financiamento %d =====\n", contador++);
            financiamento.imprimirDados();
            somaImoveis += financiamento.getValorImovel();
            somaFinanciamentos += financiamento.calcularPagamentoTotal();
        }

        System.out.printf("Total da soma de todos os imóveis = R$%.2f%n", somaImoveis);
        System.out.printf("Total da soma dos financiamentos = R$%.2f%n", somaFinanciamentos);
    }
}