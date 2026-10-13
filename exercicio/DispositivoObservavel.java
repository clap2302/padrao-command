package exercicio;

import java.util.ArrayList;
import java.util.List;

// Subject (Observer): base para todo dispositivo que pode ser observado.
// Lampada e Ventilador herdam daqui, entao a logica de gerenciar
// observadores fica escrita uma vez so.

public abstract class DispositivoObservavel {
    // TODO: campo observadores (List<Observador>), ja inicializado

    public void adicionarObservador(Observador observador) {
        // TODO
    }

    public void removerObservador(Observador observador) {
        // TODO
    }

    protected void notificarObservadores(String evento) {
        // TODO: chame atualizar(evento) em cada observador da lista
    }
}
