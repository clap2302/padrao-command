package exercicio_resolvido;

// Command: contrato comum para todos os comandos do controle remoto.
// Diferente do exemplo, aqui todo comando tambem precisa saber se DESFAZER.

public interface Comando {
    void executar();

    void desfazer();
}
