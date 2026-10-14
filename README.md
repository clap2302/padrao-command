# Padrões Command + Observer

Este repositório mostra dois padrões de projeto comportamentais (GoF) trabalhando juntos.

## Command

O **Command** **transforma um pedido em um objeto**. Assim, quem pede a ação fica desacoplado de
quem a realiza. Com isso é possível enfileirar, agendar, registrar e **desfazer** operações.

| Papel | Responsabilidade |
|---|---|
| **Command** | Interface com o método de execução (`executar()`) |
| **ConcreteCommand** | Guarda o Receiver (e os parâmetros) e chama o método certo dele |
| **Receiver** | Tem a lógica de negócio de verdade |
| **Invoker** | Guarda e dispara os comandos, sem saber o que cada um faz |
| **Client** | Cria o Receiver e os comandos e os entrega ao Invoker |

## Observer

O **Observer** define uma relação **um-para-muitos**: quando um objeto (o *Subject*) muda de estado,
todos os objetos inscritos nele (os *Observers*) são avisados automaticamente. O Subject não sabe
o que cada observador faz com o aviso. Ele só mantém a lista e chama `atualizar()` em cada um.

| Papel | Responsabilidade |
|---|---|
| **Subject** | Mantém a lista de observadores e os notifica (`adicionar`, `remover`, `notificar`) |
| **Observer** | Interface com o método de aviso (`atualizar(evento)`) |
| **ConcreteObserver** | Decide o que fazer com o aviso (mostrar, registrar, contar...) |

## Como os dois se combinam

O **Receiver** do Command também é o **Subject** do Observer:

```
Invoker ──executar()──▶ Comando ──▶ Receiver/Subject ──atualizar()──▶ Observadores
```

O Command cuida de **disparar** as ações. O Observer cuida de **avisar** quem se interessa pelo
resultado delas. Por isso os Receivers não imprimem nada na tela: quem decide como mostrar ou
guardar cada evento são os observadores.

## Estrutura do repositório

```
.
├── exemplo/               # Implementação completa: fila de impressão
├── exercicio/             # Para resolver: controle remoto com desfazer
└── exercicio_resolvido/   # Gabarito do exercício (tente antes de olhar!)
```

---

## Exemplo: fila de impressão

| Padrão | Papel | Classe |
|---|---|---|
| Command | Command | `Command` |
| Command | ConcreteCommand | `ComandoLigarImpressora`, `ComandoImprimir`, `ComandoDesligarImpressora` |
| Command | Receiver | `Impressora` |
| Command | Invoker | `FilaImpressao` |
| Observer | Subject | `Impressora` |
| Observer | Observer | `Observador` |
| Observer | ConcreteObserver | `PainelImpressora` (mostra na hora), `LogImpressao` (guarda o histórico) |
| Ambos | Client | `FilaImpressao.main` |

### Como rodar

```bash
javac -d out exemplo/*.java
java -cp out exemplo.FilaImpressao
```

---

## Exercício: controle remoto da casa

Um controle remoto tem vários botões. Cada botão recebe um comando, e o controle tem um botão
**desfazer** que reverte as últimas ações, na ordem inversa. A interface `Comando` agora tem
**`desfazer()`** além de `executar()`: cada comando precisa saber reverter o que fez.

Os dispositivos da casa (lâmpada e ventilador) são observáveis. Um **app de celular** mostra cada
evento e um **contador** conta quantos eventos aconteceram. A lógica de gerenciar observadores fica
numa classe base, `DispositivoObservavel`, que os dois dispositivos herdam.

| Padrão | Papel | Classe |
|---|---|---|
| Command | Command | `Comando` |
| Command | ConcreteCommand | `ComandoLigarLampada`, `ComandoDesligarLampada`, `ComandoVelocidadeVentilador` |
| Command | Receiver | `Lampada`, `Ventilador` |
| Command | Invoker | `ControleRemoto` |
| Observer | Subject | `DispositivoObservavel` (herdado por `Lampada` e `Ventilador`) |
| Observer | Observer | `Observador` |
| Observer | ConcreteObserver | `AppCelular`, `ContadorEventos` |
| Ambos | Client | `ControleRemoto.main` (já está pronto, não precisa alterar) |

### O que fazer

Os dispositivos (`Lampada`, `Ventilador`), os observadores (`AppCelular`, `ContadorEventos`) e o
`ComandoDesligarLampada` já estão prontos. Leia-os antes de começar: o `ComandoDesligarLampada`
serve de modelo para os outros comandos.

1. **Observer:** complete o `notificarObservadores` do `DispositivoObservavel`.
2. **Command:** complete `ComandoLigarLampada` e `ComandoVelocidadeVentilador`.
   - Atenção ao `ComandoVelocidadeVentilador`: para desfazer, ele precisa **guardar a velocidade anterior** no momento em que executa.
3. **Invoker:** complete `pressionar` e `desfazer` no `ControleRemoto`, usando a **pilha** de histórico.

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
App: Lampada da Sala ligada.
App: Ventilador da Sala na velocidade 1.
App: Ventilador da Sala na velocidade 3.
Botao 4 sem comando.

Estado: Lampada da Sala: LIGADA | Ventilador da Sala: velocidade 3

--- Desfazendo ---
[desfazer] App: Ventilador da Sala na velocidade 1.
[desfazer] App: Ventilador da Sala na velocidade 0.
[desfazer] App: Lampada da Sala desligada.
Nada para desfazer.

--- App desconectado da lampada ---

Estado final: Lampada da Sala: LIGADA | Ventilador da Sala: velocidade 0
Eventos contados: 7

=== FIM ===
```

Repare no final: depois que o app é removido da lâmpada, apertar o botão 0 não mostra nada, mas o
contador continua contando (7 eventos no total). Cada observador é independente.

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
