package util;
import java.util.InputMismatchException; // Importando o tratamento de exceções
import java.util.Scanner; // Importando o Scanner

public class InterfaceUsuario {  // Criando a classe InterfaceUsuario
    Scanner scanner = new Scanner(System.in);

    // Métodos
    public double informarValorImovel() { // Pedindo ao usuário que informe o valor do imóvel
        double valor = 0;
        do {
            try {
                /* Pesquisei por conta própria como utilizar exceções em Java pois achei que seria útil neste projeto!!! */
                System.out.print("1) Digite o valor do imóvel R$");
                valor = scanner.nextDouble();
                if (valor <= 0) { // Evitando que seja digitado um valor negativo
                    System.out.println("Erro: somente números positivos, tente novamente.");
                }
            } catch (
                    InputMismatchException e) { // Tratando exceções para o caso de o usuário digitar alguma letra ao invés de um número
                System.out.println("Digite apenas números!");
                scanner.next(); // Limpando o scanner
            }
        } while (valor <= 0);
        return valor;
    }

    public double informarTaxaJuros() { // Pedindo ao usuário que informe o valor da taxa de juros
        double taxa = 0;
        do {
            try {
                System.out.print("2) Digite a taxa do financiamento (em decimal): ");
                taxa = scanner.nextDouble();
                if (taxa <= 0 || taxa > 1) { // Evitando que a taxa exceda os limites estabelecidos
                    System.out.println("Erro: a taxa deve ser entre 0 e 1.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais e use vírgula (,) como separador decimal.");
                scanner.next();
            }
        } while (taxa <= 0 || taxa > 1);
        return taxa;
    }

    public int informarPrazoAnos() {   // Pedindo ao usuário que informe o prazo do financiamento
        int prazo = 0;
        do {
            try {
                System.out.print("3) Digite o prazo do financiamento (em anos): ");
                prazo = scanner.nextInt();
                if (prazo <= 0 || prazo > 35) { // Evitando que o prazo exceda os limites estabelecidos
                    System.out.println("Erro: o prazo deve ser entre 1 e 35 anos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                scanner.next();
            }
        } while (prazo <= 0 || prazo > 35);
        return prazo;
    }

    public double informarAreaDaCasa() {
        double areaDaCasa = 0;
        do {
            try {
                System.out.print("4) Digite a área da construção da casa (m²): ");
                areaDaCasa = scanner.nextDouble();
                if (areaDaCasa <= 30){
                    System.out.println("Erro: a área informada não cumpre com os requisitos mínimos dos nossos financiamentos");
                }  else if (areaDaCasa > 3000){
                    System.out.println("Erro: a área informada excede os limites dos nossos financiamentos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais!");
                scanner.next();
            }
        } while (areaDaCasa <= 30|| areaDaCasa > 3000);
        return areaDaCasa;
    }

    public double informarAreaDoTerreno() {
        double areaDoTerreno = 0;
        do {
            try {
                System.out.print("5) Digite a área do terreno (m²): ");
                areaDoTerreno = scanner.nextDouble();
                if (areaDoTerreno <= 100) {
                    System.out.println("Erro: a área informada não cumpre com os requisitos mínimos dos nossos financiamentos");
                }  else if (areaDoTerreno > 50000){
                    System.out.println("Erro: a área informada excede os limites dos nossos financiamentos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais!");
                scanner.next();
            }
        } while (areaDoTerreno <= 100 || areaDoTerreno > 50000);
            return areaDoTerreno;
    }

    public void fecharScanner() {
        scanner.close();
    }
}