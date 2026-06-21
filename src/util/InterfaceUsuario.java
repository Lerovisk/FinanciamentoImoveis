package util;
import java.util.InputMismatchException; // Importando o tratamento de exceções
import java.util.Scanner; // Importando o Scanner

public class InterfaceUsuario {  // Criando a classe InterfaceUsuario
    Scanner sc = new Scanner(System.in);

    // Métodos genéricos
    public int informarTipoImovel() { // Pede ao usuário que informe o tipo de imóvel
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
    public double informarValorImovel() { // Pede ao usuário que informe o valor do imóvel
        double valor = 0;
        do {
            try {
                /* Pesquisei por conta própria como utilizar exceções em Java pois achei que seria útil neste projeto!!! */
                System.out.print("1) Digite o valor do imóvel R$");
                valor = sc.nextDouble();
                if (valor <= 0) { // Evitando que seja digitado um valor negativo
                    System.out.println("Erro: somente números positivos, tente novamente.");
                }
            } catch (
                    InputMismatchException e) { // Tratando exceções para o caso de o usuário digitar alguma letra ao invés de um número
                System.out.println("Digite apenas números!");
                sc.next();
            }
        } while (valor <= 0);
        return valor;
    }
    public double informarTaxaJuros() { // Pede ao usuário que informe o valor da taxa de juros
        double taxa = 0;
        do {
            try {
                System.out.print("2) Digite a taxa do financiamento (em decimal): ");
                taxa = sc.nextDouble();
                if (taxa <= 0 || taxa > 1) { // Evitando que a taxa exceda os limites estabelecidos
                    System.out.println("Erro: a taxa deve ser entre 0 e 1.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais e use vírgula (,) como separador decimal.");
                sc.next();
            }
        } while (taxa <= 0 || taxa > 1);
        return taxa;
    }
    public int informarPrazoAnos() {   // Pede ao usuário que informe o prazo do financiamento
        int prazo = 0;
        do {
            try {
                System.out.print("3) Digite o prazo do financiamento (em anos): ");
                prazo = sc.nextInt();
                if (prazo <= 0 || prazo > 35) { // Evitando que o prazo exceda os limites estabelecidos
                    System.out.println("Erro: o prazo deve ser entre 1 e 35 anos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                sc.next();
            }
        } while (prazo <= 0 || prazo > 35);
        return prazo;
    }

    // Metódos de casa
    public double informarAreaDaCasa() { // Pede ao usuário que informe a area da casa
        double areaDaCasa = 0;
        do {
            try {
                System.out.print("4) Digite a área da construção da casa (m²): ");
                areaDaCasa = sc.nextDouble();
                if (areaDaCasa <= 30){
                    System.out.println("Erro: a área informada não cumpre com os requisitos mínimos dos nossos financiamentos");
                }  else if (areaDaCasa > 3000){
                    System.out.println("Erro: a área informada excede os limites dos nossos financiamentos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais!");
                sc.next();
            }
        } while (areaDaCasa <= 30|| areaDaCasa > 3000);
        return areaDaCasa;
    }
    public double informarAreaDoTerreno() { // Pede ao usuário que informe a area do terreno
        double areaDoTerreno = 0;
        do {
            try {
                System.out.print("5) Digite a área do terreno (m²): ");
                areaDoTerreno = sc.nextDouble();
                if (areaDoTerreno <= 100) {
                    System.out.println("Erro: a área informada não cumpre com os requisitos mínimos dos nossos financiamentos");
                }  else if (areaDoTerreno > 50000){
                    System.out.println("Erro: a área informada excede os limites dos nossos financiamentos");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números decimais!");
                sc.next();
            }
        } while (areaDoTerreno <= 100 || areaDoTerreno > 50000);
            return areaDoTerreno;
    }

    // Métodos de terreno
    public String informarZonaDoTerreno(){ // Pede ao usuário que digite se a zona é residecial ou comercial
        String zona = "";

        do{
            System.out.print("4) Digite a zona do terreno (Residencial ou Comercial): ");
            zona = sc.next();
            /* A função .equalsIgnore está verificando se as Strings são idêntias, mas ignora o CapsLock */
            if (!zona.equalsIgnoreCase("Residencial") && !zona.equalsIgnoreCase("Comercial")) {
                System.out.println("Erro: Digite exatamente 'Residencial' ou 'Comercial'.");
            }
        } while (!zona.equalsIgnoreCase("Residencial") && !zona.equalsIgnoreCase("Comercial"));
        return zona;
    }

    // Métodos de apartamento
    public int informarVagasApartamento(){ // Pede ao usuário que digite o número de vagas a garagem
        int vagasGaragem = -1;
        do {
            try { // Tratamento de excessões
                System.out.print("4) Digite o número de vagas da garagem: ");
                vagasGaragem = sc.nextInt();
                if (vagasGaragem < 0) {
                    System.out.println("Erro: O número de vagas não pode ser negativo.");
                }
                if (vagasGaragem > 4) {
                    System.out.println("O limite máximo permitido é de 4 vagas por apartamento.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                sc.next();
            }
        } while (vagasGaragem < 0 || vagasGaragem > 4);
        return vagasGaragem;
    }
    public int informarAndarApartamento() {  // Pede ao usuário que digite o seu andar
        int andar = -1;
        do {
            try {
                System.out.print("5) Digite o andar do apartamento: ");
                andar = sc.nextInt();
                if (andar < 0) {
                    System.out.println("Erro: O andar não pode ser negativo.");
                }
                if (andar > 20) {
                    System.out.println("Erro: O andar não pode ser maior do que 20");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números inteiros!");
                sc.next();
            }
        } while (andar < 0 || andar > 20);
        return andar;
    }

    public void fecharScanner() { // Fecha o scanner
        sc.close();
    }
}