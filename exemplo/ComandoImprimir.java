package exemplo;

// Comando concreto: encapsula um pedido de impressao.
// Guarda nao so o Receiver, mas tambem o parametro (documento).

public class ComandoImprimir implements Command {
    private final Impressora impressora;
    private final String documento;

    public ComandoImprimir(Impressora impressora, String documento) {
        this.impressora = impressora;
        this.documento = documento;
    }

    @Override
    public void executar() {
        impressora.imprimir(documento);
    }
}
