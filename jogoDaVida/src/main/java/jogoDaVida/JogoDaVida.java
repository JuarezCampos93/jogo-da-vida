package jogoDaVida;

public class JogoDaVida {

    // Matriz que representa o tabuleiro, com células vivas (1) ou mortas (0)
    private final int[][] tabuleiro;
    private final int tamanho = 6;  // Tamanho fixo do tabuleiro (6x6)

    // Construtor inicializa o tabuleiro com o tamanho definido
    public JogoDaVida() {
        this.tabuleiro = new int[tamanho][tamanho];  // Criando o tabuleiro vazio (todas as células iniciam como mortas)
    }

    // Define o estado de uma célula do tabuleiro (se está viva ou morta)
// Parâmetros: linha e coluna da célula, viva (true) ou morta (false)
    public void definirEstadoCelula(int linha, int coluna, boolean viva) {
        // Verifica se as coordenadas estão dentro dos limites do tabuleiro
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            // Define o estado da célula: 1 para viva e 0 para morta
            tabuleiro[linha][coluna] = viva ? 1 : 0;
        }
    }

    // Obtém o estado de uma célula (se está viva ou morta)
// Retorna true se a célula estiver viva, false caso contrário
    public boolean obterEstadoCelula(int linha, int coluna) {
        // Verifica se as coordenadas estão dentro dos limites do tabuleiro
        if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
            // Retorna verdadeiro se a célula está viva
            return tabuleiro[linha][coluna] == 1;
        }
        // Caso as coordenadas sejam inválidas, retorna false (morta)
        return false;
    }


    // Conta o número de vizinhos vivos de uma célula específica
    // Parâmetros: linha e coluna da célula
    // Retorna o número de vizinhos vivos
    public int contarVizinhosVivos(int linha, int coluna) {
        int vivos = 0;

        // Percorre os 8 vizinhos ao redor da célula
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // Ignora a própria célula

                // Calcula as coordenadas do vizinho
                int vizinhoLinha = linha + i;
                int vizinhoColuna = coluna + j;

                // Verifica se o vizinho está dentro dos limites do tabuleiro
                if (vizinhoLinha >= 0 && vizinhoLinha < tamanho && vizinhoColuna >= 0 && vizinhoColuna < tamanho) {
                    // Soma 1 caso o vizinho esteja vivo (1)
                    vivos += tabuleiro[vizinhoLinha][vizinhoColuna];
                }
            }
        }
        return vivos;  // Retorna a quantidade de vizinhos vivos
    }

    // Avança para a próxima geração do jogo, aplicando as regras do Jogo da Vida
    public void proximaGeracao() {
        int[][] novoTabuleiro = new int[tamanho][tamanho];  // Cria um novo tabuleiro para armazenar o estado da próxima geração

        // Percorre todas as células do tabuleiro
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                // Conta os vizinhos vivos para a célula atual
                int vizinhosVivos = contarVizinhosVivos(i, j);

                // Verifica se a célula está viva
                if (tabuleiro[i][j] == 1) {
                    // Se a célula estiver viva e tiver menos que 2 ou mais que 3 vizinhos, ela morre (por solidão ou superpopulação)
                    if (vizinhosVivos < 2 || vizinhosVivos > 3) {
                        novoTabuleiro[i][j] = 0;  // Célula morre
                    } else {
                        novoTabuleiro[i][j] = 1;  // Célula continua viva
                    }
                } else {
                    // Se a célula está morta e tem exatamente 3 vizinhos vivos, ela revive
                    if (vizinhosVivos == 3) {
                        novoTabuleiro[i][j] = 1;  // Célula revive
                    }
                }
            }
        }

        // Atualiza o tabuleiro com o novo estado
        for (int i = 0; i < tamanho; i++) {
            System.arraycopy(novoTabuleiro[i], 0, tabuleiro[i], 0, tamanho);  // Copia os valores da nova geração para o tabuleiro atual
        }
    }

    // Exibe o estado atual do tabuleiro no console
    public void mostrarTabuleiro() {
        // Percorre o tabuleiro e exibe o valor de cada célula (1 ou 0)
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(tabuleiro[i][j] + " ");  // Exibe o valor da célula
            }
            System.out.println();  // Quebra linha ao final de cada linha do tabuleiro
        }
        System.out.println();  // Quebra linha após exibir o tabuleiro
    }
}
