package exercicio;

// Comando concreto: desliga a lampada.

public class ComandoDesligarLampada implements Comando {
    // TODO: campo lampada

    public ComandoDesligarLampada(Lampada lampada) {
        // TODO
    }

    @Override
    public void executar() {
        // TODO: desliga a lampada
    }

    @Override
    public void desfazer() {
        // TODO: liga a lampada
    }
}
