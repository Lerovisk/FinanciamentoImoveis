package util;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;

public class InterfaceUsuario {
    private final Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    public int informarTipoImovel() {
        int tipo = 0;
        do {
            System.out.println("Opções de financiamento: ");
            System.out.println("1 - Casa");
            System.out.println("2 - Terreno");
            System.out.println("3 - Apartamento");
            System.out.print("Escolha o tipo de imóvel que deseja financiar: ");
            try {
                tipo = sc.nextInt();
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Erro: escolha entre as opções 1, 2 ou 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números!");
                sc.next();
            }
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }

    private double lerDouble(String prompt, DoublePredicate condicao, String mensagemErro) {
        double valor;
        while (true) {
            System.out.print(prompt);
            try {
                valor = sc.nextDouble();
                if (condicao.test(valor)) {
                    return valor;
                }
                System.out.println(mensagemErro);
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números decimais.");
                sc.next(); // Limpa o buffer do scanner
            }
        }
    }

    private int lerInt(String prompt, IntPredicate condicao, String mensagemErro) {
        int valor;
        while (true) {
            System.out.print(prompt);
            try {
                valor = sc.nextInt();
                if (condicao.test(valor)) {
                    return valor;
                }
                System.out.println(mensagemErro);
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite apenas números inteiros.");
                sc.next(); // Limpa o buffer do scanner
            }
        }
    }

    public double informarValorImovel() {
        return lerDouble("1) Digite o valor do imóvel R$", v -> v > 0, "Erro: somente números positivos, tente novamente.");
    }

    public double informarTaxaJuros() {
        return lerDouble("2) Digite a taxa do financiamento (em decimal, exemplo: 0.10): ", t -> t > 0 && t <= 1, "Erro: a taxa deve ser entre 0 e 1.");
    }

    public int informarPrazoAnos() {
        return lerInt("3) Digite o prazo do financiamento (em anos): ", p -> p > 0 && p <= 35, "Erro: o prazo deve ser entre 1 e 35 anos.");
    }

    public double informarAreaDaCasa() {
        return lerDouble("4) Digite a área da construção da casa (m²): ", a -> a > 30 && a <= 3000, "Erro: a área deve estar entre 30m² e 3000m².");
    }

    public double informarAreaDoTerreno() {
        return lerDouble("5) Digite a área do terreno (m²): ", a -> a > 100 && a <= 50000, "Erro: a área deve estar entre 100m² e 50000m².");
    }

    public String informarZonaDoTerreno() {
        String zona;
        do {
            System.out.print("4) Digite a zona do terreno (Residencial ou Comercial): ");
            zona = sc.next();
            if (!zona.equalsIgnoreCase("Residencial") && !zona.equalsIgnoreCase("Comercial")) {
                System.out.println("Erro: Digite exatamente 'Residencial' ou 'Comercial'.");
            }
        } while (!zona.equalsIgnoreCase("Residencial") && !zona.equalsIgnoreCase("Comercial"));
        return zona;
    }

    public int informarVagasApartamento() {
        return lerInt("4) Digite o número de vagas da garagem: ", v -> v >= 0 && v <= 4, "Erro: O número de vagas deve ser entre 0 e 4.");
    }

    public int informarAndarApartamento() {
        return lerInt("5) Digite o andar do apartamento: ", a -> a >= 0 && a <= 20, "Erro: O andar deve ser entre 0 e 20.");
    }

    public boolean informarContinuar() {
        while (true) {
            System.out.print("Deseja cadastrar outro financiamento? (s/n): ");
            String resposta = sc.next().trim().toLowerCase(Locale.ROOT);
            if ("s".equals(resposta) || "sim".equals(resposta)) {
                return true;
            }
            if ("n".equals(resposta) || "nao".equals(resposta) || "não".equals(resposta)) {
                return false;
            }
            System.out.println("Resposta inválida. Digite S ou N.");
        }
    }

    public void fecharScanner() {
        sc.close();
    }
}