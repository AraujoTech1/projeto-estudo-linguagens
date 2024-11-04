using System;
using System.Collections.Generic;

class Memoria {
    static void Main() {
        List<string> tabuleiro = new List<string> { "A", "A", "B", "B", "C", "C", "D", "D" };
        tabuleiro.Shuffle();

        string[] estado = { "_", "_", "_", "_", "_", "_", "_", "_" };
        int acertos = 0;

        while (acertos < tabuleiro.Count / 2) {
            MostrarTabuleiro(estado);
            Console.Write("Escolha a primeira posição (0 a 7): ");
            int pos1 = int.Parse(Console.ReadLine());
            Console.Write("Escolha a segunda posição (0 a 7): ");
            int pos2 = int.Parse(Console.ReadLine());

            if (pos1 != pos2 && estado[pos1] == "_" && estado[pos2] == "_") {
                estado[pos1] = tabuleiro[pos1];
                estado[pos2] = tabuleiro[pos2];
                MostrarTabuleiro(estado);

                if (tabuleiro[pos1] == tabuleiro[pos2]) {
                    Console.WriteLine("Par encontrado!");
                    acertos++;
                } else {
                    estado[pos1] = "_";
                    estado[pos2] = "_";
                    Console.WriteLine("Não combinam!");
                }
            } else {
                Console.WriteLine("Escolha posições válidas e diferentes.");
            }
        }
        Console.WriteLine("Parabéns! Jogo concluído.");
    }

    static void MostrarTabuleiro(string[] estado) {
        foreach (string s in estado) {
            Console.Write(s + " ");
        }
        Console.WriteLine();
    }
}
