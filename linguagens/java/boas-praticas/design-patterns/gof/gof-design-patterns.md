O livro "Design Patterns: Elements of Reusable Object-Oriented Software", comumente chamado de "Gang of Four (GoF) Design Patterns", define 23 padrões de design, categorizados em três grupos:

**Padrões de Criação (Criacionais):**

* **Abstract Factory:** Fornece uma interface para criar famílias de objetos relacionados sem especificar suas classes concretas.
* **Builder:** Separa a construção de um objeto complexo de sua representação, permitindo que o mesmo processo de construção crie diferentes representações.
* **Factory Method:** Define uma interface para criar objetos, mas deixa que as subclasses decidam qual classe instanciar.
* **Prototype:** Especifica os tipos de objetos a serem criados usando uma instância prototípica e cria novos objetos copiando este protótipo.
* **Singleton:** Garante que uma classe tenha apenas uma instância e fornece um ponto de acesso global a ela.

**Padrões Estruturais:**

* **Adapter:** Converte a interface de uma classe em outra interface esperada pelos clientes, permitindo que classes com interfaces incompatíveis trabalhem juntas.
* **Bridge:** Desacopla uma abstração de sua implementação, permitindo que ambas variem independentemente.
* **Composite:** Compõe objetos em estruturas de árvore para representar hierarquias parte-todo. Permite que os clientes tratem objetos individuais e composições de objetos de forma uniforme.
* **Decorator:** Anexa responsabilidades adicionais a um objeto dinamicamente. Os Decorators fornecem uma alternativa flexível a subclasses para estender a funcionalidade.
* **Facade:** Fornece uma interface simplificada para um subsistema complexo, tornando-o mais fácil de usar.
* **Flyweight:** Compartilha objetos de granularidade fina para dar suporte eficiente a um grande número de objetos de granularidade fina.
* **Proxy:** Fornece um substituto ou espaço reservado para outro objeto para controlar o acesso a ele.

**Padrões Comportamentais:**

* **Chain of Responsibility:** Evita acoplar o remetente de uma solicitação ao seu receptor, dando a vários objetos a chance de lidar com a solicitação.
* **Command:** Encapsula uma solicitação como um objeto, permitindo parametrizar clientes com diferentes solicitações, enfileirar ou registrar solicitações e dar suporte a operações que podem ser desfeitas.
* **Interpreter:** Define uma representação gramatical para uma linguagem e fornece um interpretador para lidar com solicitações nessa gramática.
* **Iterator:** Fornece uma maneira de acessar sequencialmente os elementos de um objeto agregado sem expor sua representação subjacente.
* **Mediator:** Define um objeto que encapsula como um conjunto de objetos interage. Promove o acoplamento fraco, evitando que os objetos se refiram uns aos outros explicitamente, e permite que suas interações sejam variadas independentemente.
* **Memento:** Captura e externaliza o estado interno de um objeto sem violar o encapsulamento, permitindo que o objeto seja restaurado para um estado anterior posteriormente.
* **Observer:** Define uma dependência um-para-muitos entre objetos para que, quando um objeto muda de estado, todos os seus dependentes sejam notificados e atualizados automaticamente.
* **State:** Permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá mudar de classe.
* **Strategy:** Define uma família de algoritmos, encapsula cada um e os torna intercambiáveis. Permite que o algoritmo varie independentemente dos clientes que o utilizam.
* **Template Method:** Define o esqueleto de um algoritmo em uma operação, adiando alguns passos para as subclasses. Permite que as subclasses redefinam certos passos de um algoritmo sem alterar a estrutura do próprio algoritmo.
* **Visitor:** Representa uma operação a ser realizada nos elementos de uma estrutura de objetos. Visitor permite definir uma nova operação sem alterar as classes dos elementos nos quais opera.

Estes são apenas resumos. Cada padrão tem suas próprias nuances e aplicações específicas. Para realmente dominar o uso de Design Patterns, recomendo a leitura do livro do GoF ou outras fontes confiáveis de aprendizado. 
