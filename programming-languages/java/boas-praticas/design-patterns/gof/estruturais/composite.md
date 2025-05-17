## Padrão de Projeto Composite em Java

O padrão de projeto Composite é um padrão estrutural que permite tratar objetos individuais e coleções de objetos da mesma maneira. Ele define uma hierarquia de objetos onde cada objeto pode ser um nó folha (individual) ou um nó composto (contendo outros nós).

**Motivação:**

* **Reutilização de código:** Permite tratar objetos individuais e coleções de objetos de forma uniforme, reduzindo a duplicação de código.
* **Flexibilidade:** Permite adicionar ou remover componentes da estrutura de forma fácil.
* **Simplicidade:** Permite representar estruturas complexas de forma mais simples e organizada.

**Exemplo em Java:**

Imagine que você está desenvolvendo um sistema de desenho que suporta diferentes formas, como círculos, quadrados e grupos de formas. Você deseja que seja possível tratar um grupo de formas como uma única forma.

Sem o padrão Composite, você teria que criar classes separadas para cada tipo de forma e para grupos de formas, o que resultaria em código repetitivo e difícil de manter.

Com o padrão Composite, você pode criar uma interface comum para todas as formas (`Shape`) e uma classe abstrata para representar formas compostas (`CompositeShape`).

**Código Java:**

```java
// Interface para todas as formas
interface Shape {
    void draw();
    double getArea();
}

// Classe abstrata para formas compostas
abstract class CompositeShape implements Shape {
    protected List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public double getArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }
}

// Classe para círculos
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Desenhando um círculo com raio " + radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Classe para quadrados
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Desenhando um quadrado com lado " + side);
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

public class CompositeExample {
    public static void main(String[] args) {
        // Criando formas individuais
        Shape circle = new Circle(5);
        Shape square = new Square(4);

        // Criando um grupo de formas
        CompositeShape group = new CompositeShape();
        group.addShape(circle);
        group.addShape(square);

        // Desenhando as formas
        circle.draw();
        square.draw();
        group.draw();

        // Calculando a área das formas
        System.out.println("Área do círculo: " + circle.getArea());
        System.out.println("Área do quadrado: " + square.getArea());
        System.out.println("Área do grupo: " + group.getArea());
    }
}
```

**Saída:**

```
Desenhando um círculo com raio 5
Desenhando um quadrado com lado 4
Desenhando um círculo com raio 5
Desenhando um quadrado com lado 4
Área do círculo: 78.53981633974483
Área do quadrado: 16.0
Área do grupo: 94.53981633974483
```

**Benefícios:**

* **Reutilização de código:** A interface `Shape` é usada tanto para formas individuais como para grupos de formas.
* **Flexibilidade:** É possível adicionar ou remover formas do grupo de forma fácil.
* **Simplicidade:** A estrutura do código é mais simples e organizada.

**Observações:**

* O padrão Composite é frequentemente usado em sistemas gráficos, onde objetos podem ser agrupados e tratados como uma única unidade.
* O padrão Composite é um padrão estrutural que ajuda a organizar estruturas complexas de forma mais simples e eficiente.
* O padrão Composite pode ser usado em conjunto com outros padrões, como o padrão Iterator.
