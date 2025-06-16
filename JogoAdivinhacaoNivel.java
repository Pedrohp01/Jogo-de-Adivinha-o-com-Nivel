import java.util.*;
import java.io.*;

public class JogoAdivinhacaoNivel {

    private static final String RANKING_FILE = "ranking.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("🎯 Bem-vindo ao Jogo de Adivinhação com Dificuldade!");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        int maxNumero = escolherDificuldade(scanner);
        int numeroSecreto = random.nextInt(maxNumero) + 1;
        int palpite;
        int tentativas = 0;

        System.out.println("\n🔢 Tente adivinhar o número entre 1 e " + maxNumero);

        while (true) {
            System.out.print("Digite seu palpite: ");
            palpite = scanner.nextInt();
            tentativas++;

            if (palpite == numeroSecreto) {
                System.out.println("✅ Parabéns, " + nome + "! Você acertou em " + tentativas + " tentativas.");
                salvarPontuacao(nome, tentativas, maxNumero);
                break;
            } else if (palpite < numeroSecreto) {
                System.out.println("🔼 O número secreto é maior!");
            } else {
                System.out.println("🔽 O número secreto é menor!");
            }
        }

        System.out.println("\n📊 Ranking de melhores pontuações:");
        exibirRanking();

        scanner.close();
    }

    private static int escolherDificuldade(Scanner scanner) {
        System.out.println("\nEscolha a dificuldade:");
        System.out.println("1 - Fácil (1 a 50)");
        System.out.println("2 - Médio (1 a 100)");
        System.out.println("3 - Difícil (1 a 500)");

        int escolha;
        while (true) {
            System.out.print("Digite 1, 2 ou 3: ");
            escolha = scanner.nextInt();
            if (escolha == 1) return 50;
            if (escolha == 2) return 100;
            if (escolha == 3) return 500;
            System.out.println("Opção inválida.");
        }
    }

    private static void salvarPontuacao(String nome, int tentativas, int maxNumero) {
        String dificuldade = switch (maxNumero) {
            case 50 -> "Fácil";
            case 100 -> "Médio";
            case 500 -> "Difícil";
            default -> "Desconhecida";
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RANKING_FILE, true))) {
            writer.write(nome + " - " + tentativas + " tentativas - " + dificuldade);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar pontuação: " + e.getMessage());
        }
    }

    private static void exibirRanking() {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(RANKING_FILE))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhuma pontuação salva ainda.");
            return;
        } catch (IOException e) {
            System.out.println("Erro ao ler o ranking: " + e.getMessage());
            return;
        }

        linhas.sort(Comparator.comparingInt(JogoAdivinhacaoNivel::extrairTentativas));

        for (String linha : linhas) {
            System.out.println(linha);
        }
    }

    private static int extrairTentativas(String linha) {
        try {
            String[] partes = linha.split(" - ");
            return Integer.parseInt(partes[1].replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return Integer.MAX_VALUE;
        }
    }
}
