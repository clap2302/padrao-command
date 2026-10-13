package exercicio_resolvido;

// Observer: quem quer ser avisado quando um dispositivo da casa muda de estado.

public interface Observador {
    void atualizar(String evento);
}
