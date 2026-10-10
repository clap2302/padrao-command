package exercicio_resolvido;

// Comando concreto: liga a lampada.
// O "contrario" de ligar e desligar, entao desfazer() desliga.

public class ComandoLigarLampada implements Comando {
    private final Lampada lampada;

    public ComandoLigarLampada(Lampada lampada) {
        this.lampada = lampada;
    }

    @Override
    public void executar() {
        lampada.ligar();
    }

    @Override
    public void desfazer() {
        lampada.desligar();
    }
}
