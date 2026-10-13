package exemplo;

// Observer: quem quer ser avisado quando algo acontece na impressora.

public interface Observador {
    void atualizar(String evento);
}
