package exercicio;

// Comando concreto: muda a velocidade do ventilador.
// Este e o comando mais interessante: para conseguir desfazer, ele precisa
// LEMBRAR qual era a velocidade antes de executar.

public class ComandoVelocidadeVentilador implements Comando {

    public ComandoVelocidadeVentilador(Ventilador ventilador, int novaVelocidade) {
        // TODO
    }

    @Override
    public void executar() {
        // TODO: muda o ventilador para nova velocidade
    }

    @Override
    public void desfazer() {
        // TODO: volte o ventilador para velocidade anterior
    }
}
