import jogoDaVida.JogoDaVida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
public class JogoDaVidaTest {

    // Testa se é possível definir o estado de uma célula corretamente para "viva"
    @Test
    public void testDefinirEstadoCelula() {
        JogoDaVida jogo = new JogoDaVida();
        // Define a célula (0, 0) como viva
        jogo.definirEstadoCelula(0, 0, true);
        // Verifica se a célula (0, 0) está viva após ser definida
        assertTrue(jogo.obterEstadoCelula(0, 0));
    }

    // Testa o método de contagem de vizinhos vivos ao redor de uma célula
    @Test
    public void testContarVizinhosVivos() {
        JogoDaVida jogo = new JogoDaVida();
        // Define células ao redor da célula (2, 2)
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        // Conta os vizinhos vivos da célula (2, 2)
        assertEquals(3, jogo.contarVizinhosVivos(2, 2));  // A célula (2, 2) deve ter 3 vizinhos vivos
    }

    // Testa se uma célula morre por solidão quando tem menos de 2 vizinhos vivos
    @Test
    public void testCélulaMorrePorSolidão() {
        JogoDaVida jogo = new JogoDaVida();
        // Define a célula (2, 2) como viva
        jogo.definirEstadoCelula(2, 2, true);
        jogo.definirEstadoCelula(1, 1, true); // Apenas uma célula viva (no caso, (1,1))
        // Avança para a próxima geração
        jogo.proximaGeracao();
        // A célula (2, 2) deve morrer por solidão
        assertFalse(jogo.obterEstadoCelula(2, 2));  // Espera-se que (2, 2) esteja morta
    }

    // Testa se uma célula revive quando tem exatamente 3 vizinhos vivos
    @Test
    public void testCélulaReviveCom3Vizinhos() {
        JogoDaVida jogo = new JogoDaVida();
        // Define três células vivas ao redor da célula (2, 2)
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        // Avança para a próxima geração
        jogo.proximaGeracao();
        // A célula (2, 2) deve reviver com 3 vizinhos vivos
        assertTrue(jogo.obterEstadoCelula(2, 2));  // Espera-se que (2, 2) esteja viva
    }

    // Testa as condições de limite do tabuleiro e a transição correta de células
    @Test
    public void testLimitesTabuleiro() {
        JogoDaVida jogo = new JogoDaVida();

        // Configura o tabuleiro com algumas células vivas ao redor de (2, 2)
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);

        // Verifica o estado inicial da célula (2, 2) antes de rodar a próxima geração
        assertFalse(jogo.obterEstadoCelula(2, 2));  // Antes da geração, (2, 2) deve estar morta

        // Avança para a próxima geração
        jogo.proximaGeracao();

        // Após a próxima geração, a célula (2, 2) deve se tornar viva
        assertTrue(jogo.obterEstadoCelula(2, 2));  // Após a geração, espera-se que (2, 2) esteja viva
    }

    // Testa a evolução geral do tabuleiro após aplicar uma geração
    @Test
    public void testEvolucaoTabuleiro() {
        JogoDaVida jogo = new JogoDaVida();
        // Define as células (1, 1), (1, 2), e (2, 1) como vivas
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        // Avança para a próxima geração
        jogo.proximaGeracao();
        // Verifica a evolução da célula (2, 0) (deve ficar morta) e (2, 2) (deve ficar viva)
        assertFalse(jogo.obterEstadoCelula(2, 0));  // (2, 0) deve ficar morta
        assertTrue(jogo.obterEstadoCelula(2, 2));  // (2, 2) deve ficar viva
    }
}
*/

