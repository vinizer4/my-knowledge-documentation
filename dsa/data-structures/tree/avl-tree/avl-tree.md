# Documentação: AVL Tree em Kotlin

## O que é uma AVL Tree?

A **AVL Tree** (ou Árvore AVL) é uma estrutura de dados do tipo Árvore Binária de Busca (Binary Search Tree - BST), com a propriedade adicional de ser **autobalanceada**. Essa árvore foi introduzida por **Adelson-Velsky e Landis** em 1962 (daí o nome AVL). Em uma AVL Tree, a diferença de altura entre as subárvores à esquerda e à direita de qualquer nó (também chamada de "fator de balanceamento") é sempre no máximo **±1**.

Essa propriedade de balanceamento garante que a altura da AVL Tree permanece **O(log n)**, o que resulta em uma busca, inserção e remoção eficientes, mesmo nos piores casos.

---

## Estrutura da AVL Tree

Cada nó em uma AVL Tree contém:
1. Um valor (ou chave).
2. Referências para os nós filhos esquerdo e direito.
3. Altura do nó.

Em termos de estrutura, isso pode ser representado em Kotlin da seguinte maneira:

```kotlin
data class TreeNode<T : Comparable<T>>(
    var value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
    var height: Int = 1 // A altura inicial do nó é 1
)
```

---

## Operações Principais em AVL Tree

A AVL Tree suporta as mesmas operações básicas de uma árvore binária de busca convencional (como inserção, busca e remoção), mas também realiza rotações (à esquerda, à direita ou combinações). Essas rotações garantem que a árvore permaneça balanceada depois que qualquer operação altera sua estrutura.

---

### 1. **Calcular a Altura do Nó**
A altura de um nó é o número máximo de arestas entre o nó e uma folha.

```kotlin
fun height(node: TreeNode<*>?): Int {
    return node?.height ?: 0
}
```

---

### 2. **Fator de Balanceamento**
O fator de balanceamento de um nó é a diferença entre a altura das subárvores esquerda e direita.

```kotlin
fun balanceFactor(node: TreeNode<*>?): Int {
    return if (node == null) 0 else height(node.left) - height(node.right)
}
```

---

### 3. **Rotação**
Existem quatro tipos de rotações usadas para balancear a AVL Tree:

1. **Rotação à Direita (Right Rotation)**

```kotlin
fun <T : Comparable<T>> rightRotate(y: TreeNode<T>): TreeNode<T> {
    val x = y.left
    val T2 = x?.right

    x?.right = y
    y.left = T2

    // Atualiza as alturas
    y.height = maxOf(height(y.left), height(y.right)) + 1
    x?.height = maxOf(height(x.left), height(x.right)) + 1

    return x!!
}
```

---

2. **Rotação à Esquerda (Left Rotation)**

```kotlin
fun <T : Comparable<T>> leftRotate(x: TreeNode<T>): TreeNode<T> {
    val y = x.right
    val T2 = y?.left

    y?.left = x
    x.right = T2

    // Atualiza as alturas
    x.height = maxOf(height(x.left), height(x.right)) + 1
    y?.height = maxOf(height(y.left), height(y.right)) + 1

    return y!!
}
```

---

3. **Rotação Esquerda-Direita (Left-Right Rotation)**
- É uma combinação de uma rotação à esquerda seguida por uma rotação à direita.

```kotlin
fun <T : Comparable<T>> leftRightRotate(node: TreeNode<T>): TreeNode<T> {
    node.left = leftRotate(node.left!!)
    return rightRotate(node)
}
```

---

4. **Rotação Direita-Esquerda (Right-Left Rotation)**
- É uma combinação de uma rotação à direita seguida por uma rotação à esquerda.

```kotlin
fun <T : Comparable<T>> rightLeftRotate(node: TreeNode<T>): TreeNode<T> {
    node.right = rightRotate(node.right!!)
    return leftRotate(node)
}
```

---

### 4. **Inserção**
Durante a inserção, o balanceamento da árvore é verificado, e as rotações são aplicadas conforme necessário.

