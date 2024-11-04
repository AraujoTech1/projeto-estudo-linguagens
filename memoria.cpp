#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>

using namespace std;

void mostrarTabuleiro(const vector<string>& estado) {
    for (const auto& s : estado) {
        cout << s << " ";
    }
    cout << endl;
}

int main() {
    vector<string> tabuleiro = {"A", "A", "B", "B", "C", "C", "D", "D"};
    srand(time(0));
    random_shuffle(tabuleiro.begin(), tabuleiro.end());

    vector<string> estado(8, "_");
    int acertos = 0;

    while (acertos < tabuleiro.size() / 2) {
        mostrarTabuleiro(estado);
        int pos1, pos2;
        cout << "Escolha a primeira posição (0 a 7): ";
        cin >> pos1;
        cout << "Escolha a segunda posição (0 a 7): ";
        cin >> pos2;

        if (pos1 != pos2 && estado[pos1] == "_" && estado[pos2] == "_") {
            estado[pos1] = tabuleiro[pos1];
            estado[pos2] = tabuleiro[pos2];
            mostrarTabuleiro(estado);

            if (tabuleiro[pos1] == tabuleiro[pos2]) {
                cout << "Par encontrado!" << endl;
                acertos++;
            } else {
                estado[pos1] = "_";
                estado[pos2] = "_";
                cout << "Não combinam!" << endl;
            }
        } else {
            cout << "Escolha posições válidas e diferentes." << endl;
        }
    }
    cout << "Parabéns! Jogo concluído." << endl;
    return 0;
}
