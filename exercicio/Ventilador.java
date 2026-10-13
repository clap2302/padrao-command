package exercicio;

// Receiver (Command) e Subject (Observer): um ventilador com velocidades
// de 0 (desligado) a 3. Ele NAO imprime nada na tela: so avisa os observadores.

public class Ventilador extends DispositivoObservavel {
    // TODO: campo comodo (String)
    // TODO: campo velocidade (int), comeca em 0

    public Ventilador(String comodo) {
        // TODO
    }

    public void setVelocidade(int velocidade) {
        // TODO: altere a velocidade
        // TODO: notifique os observadores com "Ventilador da <comodo> na velocidade <v>."
    }

    public int getVelocidade() {
        // TODO
        return 0;
    }

    @Override
    public String toString() {
        // TODO: retorne "Ventilador da <comodo>: velocidade <v>"
        return "";
    }
}
