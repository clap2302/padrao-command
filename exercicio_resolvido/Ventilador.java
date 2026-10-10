package exercicio_resolvido;

// Receiver: um ventilador com velocidades de 0 (desligado) a 3.

public class Ventilador {
    private final String comodo;
    private int velocidade;

    public Ventilador(String comodo) {
        this.comodo = comodo;
        this.velocidade = 0;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
        System.out.println("Ventilador da " + comodo + " na velocidade " + velocidade + ".");
    }

    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Ventilador da " + comodo + ": velocidade " + velocidade;
    }
}
