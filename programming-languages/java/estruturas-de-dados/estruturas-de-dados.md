## Mergulhando nas Estruturas de Dados do Java: Um Guia Detalhado com Exemplos 🗺️

Dominar as estruturas de dados é como ter um kit de ferramentas completo para organizar e manipular informações em seus programas Java. 🧰  Com a estrutura certa, você garante a performance, a escalabilidade e a elegância do seu código.

Este guia aprofundado explora as principais estruturas de dados oferecidas pelo Java Collections Framework, ilustrando cada uma com exemplos práticos para consolidar seu aprendizado.

### 1. Listas: Ordem e Acesso Indexado

As listas são campeãs quando você precisa manter a ordem dos elementos e acessá-los por um índice numérico, similar aos arrays.

#### 1.1 ArrayList: Flexibilidade e Performance

* **Funcionamento:** Implementada como um array dinamicamente redimensionável. Quando o array interno se esgota, um novo array, com o dobro da capacidade, é criado e os elementos são copiados.
* **Vantagens:**  Excelente para acesso aleatório (get/set) em tempo constante (O(1)).
* **Desvantagens:** Adicionar ou remover elementos no meio da lista é menos eficiente (O(n)), pois pode envolver a movimentação de outros elementos.

**Exemplo:**

```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>();

        // Adicionando elementos
        frutas.add("Maçã"); 
        frutas.add("Banana");
        frutas.add("Laranja");

        // Acessando elementos pelo índice
        System.out.println("Fruta no índice 1: " + frutas.get(1)); // Saída: Banana

        // Iterando sobre a lista
        System.out.println("Frutas na lista:");
        for (String fruta : frutas) {
            System.out.println(fruta);
        }

        // Removendo um elemento
        frutas.remove("Banana");

        // Verificando o tamanho da lista
        System.out.println("Tamanho da lista: " + frutas.size()); // Saída: 2
    }
}
```

#### 1.2 LinkedList: Eficiência em Inserções e Remoções

* **Funcionamento:** Uma lista duplamente encadeada, onde cada elemento possui um link para o elemento anterior e o próximo.
* **Vantagens:** Inserções e remoções de elementos em qualquer posição da lista são rápidas (O(1)), pois apenas os links precisam ser modificados.
* **Desvantagens:** Acesso aleatório a elementos é menos eficiente que o `ArrayList` (O(n)), pois a lista precisa ser percorrida sequencialmente até o índice desejado.

**Exemplo:**

```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linguagens = new LinkedList<>();

        // Adicionando elementos
        linguagens.add("Java");
        linguagens.add("Python");
        linguagens.addFirst("C++"); // Adiciona no início 
        linguagens.addLast("JavaScript"); // Adiciona no final

        System.out.println("Linguagens: " + linguagens); // Saída: [C++, Java, Python, JavaScript]

        // Removendo o primeiro elemento
        linguagens.removeFirst();
        System.out.println("Após remover o primeiro: " + linguagens); // Saída: [Java, Python, JavaScript]
    }
}
```

#### 1.3 Vector: Sincronização para Threads

* **Funcionamento:** Similar ao `ArrayList`, mas com a maioria dos métodos sincronizados, tornando-o thread-safe para cenários concorrentes.
* **Vantagens:** Útil em situações onde a lista pode ser acessada e modificada por múltiplas threads simultaneamente, garantindo a integridade dos dados.
* **Desvantagens:**  A sincronização tem um custo de performance, tornando-o menos eficiente que o `ArrayList` em cenários single-threaded.

**Exemplo:**

