package exercicio;

// Receiver (Command) e Subject (Observer): uma lampada de um comodo da casa.
// Ela NAO imprime nada na tela: so avisa os observadores.

public class Lampada extends DispositivoObservavel {
    private final String comodo;
    private boolean ligada;

    public Lampada(String comodo) {
        this.comodo = comodo;
        this.ligada = false;
    }

    public void ligar() {
        ligada = true;
        notificarObservadores("Lampada da " + comodo + " ligada.");
    }

    public void desligar() {
        ligada = false;
        notificarObservadores("Lampada da " + comodo + " desligada.");
    }

    @Override
    public String toString() {
        return "Lampada da " + comodo + ": " + (ligada ? "LIGADA" : "DESLIGADA");
    }
}
