### **Documentação sobre List em Kotlin**

---

### **Introdução ao List**

No Kotlin, a `List` é um tipo de coleção imutável e ordenada, usada para armazenar uma sequência de elementos do mesmo tipo. Assim como outras coleções em Kotlin, ela é parte da biblioteca padrão e oferece interfaces e implementações para armazenar, acessar e iterar sobre elementos.

Além da `List` imutável, o Kotlin também fornece a `MutableList`, que permite modificar a coleção (adicionar, remover, ou atualizar elementos).

As listas podem ser vistas como a alternativa mais flexível e dinâmica aos arrays, com suporte a redimensionamento dinâmico e diversas operações convenientes. Porém, o comportamento e a complexidade (Big O) variam dependendo da implementação subjacente.

---

### **Tipos de Listas no Kotlin**

1. **List** (imutável): Não pode ser modificada após sua criação.
2. **MutableList**: Permite modificações, como adicionar, remover ou atualizar elementos.

---

### **Criação de Listas**

#### 1. **Criando uma `List` imutável**
```kotlin
val list: List<Int> = listOf(1, 2, 3, 4, 5)
println(list) // Saída: [1, 2, 3, 4, 5]
```

#### 2. **Criando uma `MutableList`**
```kotlin
val mutableList: MutableList<String> = mutableListOf("Kotlin", "Java", "Python")
mutableList.add("C++")
println(mutableList) // Saída: [Kotlin, Java, Python, C++]
```

---

### **Acessando e Modificando Listas**

#### **Acesso aos Elementos**
Os elementos de uma lista podem ser acessados por seus índices:
```kotlin
val list = listOf(10, 20, 30)
println(list[1]) // Saída: 20
```

#### **Verificando o Tamanho**
A propriedade `size` retorna o número de elementos na lista:
```kotlin
val list = listOf(1, 2, 3)
println("Tamanho: ${list.size}") // Saída: Tamanho: 3
```

#### **Atualizando Elementos (apenas em `MutableList`)**
```kotlin
val mutableList = mutableListOf(10, 20, 30)
mutableList[1] = 25 // Atualizando o valor no índice 1
println(mutableList) // Saída: [10, 25, 30]
```

#### **Adicionando Elementos**
- No final:
```kotlin
val mutableList = mutableListOf(1, 2, 3)
mutableList.add(4)
println(mutableList) // Saída: [1, 2, 3, 4]
```
- Em um índice específico:
```kotlin
mutableList.add(0, 10)
println(mutableList) // Saída: [10, 1, 2, 3, 4]
```

#### **Removendo Elementos**
- Pelo valor:
```kotlin
mutableList.remove(2)
println(mutableList) // Saída: [10, 1, 3, 4]
```
- Pelo índice:
```kotlin
mutableList.removeAt(1)
println(mutableList) // Saída: [10, 3, 4]
```

---

### **Iteração sobre Listas**

#### 1. **Usando `for` loop**
```kotlin
val list = listOf("Kotlin", "Java", "Python")
for (item in list) {
    println(item)
}
// Saída:
// Kotlin
// Java
// Python
```

#### 2. **Usando índices**
```kotlin
val list = listOf(10, 20, 30)
for (i in list.indices) {
    println("Index $i: ${list[i]}")
}
// Saída:
// Index 0: 10
// Index 1: 20
// Index 2: 30
```

#### 3. **Usando funções de alta ordem**
Kotlin oferece várias funções para iterar e operar sobre listas funcionalmente:
```kotlin
listOf("Kotlin", "Java", "Python").forEach { println(it) }
```

---

### **Operações Comuns em Listas**

#### **Mapeamento**
Transforma cada elemento da lista com base em um critério dado:
```kotlin
val original = listOf(1, 2, 3, 4)
val squared = original.map { it * it }
println(squared) // Saída: [1, 4, 9, 16]
```

#### **Filtro**
Seleciona elementos que atendem a determinada condição:
```kotlin
val numbers = listOf(1, 2, 3, 4, 5)
val evenNumbers = numbers.filter { it % 2 == 0 }
println(evenNumbers) // Saída: [2, 4]
```

