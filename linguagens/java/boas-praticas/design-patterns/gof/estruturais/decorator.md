## Padrão de Projeto Decorator em Java

O padrão de projeto Decorator é um padrão estrutural que permite adicionar responsabilidades adicionais a um objeto de forma dinâmica, envolvendo-o em um wrapper (decorador). A ideia é adicionar funcionalidades a um objeto sem modificá-lo diretamente, criando um objeto auxiliar que o envolve e acrescenta o comportamento desejado.

**Motivação:**

* **Flexibilidade:** Permite adicionar funcionalidades a um objeto sem modificá-lo diretamente, o que torna o código mais flexível e fácil de modificar.
* **Reutilização:** Permite reutilizar decoradores em diferentes objetos.
* **Simplicidade:** O código fica mais simples e organizado, pois a responsabilidade de adicionar funcionalidades é delegada para os decoradores.

**Exemplo em Java:**

Imagine que você está desenvolvendo um sistema de café que permite adicionar diferentes ingredientes ao café, como leite, açúcar e canela.

Sem o padrão Decorator, você precisaria criar classes separadas para cada tipo de café com ingredientes (por exemplo, `CafeComLeite`, `CafeComAçúcar`, `CafeComCanela`, etc.), o que resultaria em código repetitivo e difícil de manter.

Com o padrão Decorator, você pode criar uma classe abstrata para representar cafés (`Cafe`) e classes separadas para cada ingrediente (`LeiteDecorator`, `AçúcarDecorator`, `CanelaDecorator`, etc.).

**Código Java:**

```java
// Interface para cafés
interface Cafe {
    String getDescription();
    double getPreco();
}

// Classe abstrata para cafés
abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String getDescription() {
        return cafe.getDescription();
    }

    @Override
    public double getPreco() {
        return cafe.getPreco();
    }
}

// Classe para café simples
class CafeSimples implements Cafe {
    @Override
    public String getDescription() {
        return "Café Simples";
    }

    @Override
    public double getPreco() {
        return 2.0;
    }
}

// Decorador para leite
class LeiteDecorator extends CafeDecorator {
    public LeiteDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescription() {
        return cafe.getDescription() + " com leite";
    }

    @Override
    public double getPreco() {
        return cafe.getPreco() + 0.5;
    }
}

// Decorador para açúcar
class AçúcarDecorator extends CafeDecorator {
    public AçúcarDecorator(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String getDescription() {
        return cafe.getDescription() + " com açúcar";
    }

    @Override
    public double getPreco() {
        return cafe.getPreco() + 0.3;
    }
}

public class DecoratorExample {
    public static void main(String[] args) {
        // Café simples
        Cafe cafe = new CafeSimples();
        System.out.println(cafe.getDescription() + " - R$ " + cafe.getPreco());

        // Café com leite e açúcar
        cafe = new LeiteDecorator(new AçúcarDecorator(new CafeSimples()));
        System.out.println(cafe.getDescription() + " - R$ " + cafe.getPreco());
    }
}
```

**Saída:**

```
Café Simples - R$ 2.0
Café Simples com açúcar com leite - R$ 2.8
```

**Benefícios:**

* **Flexibilidade:** Permite adicionar ou remover ingredientes dinamicamente.
* **Reutilização:** Os decoradores podem ser reutilizados para diferentes tipos de cafés.
* **Simplicidade:** O código fica mais organizado, pois a responsabilidade de adicionar ingredientes é delegada para os decoradores.

**Observações:**

* O padrão Decorator é um padrão estrutural que permite adicionar funcionalidades a objetos de forma dinâmica e flexível.
* O padrão Decorator pode ser usado em conjunto com outros padrões, como o padrão Factory.
* O padrão Decorator é especialmente útil para adicionar funcionalidades a objetos que são criados por outros componentes do sistema.