```java
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> dados = new Vector<>();

        // Adicionando elementos
        dados.add(10);
        dados.add(20);
        dados.add(30);

        // Percorrendo o Vector usando um Iterator
        Iterator<Integer> iterator = dados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

#### 1.4 Stack: Pilha LIFO para Gerenciamento de Dados

* **Funcionamento:**  Segue o princípio LIFO (Last-In, First-Out) - o último elemento adicionado é o primeiro a ser removido.
* **Vantagens:** Útil para implementar algoritmos que exigem uma estrutura de pilha, como  backtracking (retrocesso), avaliação de expressões matemáticas e histórico de ações (undo/redo).
* **Desvantagens:**  Acesso a elementos que não estão no topo da pilha pode ser menos eficiente.

**Exemplo:**

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Character> pilha = new Stack<>();

        // Adicionando elementos à pilha
        pilha.push('A');
        pilha.push('B');
        pilha.push('C');

        System.out.println("Pilha: " + pilha); // Saída: [A, B, C]

        // Acessando o elemento no topo da pilha (sem remover)
        System.out.println("Topo da pilha: " + pilha.peek()); // Saída: C

        // Removendo elementos da pilha
        System.out.println("Elemento removido: " + pilha.pop()); // Saída: C
        System.out.println("Pilha após a remoção: " + pilha); // Saída: [A, B]
    }
}
```

### 2. Conjuntos: Unicidade e Operações de Conjunto

Conjuntos são ideais quando você precisa garantir a unicidade dos elementos, ignorando duplicatas, e realizar operações de conjuntos como união, interseção e diferença.

#### 2.1 HashSet: Alta Performance e Ordem Indeterminada

* **Funcionamento:**  Utiliza uma tabela hash para armazenar os elementos, o que proporciona alta performance para buscas, inserções e remoções em média (O(1)).
* **Vantagens:**  Extremamente eficiente para operações que dependem da busca de elementos.
* **Desvantagens:** Não mantém a ordem de inserção dos elementos. A ordem em que os elementos são iterados pode variar.

**Exemplo:**

```java
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> cores = new HashSet<>();

        cores.add("Azul");
        cores.add("Verde");
        cores.add("Vermelho");
        cores.add("Azul"); // Duplicata, será ignorada

        System.out.println("Cores no conjunto: " + cores); // Saída: [Verde, Vermelho, Azul] (ordem pode variar)

        // Verificando se um elemento existe
        System.out.println("Contém 'Verde'? " + cores.contains("Verde")); // Saída: true
    }
}
```

#### 2.2 LinkedHashSet: Ordem de Inserção Garantida

* **Funcionamento:**  Similar ao `HashSet`, mas mantém a ordem de inserção dos elementos utilizando uma lista duplamente encadeada internamente.
* **Vantagens:** Combina a performance da tabela hash com a ordem de inserção.
* **Desvantagens:** Um pouco menos eficiente que o `HashSet` devido à estrutura adicional da lista encadeada.

**Exemplo:**

```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> diasDaSemana = new LinkedHashSet<>();
        diasDaSemana.add("Segunda");
        diasDaSemana.add("Terça");
        diasDaSemana.add("Quarta");
        diasDaSemana.add("Quinta");
        diasDaSemana.add("Sexta");

        System.out.println(diasDaSemana); // Saída: [Segunda, Terça, Quarta, Quinta, Sexta] 
    }
}
```

#### 2.3 TreeSet: Ordenação Natural ou Personalizada

* **Funcionamento:**  Armazena os elementos em uma árvore binária balanceada (red-black tree), garantindo que os elementos sejam armazenados em ordem.
* **Vantagens:**  Permite recuperar os elementos em ordem natural (se os elementos implementarem a interface `Comparable`) ou em uma ordem definida por um `Comparator`.
* **Desvantagens:**  Operações de busca, inserção e remoção são um pouco menos eficientes (O(log n)) em comparação com `HashSet` e `LinkedHashSet`.

