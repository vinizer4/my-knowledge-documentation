### **Documentação sobre Set em Kotlin**

---

### **Introdução ao Set**

Um **Set** é uma coleção cujas propriedades principais incluem **unicidade** e, dependendo da implementação, pode ou não preservar a ordem dos seus elementos. Em Kotlin, o `Set` é parte da biblioteca padrão e é usado para armazenar elementos únicos (ou seja, sem duplicações).

Os principais tipos de `Set` disponíveis no Kotlin incluem:
1. **Imutável (`Set`)** – Não permite alterações após ser criado, útil para dados constantes.
2. **Mutável (`MutableSet`)** – Permite adicionar, remover ou modificar elementos.

Internamente, os **Sets** podem ser implementados por diferentes estruturas como `HashSet`, `LinkedHashSet`, ou `TreeSet`, cada uma com suas características de desempenho e propriedades.

---

### **Tipos de Set**

1. **`Set` (Imutável)**:
    - Uma coleção de elementos únicos que não pode ser modificada após sua criação.
    - Exemplo:
      ```kotlin
      val immutableSet: Set<Int> = setOf(1, 2, 3)
      // immutableSet.add(4) // Erro: Não é possível modificar um Set imutável
      ```

2. **`MutableSet`**:
    - Permite adicionar, remover ou modificar elementos.
    - É baseado nas classes `HashSet` ou variantes (como `LinkedHashSet` e `TreeSet`).
    - Exemplo:
      ```kotlin
      val mutableSet: MutableSet<String> = mutableSetOf("Kotlin", "Java")
      mutableSet.add("Python")
      println(mutableSet) // Saída: [Kotlin, Java, Python]
      ```

3. **`HashSet`**:
    - Implementado usando tabelas hash, onde os elementos são armazenados com base em seu código hash.
    - Não preserva a ordem dos elementos.
    - Exemplo:
      ```kotlin
      val hashSet: HashSet<Int> = hashSetOf(4, 3, 1, 2)
      println(hashSet) // A ordem dos elementos pode variar
      ```

4. **`LinkedHashSet`**:
    - Uma variante de `HashSet` que preserva a ordem de inserção dos elementos.
    - Exemplo:
      ```kotlin
      val linkedHashSet: LinkedHashSet<Int> = linkedSetOf(4, 3, 1, 2)
      println(linkedHashSet) // Saída: [4, 3, 1, 2]
      ```

5. **`TreeSet`**:
    - Implementado como uma árvore binária balanceada (ex.: Red-Black Tree), a ordem dos elementos é baseada em sua **ordem natural** ou usando um comparador fornecido.
    - Exemplo:
      ```kotlin
      val treeSet = java.util.TreeSet<Int>()
      treeSet.addAll(listOf(4, 3, 1, 2))
      println(treeSet) // Saída ordenada: [1, 2, 3, 4]
      ```

---

### **Operações Comuns em Set**

#### **1. Adicionar Elementos**
Adicionar elementos ao `MutableSet`:
```kotlin
val mutableSet = mutableSetOf(1, 2, 3)
mutableSet.add(4)
println(mutableSet) // Saída: [1, 2, 3, 4]
```

#### **2. Remover Elementos**
Remover elementos de um `MutableSet`:
```kotlin
mutableSet.remove(2)
println(mutableSet) // Saída: [1, 3, 4]
```

#### **3. Verificar Presença**
Verificar se um elemento está presente no `Set`:
```kotlin
val set = setOf(1, 2, 3)
println(2 in set) // Saída: true
println(5 in set) // Saída: false
```

#### **4. Iterar sobre os Elementos**
Iterar pelos elementos do `Set` com `for`:
```kotlin
val set = setOf("A", "B", "C")
for (item in set) {
    println(item)
}
// Saída:
// A
// B
// C
```

#### **5. Operações Matemáticas com Sets**
- **União**:
  ```kotlin
  val set1 = setOf(1, 2, 3)
  val set2 = setOf(3, 4, 5)
  val union = set1 union set2
  println(union) // Saída: [1, 2, 3, 4, 5]
  ```
- **Interseção**:
  ```kotlin
  val intersection = set1 intersect set2
  println(intersection) // Saída: [3]
  ```
- **Subtração**:
  ```kotlin
  val subtraction = set1 subtract set2
  println(subtraction) // Saída: [1, 2]
  ```

---

### **Complexidade (Big O) nas Operações de Set**

Diferentes implementações de `Set` têm diferentes características de desempenho. Aqui está uma tabela resumo do desempenho das operações com base na implementação:

