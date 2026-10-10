package exercicio;

// Comando concreto: liga a lampada.
// Pense: qual e o "contrario" de ligar?

public class ComandoLigarLampada implements Comando {
    // TODO: campo lampada

    public ComandoLigarLampada(Lampada lampada) {
        // TODO
    }

    @Override
    public void executar() {
        // TODO: liga a lampada
    }

    @Override
    public void desfazer() {
        // TODO: desliga a lampada
    }
}