#### **Redução**
Combina os elementos em um único valor:
```kotlin
val numbers = listOf(1, 2, 3, 4)
val sum = numbers.reduce { acc, i -> acc + i }
println(sum) // Saída: 10
```

#### **Busca**
- Por um elemento (encontrar índice ou presença):
```kotlin
val list = listOf(10, 20, 30)
println(list.indexOf(20)) // Saída: 1
println(list.contains(20)) // Saída: true
```

---

### **Complexidade (Big O)**

A complexidade das operações em listas depende da implementação subjacente. No Kotlin, as listas geralmente são implementadas como **ArrayList** (em `MutableList`) ou **Read-Only List Wrappers** (em `List`). Aqui está a complexidade para operações comuns:

#### 1. **Acesso por Índice**
Acesso a um elemento por índice ocorre em tempo **O(1)** para listas baseadas em arrays:
```kotlin
val list = listOf(10, 20, 30)
println(list[1]) // O(1)
```

#### 2. **Busca Sequencial**
Se você não sabe o índice de um elemento, a busca por valor usando `contains` ou `indexOf` ocorre em tempo **O(n)**:
```kotlin
val list = listOf(10, 20, 30)
val index = list.indexOf(20) // O(n)
println(index) // Saída: 1
```

#### 3. **Inserção**
- Em listas mutáveis baseadas em arrays (`ArrayList`), adicionar um elemento no final é geralmente **O(1)** (com alocação extra sendo **amortizada**).
- Inserir em um índice específico pode levar **O(n)**, pois todos os elementos subsequentes precisam ser movidos.

```kotlin
val mutableList = mutableListOf(1, 2, 3)
mutableList.add(1, 10) // Inserção no índice 1
println(mutableList) // [1, 10, 2, 3] -- O(n)
```

#### 4. **Remoção**
- Remover por índice ou valor específico também costuma ser **O(n)**, pois os elementos subsequentes precisam ser movidos.
```kotlin
mutableList.remove(10) // O(n)
println(mutableList) // [1, 2, 3]
```

#### 5. **Iteração**
Iterar sobre a lista tem complexidade **O(n)**:
```kotlin
val list = listOf(1, 2, 3, 4)
list.forEach { println(it) } // O(n)
```

---

### **Dicas de Performance**

1. **Prefira operações eficientes**
    - Sempre que possível, use `add` ao final da lista para minimizar custo de inserção.

2. **Use listas imutáveis quando os dados não mudarem**
    - Reduza erros e aumente a segurança ao usar listas imutáveis em cenários de leitura.

3. **Considere outras estruturas de dados**
    - Para conjuntos sem duplicatas, considere `Set`.
    - Para pares ordenados, considere listas ligadas ou estruturas específicas.

---

### **Exemplo Final de Uso**
```kotlin
fun main() {
    // Criando uma lista
    val list = listOf(1, 2, 3, 4, 5)

    // Criando uma lista mutável
    val mutableList = mutableListOf(10, 20, 30)

    // Acessando e modificando
    println("Elemento no índice 2: ${mutableList[2]}") // O(1)
    mutableList[2] = 25
    println("Lista após modificação: $mutableList")

    // Adicionando e removendo
    mutableList.add(40) // O(1)
    mutableList.removeAt(1) // O(n)
    println("Lista final: $mutableList")

    // Iteração eficiente
    list.forEachIndexed { index, value ->
        println("Index $index -> Value $value") // O(n)
    }
}
```

---

### **Resumo**

#### **Vantagens**:
- Suporte dinâmico para adição e remoção de elementos (`MutableList`).
- Operações funcionais como `map`, `filter`, `reduce`.
- Acesso por índice eficiente (**O(1)** para listas baseadas em array).

#### **Desvantagens**:
- Inserção e remoção no meio da lista pode ser lenta (**O(n)**).
- Alocação e realocação de memória para listas mutáveis baseadas em arrays.

Esses pontos fazem do `List` uma estrutura versátil e poderosa para manipulação de sequências de dados em Kotlin!