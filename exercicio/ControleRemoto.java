package exercicio;

import java.util.ArrayDeque;
import java.util.Deque;

// Invoker: um controle remoto com N botoes. Cada botao guarda um Comando.
// O controle NAO SABE o que cada botao faz, so chama executar()/desfazer().
// Ele tambem mantem um historico para o botao "desfazer".

public class ControleRemoto {
    // TODO: campo botoes (Comando[])
    // TODO: campo historico (Deque<Comando>), use como pilha

    public ControleRemoto(int quantidadeBotoes) {
        // TODO: crie o array de botoes e a pilha de historico
    }

    public void configurarBotao(int botao, Comando comando) {
        // TODO: associe o comando ao botao
    }

    public void pressionar(int botao) {
        // TODO: se o botao nao tiver comando, exiba "Botao <n> sem comando." e retorne
        // TODO: execute o comando e empilhe no historico (historico.push)
    }

    public void desfazer() {
        // TODO: se o historico estiver vazio, exiba "Nada para desfazer." e retorne
        // TODO: exiba "[desfazer] " (com System.out.print, sem quebra de linha)
        // TODO: desempilhe o ultimo comando (historico.pop) e chame desfazer()
    }

    // ============================================================
    // METODO MAIN (Client): teste do exercicio
    // Nao precisa alterar. Compare a saida com a do README.
    // ============================================================
    public static void main(String[] args) {
        System.out.println("=== CONTROLE REMOTO DA CASA ===\n");

        // PASSO 1: Receivers
        Lampada lampada = new Lampada("Sala");
        Ventilador ventilador = new Ventilador("Sala");

        // PASSO 2: Invoker + configuracao dos botoes com comandos concretos
        ControleRemoto controle = new ControleRemoto(5);
        controle.configurarBotao(0, new ComandoLigarLampada(lampada));
        controle.configurarBotao(1, new ComandoDesligarLampada(lampada));
        controle.configurarBotao(2, new ComandoVelocidadeVentilador(ventilador, 1));
        controle.configurarBotao(3, new ComandoVelocidadeVentilador(ventilador, 3));
        // botao 4 fica sem comando de proposito

        // PASSO 3: Usar o controle
        System.out.println("--- Pressionando botoes ---");
        controle.pressionar(0);
        controle.pressionar(2);
        controle.pressionar(3);
        controle.pressionar(4);

        System.out.println("\nEstado: " + lampada + " | " + ventilador);

        // PASSO 4: Desfazer tudo (um a mais do que o necessario)
        System.out.println("\n--- Desfazendo ---");
        controle.desfazer();
        controle.desfazer();
        controle.desfazer();
        controle.desfazer();

        System.out.println("\nEstado final: " + lampada + " | " + ventilador);
        System.out.println("\n=== FIM ===");
    }
}
