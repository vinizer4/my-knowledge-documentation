## Padrão Estrutural Bridge em Java

O padrão de projeto Bridge é um padrão estrutural que **desacopla uma abstração de sua implementação, permitindo que ambas variem de forma independente**. Em outras palavras, ele permite que você crie uma ponte entre uma interface (abstração) e sua implementação real, permitindo que você mude a implementação sem afetar a interface.

**Motivação:**

* **Flexibilidade:** Permitir que a implementação da abstração seja alterada sem modificar a interface.
* **Reutilização:** Reutilizar implementações de diferentes classes com a mesma interface.
* **Simplicidade:** Separar a complexidade da interface da implementação.

**Exemplo em Java:**

Imagine que você está desenvolvendo um sistema de desenho que suporta diferentes formatos de saída, como arquivos PNG, JPEG e SVG. Você também precisa de diferentes tipos de formas, como círculos, quadrados e retângulos.

Sem o padrão Bridge, você precisaria criar classes separadas para cada combinação de forma e formato de saída (por exemplo, `CirclePNG`, `SquareJPEG`, etc.). Isso resultaria em um código repetitivo e difícil de manter.

Com o padrão Bridge, você pode criar uma abstração para formas (`Shape`) e uma interface para formatos de saída (`OutputFormat`). A implementação do formato de saída é desacoplada da implementação da forma.

**Código Java:**

```java
// Interface para formatos de saída
interface OutputFormat {
    void draw(String shapeData);
}

// Implementações de formatos de saída
class PNGFormat implements OutputFormat {
    @Override
    public void draw(String shapeData) {
        System.out.println("Desenhando um PNG com dados: " + shapeData);
    }
}

class JPEGFormat implements OutputFormat {
    @Override
    public void draw(String shapeData) {
        System.out.println("Desenhando um JPEG com dados: " + shapeData);
    }
}

// Abstração para formas
abstract class Shape {
    protected OutputFormat format;

    public Shape(OutputFormat format) {
        this.format = format;
    }

    public abstract String getShapeData();

    public void draw() {
        format.draw(getShapeData());
    }
}

// Implementações de formas
class Circle extends Shape {
    public Circle(OutputFormat format) {
        super(format);
    }

    @Override
    public String getShapeData() {
        return "Círculo";
    }
}

class Square extends Shape {
    public Square(OutputFormat format) {
        super(format);
    }

    @Override
    public String getShapeData() {
        return "Quadrado";
    }
}

public class BridgeExample {
    public static void main(String[] args) {
        // Desenhando um círculo como PNG
        Shape circlePNG = new Circle(new PNGFormat());
        circlePNG.draw();

        // Desenhando um quadrado como JPEG
        Shape squareJPEG = new Square(new JPEGFormat());
        squareJPEG.draw();
    }
}
```

**Saída:**

```
Desenhando um PNG com dados: Círculo
Desenhando um JPEG com dados: Quadrado
```

**Benefícios:**

* **Flexibilidade:** Permite a mudança de formato de saída sem afetar a implementação da forma.
* **Reutilização:** Reutilização da implementação de formatos de saída para diferentes formas.
* **Manutenção:** Código mais organizado e fácil de manter.

**Observações:**

* O padrão Bridge é um padrão estrutural complexo que pode ser usado para criar sistemas flexíveis e escaláveis.
* O padrão Bridge é particularmente útil quando se trabalha com interfaces com implementações diferentes.
* Você pode combinar o padrão Bridge com outros padrões, como o padrão Factory.
