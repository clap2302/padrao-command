package exemplo;

// Receiver: contem a logica de negocio real.
// No caso, uma impressora fisica que imprime documentos.

public class Impressora {
    private final String nome;
    private boolean ligada;
    private int numeroImpressoes;

    public Impressora(String nome) {
        this.nome = nome;
        this.ligada = false;
        this.numeroImpressoes = 0;
    }

    public void ligar() {
        ligada = true;
        System.out.println("Impressora " + nome + " ligada.");
    }

    public void desligar() {
        ligada = false;
        System.out.println("Impressora " + nome + " desligada.");
    }

    public void imprimir(String documento) {
        if (!ligada) {
            ligar();
        }
        numeroImpressoes++;
        System.out.println("Imprimindo: " + documento);
    }

    @Override
    public String toString() {
        return "Impressora " + nome + ": " + (ligada ? "LIGADA" : "DESLIGADA")
                + ", impressoes: " + numeroImpressoes;
    }
}
