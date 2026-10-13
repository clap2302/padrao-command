package exemplo;

import java.util.ArrayList;
import java.util.List;

// Receiver (Command): contem a logica de negocio real.
// Subject (Observer): avisa os observadores sempre que algo acontece.
// Repare que a impressora nao imprime nada na tela: quem decide como
// mostrar (ou guardar) os eventos sao os observadores.

public class Impressora {
    private final String nome;
    private boolean ligada;
    private int numeroImpressoes;
    private final List<Observador> observadores;

    public Impressora(String nome) {
        this.nome = nome;
        this.ligada = false;
        this.numeroImpressoes = 0;
        this.observadores = new ArrayList<>();
    }

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    private void notificarObservadores(String evento) {
        for (Observador observador : observadores) {
            observador.atualizar(evento);
        }
    }

    public void ligar() {
        ligada = true;
        notificarObservadores("Impressora " + nome + " ligada");
    }

    public void desligar() {
        ligada = false;
        notificarObservadores("Impressora " + nome + " desligada");
    }

    public void imprimir(String documento) {
        if (!ligada) {
            ligar();
        }
        numeroImpressoes++;
        notificarObservadores("Impressao #" + numeroImpressoes + ": " + documento);
    }

    @Override
    public String toString() {
        return "Impressora " + nome + ": " + (ligada ? "LIGADA" : "DESLIGADA")
                + ", impressoes: " + numeroImpressoes;
    }
}
