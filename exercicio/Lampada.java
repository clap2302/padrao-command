package exercicio;

// Receiver (Command) e Subject (Observer): uma lampada de um comodo da casa.
// Ela NAO imprime nada na tela: so avisa os observadores.

public class Lampada extends DispositivoObservavel {
    // TODO: campo comodo (String)
    // TODO: campo ligada (boolean)

    public Lampada(String comodo) {
        // TODO
    }

    public void ligar() {
        // TODO: marque como ligada
        // TODO: notifique os observadores com "Lampada da <comodo> ligada."
    }

    public void desligar() {
        // TODO: marque como desligada
        // TODO: notifique os observadores com "Lampada da <comodo> desligada."
    }

    @Override
    public String toString() {
        // TODO: retorne "Lampada da <comodo>: LIGADA" ou "Lampada da <comodo>: DESLIGADA"
        return "";
    }
}
