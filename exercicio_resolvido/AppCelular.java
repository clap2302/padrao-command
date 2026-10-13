package exercicio_resolvido;

// Observador concreto: aplicativo no celular que mostra cada evento da casa.

public class AppCelular implements Observador {

    @Override
    public void atualizar(String evento) {
        System.out.println("App: " + evento);
    }
}
