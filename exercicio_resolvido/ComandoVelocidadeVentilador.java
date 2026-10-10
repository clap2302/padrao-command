package exercicio_resolvido;

// Comando concreto: muda a velocidade do ventilador.
// Este e o comando mais interessante: para conseguir desfazer, ele precisa
// LEMBRAR qual era a velocidade antes de executar.

public class ComandoVelocidadeVentilador implements Comando {
    private final Ventilador ventilador;
    private final int novaVelocidade;
    private int velocidadeAnterior;

    public ComandoVelocidadeVentilador(Ventilador ventilador, int novaVelocidade) {
        this.ventilador = ventilador;
        this.novaVelocidade = novaVelocidade;
    }

    @Override
    public void executar() {
        // Guarda o estado ANTES de mudar, senao nao ha como voltar
        velocidadeAnterior = ventilador.getVelocidade();
        ventilador.setVelocidade(novaVelocidade);
    }

    @Override
    public void desfazer() {
        ventilador.setVelocidade(velocidadeAnterior);
    }
}
