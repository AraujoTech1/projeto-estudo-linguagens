import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Memoria {
    public static void main(String[] args) {
        ArrayList<String> tabuleiro = new ArrayList<>();
        Collections.addAll(tabuleiro, "A", "A", "B", "B", "C", "C", "D", "D");
        Collections.shuffle(tabuleiro);

        String[] estado = {"_", "_", "_", "_", "_", "_", "_", "_"};
        Scanner scanner = new Scanner(System.in);
        int acertos = 0;

        while (acertos < tabuleiro.size() / 2) {
            mostrarTabuleiro(estado);
            System.out.print("Escolha a primeira posição (0 a 7): ");
            int pos1 = scanner.nextInt();
            System.out.print("Escolha a segunda posição (0 a 7): ");
            int pos2 = scanner.nextInt();

            if (pos1 != pos2 && estado[pos1].equals("_") && estado[pos2].equals("_")) {
                estado[pos1] = tabuleiro.get(pos1);
                estado[pos2] = tabuleiro.get(pos2);
                mostrarTabuleiro(estado);

                if (tabuleiro.get(pos1).equals(tabuleiro.get(pos2))) {
                    System.out.println("Par encontrado!");
                    acertos++;
                } else {
                    estado[pos1] = "_";
                    estado[pos2] = "_";
                    System.out.println("Não combinam!");
                }
            } else {
                System.out.println("Escolha posições válidas e diferentes.");
            }
        }
        scanner.close();
        System.out.println("Parabéns! Jogo concluído.");
    }

    public static void mostrarTabuleiro(String[] estado) {
        for (String s : estado) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
