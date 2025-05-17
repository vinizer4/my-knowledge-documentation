## Padrão de Projeto Flyweight em Java

O padrão de projeto Flyweight é um padrão estrutural que permite compartilhar objetos para reduzir o consumo de memória, especialmente quando se tem um grande número de objetos com estados semelhantes. A ideia é evitar a criação de novos objetos quando um já existente pode ser reutilizado, compartilhando-o entre múltiplas instâncias.

**Motivação:**

* **Eficiência de memória:** Reduz o consumo de memória compartilhando objetos.
* **Desempenho:** Melhora o desempenho, pois evita a criação de novos objetos.
* **Reutilização:** Permite reutilizar objetos de forma mais eficiente.

**Exemplo em Java:**

Imagine que você está desenvolvendo um jogo que possui muitos personagens com as mesmas características (por exemplo, inimigos). Criar um objeto para cada personagem individualmente consumiria muita memória.

Com o padrão Flyweight, você pode criar um objeto "flyweight" que representa as características comuns dos personagens, e reutilizar esse objeto para todos os personagens que compartilhem essas características.

**Código Java:**

```java
// Interface para personagens
interface Personagem {
    void desenhar(int x, int y);
}

// Classe para o personagem Flyweight
class PersonagemFlyweight {
    private String nome;
    private String cor;

    public PersonagemFlyweight(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }
}

// Classe para o personagem concreto
class PersonagemConcreto implements Personagem {
    private PersonagemFlyweight flyweight;
    private int x;
    private int y;

    public PersonagemConcreto(PersonagemFlyweight flyweight, int x, int y) {
        this.flyweight = flyweight;
        this.x = x;
        this.y = y;
    }

    @Override
    public void desenhar(int x, int y) {
        System.out.println("Desenhando personagem " + flyweight.getNome() + " na posição (" + x + ", " + y + ")");
    }
}

// Fábrica para personagens Flyweight
class FabricaPersonagemFlyweight {
    private Map<String, PersonagemFlyweight> flyweights = new HashMap<>();

    public PersonagemFlyweight obterFlyweight(String nome, String cor) {
        PersonagemFlyweight flyweight = flyweights.get(nome + cor);
        if (flyweight == null) {
            flyweight = new PersonagemFlyweight(nome, cor);
            flyweights.put(nome + cor, flyweight);
        }
        return flyweight;
    }
}

public class FlyweightExample {
    public static void main(String[] args) {
        FabricaPersonagemFlyweight fabrica = new FabricaPersonagemFlyweight();

        // Criando personagens Flyweight
        PersonagemFlyweight flyweight1 = fabrica.obterFlyweight("Goblin", "Verde");
        PersonagemFlyweight flyweight2 = fabrica.obterFlyweight("Goblin", "Verde");

        // Criando personagens concretos
        Personagem personagem1 = new PersonagemConcreto(flyweight1, 10, 20);
        Personagem personagem2 = new PersonagemConcreto(flyweight2, 30, 40);

        // Desenhando os personagens
        personagem1.desenhar(10, 20);
        personagem2.desenhar(30, 40);
    }
}
```

**Saída:**

```
Desenhando personagem Goblin na posição (10, 20)
Desenhando personagem Goblin na posição (30, 40)
```

**Benefícios:**

* **Eficiência de memória:** O objeto `PersonagemFlyweight` é compartilhado entre os dois personagens.
* **Desempenho:** A criação de novos objetos `PersonagemFlyweight` é evitada.
* **Reutilização:** O objeto `PersonagemFlyweight` pode ser reutilizado para outros personagens com as mesmas características.

**Observações:**

* O padrão Flyweight é um padrão estrutural que permite compartilhar objetos para reduzir o consumo de memória.
* O padrão Flyweight é especialmente útil em sistemas com muitos objetos que possuem estados semelhantes.
* O padrão Flyweight pode ser usado em conjunto com outros padrões, como o padrão Factory.


