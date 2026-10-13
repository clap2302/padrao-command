package exemplo;

// Observador concreto: o visor da impressora, mostra cada evento na hora.

public class PainelImpressora implements Observador {

    @Override
    public void atualizar(String evento) {
        System.out.println("[Painel] " + evento);
    }
}
