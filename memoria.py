import random

# Tabuleiro do jogo com pares de letras
tabuleiro = ["A", "A", "B", "B", "C", "C", "D", "D"]
random.shuffle(tabuleiro)
estado = ["_"] * len(tabuleiro)

# Função para exibir o tabuleiro
def mostrar_tabuleiro():
    print(" ".join(estado))

# Jogo da memória
def jogo_memoria():
    acertos = 0
    while acertos < len(tabuleiro) // 2:
        mostrar_tabuleiro()
        pos1 = int(input("Escolha a primeira posição (0 a 7): "))
        pos2 = int(input("Escolha a segunda posição (0 a 7): "))
        if pos1 != pos2 and estado[pos1] == "_" and estado[pos2] == "_":
            estado[pos1], estado[pos2] = tabuleiro[pos1], tabuleiro[pos2]
            mostrar_tabuleiro()
            if tabuleiro[pos1] == tabuleiro[pos2]:
                print("Par encontrado!")
                acertos += 1
            else:
                estado[pos1], estado[pos2] = "_", "_"
                print("Não combinam!")
        else:
            print("Escolha posições válidas e diferentes.")

jogo_memoria()
