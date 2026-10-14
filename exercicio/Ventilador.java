package exercicio;

// Receiver (Command) e Subject (Observer): um ventilador com velocidades
// de 0 (desligado) a 3. Ele NAO imprime nada na tela: so avisa os observadores.

public class Ventilador extends DispositivoObservavel {
    private final String comodo;
    private int velocidade;

    public Ventilador(String comodo) {
        this.comodo = comodo;
        this.velocidade = 0;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
        notificarObservadores("Ventilador da " + comodo + " na velocidade " + velocidade + ".");
    }

    public int getVelocidade() {
        return velocidade;
    }

    @Override
    public String toString() {
        return "Ventilador da " + comodo + ": velocidade " + velocidade;
    }
}
