package exemplo;

// Comando concreto: desliga a impressora.

public class ComandoDesligarImpressora implements Command {
    private final Impressora impressora;

    public ComandoDesligarImpressora(Impressora impressora) {
        this.impressora = impressora;
    }

    @Override
    public void executar() {
        impressora.desligar();
    }
}
