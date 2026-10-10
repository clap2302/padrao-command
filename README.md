# Padrão Command

O **Command** é um padrão de projeto comportamental (GoF). Ele **transforma um pedido em um objeto**.
Assim, quem pede a ação fica desacoplado de quem a realiza. Com isso é possível enfileirar,
agendar, registrar e **desfazer** operações.

## Participantes

| Papel | Responsabilidade |
|---|---|
| **Command** | Interface com o método de execução (`executar()`) |
| **ConcreteCommand** | Guarda o Receiver (e os parâmetros) e chama o método certo dele |
| **Receiver** | Tem a lógica de negócio de verdade |
| **Invoker** | Guarda e dispara os comandos, sem saber o que cada um faz |
| **Client** | Cria o Receiver e os comandos e os entrega ao Invoker |

## Estrutura do repositório

```
.
├── exemplo/               # Implementação completa: fila de impressão
├── exercicio/             # Para resolver: controle remoto com desfazer
└── exercicio_resolvido/   # Gabarito do exercício (tente antes de olhar!)
```

---

## Exemplo: fila de impressão

| Papel | Classe |
|---|---|
| Command | `Command` |
| ConcreteCommand | `ComandoLigarImpressora`, `ComandoImprimir`, `ComandoDesligarImpressora` |
| Receiver | `Impressora` |
| Invoker | `FilaImpressao` |
| Client | `FilaImpressao.main` |

### Como rodar

```bash
javac -d out exemplo/*.java
java -cp out exemplo.FilaImpressao
```

---

## Exercício: controle remoto da casa

Um controle remoto tem vários botões. Cada botão recebe um comando, e o controle tem um botão
**desfazer** que reverte as últimas ações, na ordem inversa.

A diferença em relação ao exemplo é que a interface `Comando` agora tem **`desfazer()`** além de
`executar()`. Cada comando precisa saber reverter o que fez.

| Papel | Classe |
|---|---|
| Command | `Comando` |
| ConcreteCommand | `ComandoLigarLampada`, `ComandoDesligarLampada`, `ComandoVelocidadeVentilador` |
| Receiver | `Lampada`, `Ventilador` |
| Invoker | `ControleRemoto` |
| Client | `ControleRemoto.main` (já está pronto, não precisa alterar) |

### O que fazer

1. Complete os Receivers `Lampada` e `Ventilador`.
2. Complete os três comandos concretos.
   - Atenção ao `ComandoVelocidadeVentilador`: para desfazer, ele precisa **guardar a velocidade anterior** no momento em que executa.
3. Complete o `ControleRemoto`: configurar botões, pressionar e desfazer usando uma **pilha** de histórico.

Todos os pontos a preencher estão marcados com `// TODO`. O código já compila desde o início.

### Como rodar

```bash
javac -d out exercicio/*.java
java -cp out exercicio.ControleRemoto
```

### Saída esperada

```
=== CONTROLE REMOTO DA CASA ===

--- Pressionando botoes ---
Lampada da Sala ligada.
Ventilador da Sala na velocidade 1.
Ventilador da Sala na velocidade 3.
Botao 4 sem comando.

Estado: Lampada da Sala: LIGADA | Ventilador da Sala: velocidade 3

--- Desfazendo ---
[desfazer] Ventilador da Sala na velocidade 1.
[desfazer] Ventilador da Sala na velocidade 0.
[desfazer] Lampada da Sala desligada.
Nada para desfazer.

Estado final: Lampada da Sala: DESLIGADA | Ventilador da Sala: velocidade 0

=== FIM ===
```

### Gabarito

A solução está em [`exercicio_resolvido/`](exercicio_resolvido/):

```bash
javac -d out exercicio_resolvido/*.java
java -cp out exercicio_resolvido.ControleRemoto
```

### Desafio extra

Crie um `MacroComando` que recebe uma lista de comandos e executa todos de uma vez
(por exemplo, "modo cinema": desliga a lâmpada e põe o ventilador na velocidade 1).
O `desfazer()` dele deve desfazer os comandos **na ordem inversa**.
