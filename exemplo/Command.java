package exemplo;

// Command: contrato comum para todos os comandos do sistema de impressao.
// O padrao Command transforma um pedido em um objeto independente.

public interface Command {
    void executar();
}
