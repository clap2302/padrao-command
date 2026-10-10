package exemplo;

// Comando concreto: liga a impressora.

public class ComandoLigarImpressora implements Command {
    private final Impressora impressora;

    public ComandoLigarImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    @Override
    public void executar() {
        impressora.ligar();
    }
}
