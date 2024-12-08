## Padrão Adapter em Java: Guia Completo com Exemplos

O padrão Adapter é um padrão de projeto estrutural que permite que interfaces incompatíveis trabalhem juntas. Ele atua como um intermediário entre duas classes, convertendo a interface de uma classe em outra interface que o cliente espera.

**Analogia:** Pense em um adaptador de tomada. Você tem um dispositivo com um plugue de três pinos e uma tomada de dois pinos. O adaptador converte a interface do plugue de três pinos para uma interface que a tomada de dois pinos pode aceitar.

### Diagrama UML

```
       Cliente
          |
          v
   Interface Esperada  
          |
          v
      Adaptador 
      /---------\
     /           \
    v             v
Interface     Adaptado
Existente
```

### Elementos Principais

* **Alvo (Target):** Define a interface específica do domínio que o cliente usa.
* **Cliente (Client):** Interage com objetos através da interface Alvo.
* **Adaptado (Adaptee):** A classe existente com uma interface que precisa ser adaptada.
* **Adaptador (Adapter):** Implementa a interface Alvo e mantém uma instância do Adaptado.

### Tipos de Adaptadores

* **Adaptador de Objeto:** Utiliza composição, onde o Adaptador mantém uma referência ao Adaptado.
* **Adaptador de Classe:** Utiliza herança múltipla, onde o Adaptador herda tanto do Alvo quanto do Adaptado (em linguagens que suportam herança múltipla).

### Exemplo Prático em Java

**Cenário:** Imagine que você tem um sistema de áudio que funciona com um reprodutor de música que usa a interface `MediaPlayer`. Agora você quer adicionar suporte para um novo formato de áudio, `FormatoMp4`, mas o `FormatoMp4` não implementa a interface `MediaPlayer`.

**Solução:** Podemos usar o padrão Adapter para resolver esse problema.

**Código:**

```java
// Interface Alvo
interface MediaPlayer {
    void reproduzir(String tipoArquivo, String nomeArquivo);
}

// Adaptado (Classe existente com interface diferente)
class FormatoMp4 {
    public void reproduzirMp4(String nomeArquivo) {
        System.out.println("Reproduzindo arquivo Mp4. Nome: " + nomeArquivo);
    }
}

// Adaptador (Implementa a interface Alvo e usa o Adaptado)
class AdaptadorMp4 implements MediaPlayer {
    private FormatoMp4 formatoMp4;

    public AdaptadorMp4(FormatoMp4 formatoMp4) {
        this.formatoMp4 = formatoMp4;
    }

    @Override
    public void reproduzir(String tipoArquivo, String nomeArquivo) {
        if (tipoArquivo.equalsIgnoreCase("mp4")) {
            formatoMp4.reproduzirMp4(nomeArquivo);
        } else {
            System.out.println("Formato de arquivo inválido para o AdaptadorMp4");
        }
    }
}

// Cliente
public class SistemaAudio {
    public static void main(String[] args) {
        MediaPlayer player = new AdaptadorMp4(new FormatoMp4());
        player.reproduzir("mp4", "musica.mp4");
    }
}
```

**Explicação:**

1. **Interface `MediaPlayer`:** Define a interface esperada pelo cliente (`SistemaAudio`).
2. **Classe `FormatoMp4`:** Representa o novo formato de áudio que precisa ser adaptado.
3. **Classe `AdaptadorMp4`:** Implementa a interface `MediaPlayer` e usa a classe `FormatoMp4` para reproduzir arquivos MP4.
4. **Classe `SistemaAudio`:** O cliente utiliza a interface `MediaPlayer` para reproduzir o arquivo, sem saber da existência da classe `FormatoMp4`.

### Vantagens do Padrão Adapter

* **Reutilização de código:** Permite o uso de classes existentes com interfaces incompatíveis.
* **Flexibilidade:** Facilita a adição de novas funcionalidades sem modificar o código existente.
* **Transparência:** O cliente não precisa conhecer a implementação do Adaptado.

### Quando usar o Padrão Adapter

* Quando você precisa usar uma classe existente com uma interface que não atenda às suas necessidades.
* Quando você deseja integrar classes que não foram projetadas para trabalhar juntas.
* Quando você precisa fornecer uma interface diferente para uma classe existente.

**Conclusão:** O padrão Adapter é uma ferramenta poderosa para integrar diferentes partes do seu código. Ele aumenta a flexibilidade e a reutilização de código, permitindo que você conecte classes com interfaces incompatíveis.