**Exemplo:**

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(5);
        numeros.add(1);
        numeros.add(3);
        numeros.add(2);

        System.out.println("Números em ordem crescente: " + numeros); // Saída: [1, 2, 3, 5] 
    }
}
```

### 3. Mapas: Mapeando Chaves para Valores

Mapas são estruturas de dados que armazenam pares chave-valor, onde cada chave está associada a um único valor.

#### 3.1 HashMap: Performance Excepcional para Mapeamentos

* **Funcionamento:**  Utiliza uma tabela hash para armazenar os pares chave-valor.
* **Vantagens:**  Oferece alta performance para operações de inserção, busca e remoção (em média O(1)).
* **Desvantagens:** Não mantém a ordem de inserção dos elementos.

**Exemplo:**

```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, String> capitais = new HashMap<>();

        // Adicionando pares chave-valor
        capitais.put("Brasil", "Brasília");
        capitais.put("EUA", "Washington D.C.");
        capitais.put("França", "Paris");

        // Acessando o valor a partir da chave
        System.out.println("Capital do Brasil: " + capitais.get("Brasil")); // Saída: Brasília

        // Iterando sobre o mapa
        for (String pais : capitais.keySet()) {
            System.out.println("País: " + pais + ", Capital: " + capitais.get(pais));
        }
    }
}
```

#### 3.2 LinkedHashMap:  Mantendo a Ordem de Inserção

* **Funcionamento:**  Similar ao `HashMap`, mas mantém a ordem de inserção dos elementos utilizando uma lista duplamente encadeada internamente.
* **Vantagens:** Garante que os elementos sejam iterados na ordem em que foram adicionados ao mapa.
* **Desvantagens:**  Um pouco menos eficiente que o `HashMap` devido à estrutura adicional da lista.

**Exemplo:**

```java
import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> produtos = new LinkedHashMap<>();
        produtos.put("Mouse", 25);
        produtos.put("Teclado", 50);
        produtos.put("Monitor", 300);

        for (String nome : produtos.keySet()) {
            System.out.println("Produto: " + nome + ", Quantidade: " + produtos.get(nome));
        }
        // A saída manterá a ordem de inserção dos produtos.
    }
}
```

#### 3.3 TreeMap: Mapeamento Ordenado pelas Chaves

* **Funcionamento:**  Armazena os pares chave-valor em uma árvore binária balanceada, ordenando os elementos pela chave.
* **Vantagens:**  Permite recuperar as chaves em ordem natural (se as chaves implementarem a interface `Comparable`) ou em uma ordem definida por um `Comparator`.
* **Desvantagens:** Operações de busca, inserção e remoção (O(log n)) são menos eficientes em comparação com `HashMap` e `LinkedHashMap`.

**Exemplo:**

```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Double> notas = new TreeMap<>();
        notas.put("João", 8.5);
        notas.put("Maria", 9.2);
        notas.put("Carlos", 7.0);

        for (String nome : notas.keySet()) {
            System.out.println("Nome: " + nome + ", Nota: " + notas.get(nome));
        }
        // A saída estará ordenada alfabeticamente pelo nome do aluno.
    }
}
```

#### 3.4 Hashtable: Legado com Sincronização

* **Funcionamento:**  Similar ao `HashMap`, mas com métodos sincronizados, o que o torna thread-safe.
* **Vantagens:**  Útil em cenários concorrentes, garantindo a integridade dos dados quando o mapa é acessado por múltiplas threads.
* **Desvantagens:** A sincronização tem um custo de performance, tornando-o menos eficiente que o `HashMap` em cenários single-threaded.  É considerado legado em favor de alternativas como `ConcurrentHashMap`.

**Exemplo:**

```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> estudantes = new Hashtable<>();

        estudantes.put(1, "Ana");
        estudantes.put(2, "Bruno");
        estudantes.put(3, "Carol");

        System.out.println(estudantes);
    }
}
```

### 4. Queue: Controlando o Fluxo de Dados

A interface `Queue` é ideal para gerenciar dados em uma ordem específica, geralmente seguindo o princípio FIFO (First-In, First-Out), mas também suportando ordenação por prioridade.

#### 4.1 PriorityQueue: Priorizando Elementos na Fila

* **Funcionamento:**  Implementa uma fila de prioridades, onde os elementos são ordenados com base em sua prioridade natural (se implementarem a interface `Comparable`) ou por um `Comparator` fornecido.
* **Vantagens:**  Permite recuperar elementos com base em sua prioridade, o que é útil em algoritmos de escalonamento, filas de tarefas e simulações.
* **Desvantagens:**  A performance de inserção e remoção é um pouco menor (O(log n)) do que filas FIFO simples.

**Exemplo:**

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> filaPrioridade = new PriorityQueue<>();

        filaPrioridade.add(3);
        filaPrioridade.add(1);
        filaPrioridade.add(4);
        filaPrioridade.add(2);

        System.out.println("Fila de Prioridade (ordem crescente): " + filaPrioridade);

        // Removendo elementos da fila de prioridade
        while (!filaPrioridade.isEmpty()) {
            System.out.println(filaPrioridade.poll()); // Remove e retorna o elemento de maior prioridade
        }
        // Saída: 1 2 3 4
    }
}
```

