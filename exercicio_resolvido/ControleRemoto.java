package exercicio_resolvido;

import java.util.ArrayDeque;
import java.util.Deque;

// Invoker (Command): um controle remoto com N botoes. Cada botao guarda um Comando.
// O controle NAO SABE o que cada botao faz, so chama executar()/desfazer().
// Ele tambem mantem um historico para o botao "desfazer".

public class ControleRemoto {
    private final Comando[] botoes;
    private final Deque<Comando> historico;

    public ControleRemoto(int quantidadeBotoes) {
        this.botoes = new Comando[quantidadeBotoes];
        this.historico = new ArrayDeque<>();
    }

    public void configurarBotao(int botao, Comando comando) {
        botoes[botao] = comando;
    }

    public void pressionar(int botao) {
        Comando comando = botoes[botao];
        if (comando == null) {
            System.out.println("Botao " + botao + " sem comando.");
            return;
        }
        comando.executar();
        historico.push(comando);
    }

    public void desfazer() {
        if (historico.isEmpty()) {
            System.out.println("Nada para desfazer.");
            return;
        }
        System.out.print("[desfazer] ");
        // pop() devolve o ultimo comando executado: desfaz na ordem inversa
        historico.pop().desfazer();
    }

    // ============================================================
    // METODO MAIN (Client): teste do exercicio (Command + Observer)
    // ============================================================
    public static void main(String[] args) {
        System.out.println("=== CONTROLE REMOTO DA CASA ===\n");

        // PASSO 1: Receivers/Subjects
        Lampada lampada = new Lampada("Sala");
        Ventilador ventilador = new Ventilador("Sala");

        // PASSO 2: Observadores inscritos nos dois dispositivos
        AppCelular app = new AppCelular();
        ContadorEventos contador = new ContadorEventos();
        lampada.adicionarObservador(app);
        lampada.adicionarObservador(contador);
        ventilador.adicionarObservador(app);
        ventilador.adicionarObservador(contador);

        // PASSO 3: Invoker + configuracao dos botoes com comandos concretos
        ControleRemoto controle = new ControleRemoto(5);
        controle.configurarBotao(0, new ComandoLigarLampada(lampada));
        controle.configurarBotao(1, new ComandoDesligarLampada(lampada));
        controle.configurarBotao(2, new ComandoVelocidadeVentilador(ventilador, 1));
        controle.configurarBotao(3, new ComandoVelocidadeVentilador(ventilador, 3));
        // botao 4 fica sem comando de proposito

        // PASSO 4: Usar o controle
        System.out.println("--- Pressionando botoes ---");
        controle.pressionar(0);
        controle.pressionar(2);
        controle.pressionar(3);
        controle.pressionar(4);

        System.out.println("\nEstado: " + lampada + " | " + ventilador);

        // PASSO 5: Desfazer tudo (um a mais do que o necessario)
        System.out.println("\n--- Desfazendo ---");
        controle.desfazer();
        controle.desfazer();
        controle.desfazer();
        controle.desfazer();

        // PASSO 6: O app deixa de observar a lampada.
        // O evento acontece, o contador conta, mas o app nao mostra nada.
        System.out.println("\n--- App desconectado da lampada ---");
        lampada.removerObservador(app);
        controle.pressionar(0);

        System.out.println("\nEstado final: " + lampada + " | " + ventilador);
        System.out.println("Eventos contados: " + contador.getTotal());
        System.out.println("\n=== FIM ===");
    }
}
