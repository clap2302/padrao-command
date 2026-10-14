package exercicio;

// Observador concreto: conta quantos eventos aconteceram na casa.

public class ContadorEventos implements Observador {
    private int total;

    @Override
    public void atualizar(String evento) {
        total++;
    }

    public int getTotal() {
        return total;
    }
}
