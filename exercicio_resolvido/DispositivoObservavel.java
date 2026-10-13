package exercicio_resolvido;

import java.util.ArrayList;
import java.util.List;

// Subject (Observer): base para todo dispositivo que pode ser observado.
// Lampada e Ventilador herdam daqui, entao a logica de gerenciar
// observadores fica escrita uma vez so.

public abstract class DispositivoObservavel {
    private final List<Observador> observadores = new ArrayList<>();

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    protected void notificarObservadores(String evento) {
        for (Observador observador : observadores) {
            observador.atualizar(evento);
        }
    }
}
