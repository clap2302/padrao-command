package exercicio;

// Comando concreto: desliga a lampada.

public class ComandoDesligarLampada implements Comando {
    private final Lampada lampada;

    public ComandoDesligarLampada(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void executar() {
        lampada.desligar();
    }

    @Override
    public void desfazer() {
        lampada.ligar();
    }
}
