package exemplo;

import java.util.ArrayList;
import java.util.List;

// Invoker: e quem aciona os pedidos. NAO SABE o que cada comando faz.
// Gerencia uma fila de impressao e pode enfileirar comandos.

public class FilaImpressao {
    private final List<Command> fila;

    public FilaImpressao() {
        this.fila = new ArrayList<>();
    }

    public void adicionar(Command comando) {
        fila.add(comando);
    }

    public void executar() {
        for (Command comando : fila) {
            comando.executar();
        }
        fila.clear();
    }

    // ============================================================
    // METODO MAIN (Client): teste dos padroes Command + Observer
    // ============================================================
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE FILA DE IMPRESSAO ===\n");

        // PASSO 1: Criar o Receiver/Subject (impressora fisica)
        Impressora impressora = new Impressora("Sala");

        // PASSO 2: Registrar os observadores na impressora
        PainelImpressora painel = new PainelImpressora();
        LogImpressao log = new LogImpressao();
        impressora.adicionarObservador(painel);
        impressora.adicionarObservador(log);

        System.out.println("Estado inicial: " + impressora);

        // PASSO 3: Criar os comandos concretos
        Command ligar = new ComandoLigarImpressora(impressora);
        Command imprimir1 = new ComandoImprimir(impressora, "Relatorio.pdf");
        Command imprimir2 = new ComandoImprimir(impressora, "Contrato.pdf");
        Command desligar = new ComandoDesligarImpressora(impressora);

        // PASSO 4: Criar o Invoker (fila) e enfileirar os comandos
        FilaImpressao fila = new FilaImpressao();
        fila.adicionar(ligar);
        fila.adicionar(imprimir1);
        fila.adicionar(imprimir2);
        fila.adicionar(desligar);

        // PASSO 5: Executar toda a fila
        System.out.println("\n--- Executando fila ---");
        fila.executar();

        // PASSO 6: Consultar o que o log registrou
        System.out.println("\n--- Log de eventos ---");
        log.exibir();

        System.out.println("\nEstado final: " + impressora);
        System.out.println("\n=== FIM ===");
    }
}