| **Operação**              | **HashSet**  | **LinkedHashSet** | **TreeSet**    |
|---------------------------|--------------|-------------------|----------------|
| **Adicionar (`add`)**     | **O(1)**     | **O(1)**          | **O(log n)**   |
| **Remover (`remove`)**    | **O(1)**     | **O(1)**          | **O(log n)**   |
| **Verificar Presença (`contains`)** | **O(1)** | **O(1)**          | **O(log n)**   |
| **Iteração**              | **O(n)**     | **O(n)**          | **O(n)**       |

#### **Explicação do Big O:**
- **`HashSet`**:
    - Baseado em tabelas hash, permite inserção/remoção/busca em tempo constante na maioria dos casos. A eficiência pode diminuir em casos de colisão hash (o que é raro, desde que o hash seja bem distribuído).
- **`LinkedHashSet`**:
    - Tem as mesmas características de desempenho do `HashSet`, mas preserva a ordem de inserção, o que adiciona leve sobrecarga em memória.
- **`TreeSet`**:
    - Baseado em árvores balanceadas (como `Red-Black Tree`), onde as operações têm complexidade **logarítmica**. Ideal para cenários onde a ordenação é necessária constantemente.

---

### **Exemplo: Uso de `Set` para Resolver um Problema**

#### **Problema: Remover Duplicatas de uma Lista**

Imagine que você tenha uma lista de números (com duplicatas) e deseja obter apenas os números únicos.

#### Solução com `Set`:
```kotlin
fun main() {
    val numeros = listOf(1, 2, 2, 3, 4, 4, 5)

    // Usando Set para remover duplicatas
    val numerosUnicos = numeros.toSet()
    println(numerosUnicos) // Saída: [1, 2, 3, 4, 5]

    // Convertendo de volta para lista, se necessário
    val listaNumerosUnicos = numerosUnicos.toList()
    println(listaNumerosUnicos) // Saída: [1, 2, 3, 4, 5]
}
```

---

### **Exemplo Prático: Checar Presença de Elementos em Tempo O(1)**

#### **Problema: Verificar se Elementos Existentes Foram Visitados**

Imagine um algoritmo onde você precise verificar rapidamente se elementos já foram visitados ou processados. Por exemplo, durante uma exploração de grafo.

#### Solução com `HashSet`:
```kotlin
fun main() {
    val processados: MutableSet<Int> = mutableSetOf()

    // Simulando a visita de nós ou elementos
    processados.add(1)
    processados.add(2)

    // Verificar se um nó já foi visitado
    val foiVisitado = 3 in processados
    println("O nó 3 foi visitado? $foiVisitado") // Saída: false

    // Adicionando e verificando novamente
    processados.add(3)
    println("O nó 3 foi visitado? ${3 in processados}") // Saída: true
}
```

---

### **Comparação de Set com Outras Estruturas**

| **Aspecto**                 | **List**                  | **Set**                    |
|-----------------------------|--------------------------|----------------------------|
| **Duplicatas**              | Permite duplicatas       | Não permite duplicatas     |
| **Ordem de Inserção**       | Sempre preservada        | Varia (depende da implementação: HashSet, LinkedHashSet, etc.) |
| **Complexidade de Busca**   | **O(n)** (linear)        | **O(1)** (`HashSet`) ou **O(log n)** (`TreeSet`) |
| **Uso de Memória**          | Menor para listas simples| Maior (devido ao armazenamento extra para hash ou ponteiros). |

---

### **Resumo**

#### **Vantagens do Set**:
1. **Unicidade:** Não permite elementos duplicados automaticamente.
2. **Alto Desempenho (`HashSet`):** Operações de busca, inserção e remoção em tempo **O(1)** na maioria dos casos.
3. **Operações Matemáticas:** União, interseção e subtração nativamente suportadas.

#### **Desvantagens**:
1. **Sem suportar duplicatas.**
2. **Ordenação depende da implementação escolhida (não garantida em `HashSet`).**

#### **Quando Usar Set**:
- Quando os elementos devem ser únicos.
- Em algoritmos que precisam verificar frequência ou presença rapidamente (ex.: em tempo **O(1)** com `HashSet`).
- Para cálculos envolvendo conjuntos (união, interseção, etc.).

Com sua versatilidade e eficiência, o Set é uma poderosa estrutura de dados que se destaca em cenários que demandam elementos únicos e operações baseadas na presença ou ausência desses elementos!