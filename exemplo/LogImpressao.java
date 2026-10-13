package exemplo;

import java.util.ArrayList;
import java.util.List;

// Observador concreto: guarda um historico dos eventos para consultar depois.

public class LogImpressao implements Observador {
    private final List<String> registros;

    public LogImpressao() {
        this.registros = new ArrayList<>();
    }

    @Override
    public void atualizar(String evento) {
        registros.add(evento);
    }

    public void exibir() {
        for (int i = 0; i < registros.size(); i++) {
            System.out.println((i + 1) + ". " + registros.get(i));
        }
    }
}
