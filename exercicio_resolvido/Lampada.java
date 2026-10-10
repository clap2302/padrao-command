package exercicio_resolvido;

// Receiver: uma lampada de um comodo da casa.

public class Lampada {
    private final String comodo;
    private boolean ligada;

    public Lampada(String comodo) {
        this.comodo = comodo;
        this.ligada = false;
    }

    public void ligar() {
        ligada = true;
        System.out.println("Lampada da " + comodo + " ligada.");
    }

    public void desligar() {
        ligada = false;
        System.out.println("Lampada da " + comodo + " desligada.");
    }

    @Override
    public String toString() {
        return "Lampada da " + comodo + ": " + (ligada ? "LIGADA" : "DESLIGADA");
    }
}