```kotlin
fun <T : Comparable<T>> insert(node: TreeNode<T>?, value: T): TreeNode<T> {
    // Passo 1: Inserir como em uma BST padrão
    if (node == null) return TreeNode(value)

    if (value < node.value) {
        node.left = insert(node.left, value)
    } else if (value > node.value) {
        node.right = insert(node.right, value)
    } else {
        return node // Chaves duplicadas não são permitidas
    }

    // Passo 2: Atualiza a altura do nó atual
    node.height = 1 + maxOf(height(node.left), height(node.right))

    // Passo 3: Obtém o fator de balanceamento
    val balance = balanceFactor(node)

    // Passo 4: Balancear a árvore, se necessário
    return when {
        balance > 1 && value < node.left!!.value -> rightRotate(node) // Caso Esquerda-Esquerda
        balance < -1 && value > node.right!!.value -> leftRotate(node) // Caso Direita-Direita
        balance > 1 && value > node.left!!.value -> leftRightRotate(node) // Caso Esquerda-Direita
        balance < -1 && value < node.right!!.value -> rightLeftRotate(node) // Caso Direita-Esquerda
        else -> node
    }
}
```

---

### 5. **Busca**

Como uma AVL Tree é uma árvore binária de busca, a operação de busca é igual à de uma BST convencional, com complexidade média e pior caso: **O(log n)**.

```kotlin
fun <T : Comparable<T>> search(node: TreeNode<T>?, value: T): Boolean {
    if (node == null) return false
    if (value == node.value) return true
    return if (value < node.value) {
        search(node.left, value)
    } else {
        search(node.right, value)
    }
}
```

---

## Complexidade no Melhor, Médio e Pior Caso

| Operação       | Complexidade  |
|----------------|---------------|
| **Buscar**     | O(log n)      |
| **Inserir**    | O(log n)      |
| **Deletar**    | O(log n)      |
| **Espaço**     | O(n)          |

A propriedade de autobalanceamento da AVL Tree garante que sua altura permaneça próxima a \( \log_2(n) \), onde \( n \) é o número de nós. Isso se traduz em operações altamente eficientes, mesmo nos piores cenários.

---

## Casos de Uso Famosos

### 1. **Índices em Bancos de Dados**
Sempre que buscas rápidas e eficientes são necessárias em grandes conjuntos de dados, como em bancos de dados e sistemas de arquivos, ÁRVORES AVL são úteis por sua garantia de balanceamento.

Exemplo: Árvores B ou B+ (derivadas do conceito de AVL Trees) são amplamente usadas em bancos de dados relacionais como MySQL.

---

### 2. **Sistemas de Compiladores**
AVL Trees são utilizadas em compiladores para armazenar tabelas de símbolos, que organizam informações sobre variáveis, funções e estruturas legíveis em tempo de execução, para buscas rápidas.

---

### 3. **Aplicações com Consultas Frequentes**
Sistemas onde os dados mudam frequentemente e buscas precisam ser rápidas, como em sistemas de gestão de conteúdo (CMS) ou caches.

---

## Exemplo Resolvido com AVL Tree

### **Problema: Inserir Elementos e Buscar na AVL Tree**
Construa uma AVL Tree usando os valores [30, 20, 40, 10, 25, 35, 50] e busque o valor 25.

```kotlin
fun main() {
    // Inicializando uma árvore
    var root: TreeNode<Int>? = null

    // Inserindo valores
    val values = listOf(30, 20, 40, 10, 25, 35, 50)
    for (value in values) {
        root = insert(root, value)
    }

    // Buscar um valor
    val searchValue = 25
    println("Valor $searchValue encontrado? ${search(root, searchValue)}") // true
}
```

Saída:
```
Valor 25 encontrado? true
```

---

## Conclusão

A AVL Tree é uma estrutura poderosa que combina a organização eficiente das Árvores Binárias de Busca com o balanceamento automático. Isso a torna ideal para cenários onde a busca, inserção e exclusão têm que ser rápidas e previsíveis. Em Kotlin, sua implementação é relativamente simples, mas requer atenção na lógica de balanceamento e rotações.