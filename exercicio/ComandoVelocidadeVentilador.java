package exercicio;

// Comando concreto: muda a velocidade do ventilador.
// Este e o comando mais interessante: para conseguir desfazer, ele precisa
// LEMBRAR qual era a velocidade antes de executar.

public class ComandoVelocidadeVentilador implements Comando {
    // TODO: campo ventilador
    // TODO: campo novaVelocidade
    // TODO: campo velocidadeAnterior

    public ComandoVelocidadeVentilador(Ventilador ventilador, int novaVelocidade) {
        // TODO
    }

    @Override
    public void executar() {
        // TODO: guarde a velocidade atual em velocidadeAnterior
        // TODO: depois mude o ventilador para novaVelocidade
    }

    @Override
    public void desfazer() {
        // TODO: volte o ventilador para velocidadeAnterior
    }
}