import jogoDaVida.JogoDaVida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JogoDaVidaTest {

    // Caso de Teste 1: Definir Estado de Célula Válido
    @Test
    public void testDefinirEstadoCelula() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(0, 0, true);
        assertTrue(jogo.obterEstadoCelula(0, 0));
    }

    @Test
    public void testDefinirEstadoCelulaInvalidaLinha() {
        JogoDaVida jogo = new JogoDaVida();
        // Garantindo que as células fora dos limites não afetam o tabuleiro
        jogo.definirEstadoCelula(-1, 0, true); // Linha fora do limite
        jogo.definirEstadoCelula(0, 0, true);  // Definindo uma célula válida
        assertFalse(jogo.obterEstadoCelula(-1, 0)); // Nenhuma alteração deve ocorrer
        assertTrue(jogo.obterEstadoCelula(0, 0));  // A célula válida ainda deve estar "true"
    }

    // Caso de Teste 3: Contar Vizinhos Vivos - Válido com 3 vizinhos vivos
    @Test
    public void testContarVizinhosVivos() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        assertEquals(3, jogo.contarVizinhosVivos(2, 2));
    }

    // Caso de Teste 4: Contar Vizinhos Vivos - Válido com 0 vizinhos vivos
    @Test
    public void testContarVizinhosVivosZero() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(5, 5, true);
        assertEquals(0, jogo.contarVizinhosVivos(5, 5)); // Nenhum vizinho
    }

    // Caso de Teste 5: Célula Morre por Solidão - Menos de 2 Vizinhos
    @Test
    public void testCelulaMorrePorSolidao() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(2, 2, true); // Célula isolada
        jogo.definirEstadoCelula(1, 1, true); // Apenas 1 vizinho
        jogo.proximaGeracao();
        assertFalse(jogo.obterEstadoCelula(2, 2)); // A célula deve morrer
    }

    // Caso de Teste 6: Célula Revive com 3 Vizinhos Vivos
    @Test
    public void testCelulaReviveCom3Vizinhos() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        jogo.proximaGeracao();
        assertTrue(jogo.obterEstadoCelula(2, 2)); // A célula deve reviver
    }

    // Caso de Teste 7: Limite de Coordenadas - Testar com uma célula no topo-esquerdo
    @Test
    public void testLimiteCélulaTopoEsquerdo() {
        JogoDaVida jogo = new JogoDaVida();
        // Supondo que o tabuleiro tenha tamanho fixo, como 10x10
        jogo.definirEstadoCelula(0, 0, true); // Definindo no topo esquerdo
        jogo.proximaGeracao();
        assertFalse(jogo.obterEstadoCelula(0, 0)); // Verificando o estado da célula após a próxima geração
    }

    // Caso de Teste 8: Limite de Coordenadas - Testar com uma célula no fundo-direita
    @Test
    public void testLimiteCélulaFundoDireita() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(5, 5, true); // Definindo no fundo direito (assumindo um tamanho 6x6)
        jogo.proximaGeracao();
        assertFalse(jogo.obterEstadoCelula(5, 5)); // Estado permanece correto após evolução
    }


    // Caso de Teste 9: Célula Não Morre por Superpopulação
    @Test
    public void testCelulaNaoMorrePorSuperpopulacao() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(2, 2, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(3, 2, true);
        jogo.proximaGeracao();
        assertTrue(jogo.obterEstadoCelula(2, 2)); // A célula deve sobreviver
    }

    // Caso de Teste 10: Valor Inválido para Estado da Célula
    @Test
    public void testValorInvalidoEstadoCelula() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(2, 2, true); // Estado válido
        jogo.definirEstadoCelula(5, 5, false); // Valor inválido, fora das opções (0 ou 1)
        assertFalse(jogo.obterEstadoCelula(5, 5)); // Não deve ser alterado
    }

    // Caso de Teste 11: Testar Geração em Tabuleiro Preenchido (Múltiplos Vizinhos)
    @Test
    public void testEvolucaoTabuleiro() {
        JogoDaVida jogo = new JogoDaVida();
        jogo.definirEstadoCelula(1, 1, true);
        jogo.definirEstadoCelula(1, 2, true);
        jogo.definirEstadoCelula(2, 1, true);
        jogo.proximaGeracao();
        assertFalse(jogo.obterEstadoCelula(2, 0)); // Deveria morrer
        assertTrue(jogo.obterEstadoCelula(2, 2)); // Deve permanecer viva
    }

}