#### 4.2 Deque: Fila de Duas Pontas

* **Funcionamento:**   `Deque` (Double Ended Queue) é uma fila de duas pontas, permitindo a inserção e remoção de elementos tanto no início quanto no final da fila.
* **Vantagens:**  Flexibilidade para atuar como uma fila (FIFO) ou uma pilha (LIFO), além de outras operações especializadas.
* **Desvantagens:**  Pode ser menos intuitivo de usar para iniciantes se comparado com filas simples.

**Exemplo:**

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();

        // Adicionando elementos no início e no final
        deque.addFirst("Primeiro"); 
        deque.addLast("Último");
        deque.addFirst("Novo Primeiro");

        System.out.println(deque); // Saída: [Novo Primeiro, Primeiro, Último]

        // Removendo elementos do início e do final
        deque.removeFirst();
        deque.removeLast();

        System.out.println(deque); // Saída: [Primeiro]
    }
}
```

### Imutabilidade: Java vs. Kotlin

É importante observar que a abordagem de mutabilidade de estruturas de dados difere entre Java e Kotlin.

**Java:** A maioria das estruturas de dados em Java (`ArrayList`, `LinkedList`, `HashMap`, etc.) são **mutáveis** por padrão. Isso significa que você pode adicionar, remover ou modificar elementos após a criação da estrutura.

```java
import java.util.ArrayList;
import java.util.List;

public class MutableJava {
    public static void main(String[] args) {
        List<String> linguagens = new ArrayList<>();
        linguagens.add("Java");
        linguagens.add("Python");
        System.out.println(linguagens); // Saída: [Java, Python]

        // Modificando a lista
        linguagens.remove("Python");
        linguagens.add("Kotlin");
        System.out.println(linguagens); // Saída: [Java, Kotlin]
    }
}
```

Embora Java não tenha uma contraparte direta às `MutableList` de Kotlin, você pode obter imutabilidade usando:

* **Wrappers:**  `Collections.unmodifiableList()`, `Collections.unmodifiableSet()`, `Collections.unmodifiableMap()`.

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ImmutableJava {
    public static void main(String[] args) {
        List<String> listaMutavel = new ArrayList<>();
        listaMutavel.add("Java");

        List<String> listaImutavel = Collections.unmodifiableList(listaMutavel);
        // listaImutavel.add("Kotlin"); // Erro: UnsupportedOperationException
    }
}
```

* **Bibliotecas externas:** Guava (Google) e Apache Commons Collections.

**Kotlin:**  Kotlin diferencia explicitamente estruturas **imutáveis** (`List`, `Set`, `Map`) e **mutáveis** (`MutableList`, `MutableSet`, `MutableMap`).  A imutabilidade é favorecida para maior segurança e previsibilidade do código.

```kotlin
fun main() {
    val linguagensImutaveis = listOf("Java", "Python")
    // linguagensImutaveis.add("Kotlin") // Erro de compilação

    val linguagensMutaveis = mutableListOf("C++", "Go")
    linguagensMutaveis.add("Rust") // OK
    println(linguagensMutaveis)
}
```

**Em resumo:** Java oferece flexibilidade com mutabilidade por padrão, enquanto Kotlin promove a imutabilidade como uma boa prática de programação.  A escolha depende dos requisitos do seu projeto.


### Conclusão: Escolhendo a Estrutura Ideal

A escolha da estrutura de dados mais adequada depende diretamente do problema que você precisa solucionar e dos requisitos de performance.

Lembre-se de analisar:

* **Ordem:** É importante manter a ordem dos elementos?
* **Acesso:**  Como os elementos serão acessados (por índice, chave, etc.)?
* **Unicidade:**  É necessário garantir a unicidade dos elementos?
* **Performance:** Quais operações são mais críticas (inserção, busca, remoção)?

Com este guia detalhado, você está pronto para aplicar as estruturas de dados do Java com confiança e construir aplicações robustas e eficientes! 
