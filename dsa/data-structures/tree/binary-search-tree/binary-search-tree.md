# Documentação: Binary Search Tree (BST) em Kotlin

## O que é uma Binary Search Tree (BST)?

Uma **Binary Search Tree** (Árvore Binária de Busca) é uma estrutura de dados hierárquica baseada em árvores, onde:
- Cada nó possui um **valor único** e pode ter até dois filhos: **esquerdo** e **direito**.
- **Propriedade essencial**:
    - Os valores no **filho esquerdo** de um nó são **menores** que o valor do próprio nó.
    - Os valores no **filho direito** de um nó são **maiores** que o valor do próprio nó.

Essa propriedade permite realizar **buscas, inserções e remoções** de elementos de maneira eficiente.

---

## Estrutura de uma BST em Kotlin

A estrutura básica de uma BST envolve o uso de uma classe ou `data class` para representar os nós e referências para seus filhos.

### Classe do Nó:

```kotlin
data class TreeNode<T : Comparable<T>>(
    val value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)
```

---

### Operações Fundamentais na BST e Complexidades (Big O):

As operações em uma BST têm diferentes complexidades, dependendo da estrutura da árvore (balanceada ou degenerada). Abaixo estão as operações principais:

| **Operação**  | **Complexidade (Melhor Caso)** | **Complexidade (Pior Caso)** |
|---------------|--------------------------------|------------------------------|
| **Busca**     | **O(log n)**                   | **O(n)**                     |
| **Inserção**  | **O(log n)**                   | **O(n)**                     |
| **Remoção**   | **O(log n)**                   | **O(n)**                     |

No **melhor caso**, uma BST bem balanceada tem altura igual a \( \log_2(n) \), proporcionando alta eficiência. No **pior caso**, se a árvore for degenerada (semelhante a uma lista encadeada), as operações tornam-se lineares \( O(n) \).

---

## Implementação de Operações em Kotlin

### 1. **Inserção**
Ao inserir um valor na BST, seguimos a lógica de comparação para garantir que ele seja posicionado corretamente (menor vai à esquerda, maior vai à direita).

```kotlin
fun <T : Comparable<T>> insert(node: TreeNode<T>?, value: T): TreeNode<T> {
    if (node == null) return TreeNode(value) // Caso base: Cria um novo nó
    if (value < node.value) {
        node.left = insert(node.left, value) // Insere na subárvore esquerda
    } else if (value > node.value) {
        node.right = insert(node.right, value) // Insere na subárvore direita
    }
    return node // Retorna nó atualizado
}
```

---

### 2. **Busca**
Na busca, exploramos a árvore de forma recursiva ou iterativa, movendo-nos entre as subárvores esquerda e direita com base no valor do nó.

```kotlin
fun <T : Comparable<T>> search(node: TreeNode<T>?, value: T): Boolean {
    if (node == null) return false // Valor não encontrado
    if (value == node.value) return true // Valor encontrado
    return if (value < node.value) {
        search(node.left, value) // Busca na subárvore esquerda
    } else {
        search(node.right, value) // Busca na subárvore direita
    }
}
```

---

### 3. **Remoção**
A remoção de um nó em uma BST é mais complexa, pois há três casos a serem tratados:
1. O nó é uma **folha** (sem filhos).
2. O nó tem **um filho**.
3. O nó tem **dois filhos** (precisamos encontrar o sucessor ou antecessor para substituir o nó).

```kotlin
fun <T : Comparable<T>> delete(node: TreeNode<T>?, value: T): TreeNode<T>? {
    if (node == null) return null // Nó não encontrado

    if (value < node.value) {
        node.left = delete(node.left, value) // Remove da subárvore esquerda
    } else if (value > node.value) {
        node.right = delete(node.right, value) // Remove da subárvore direita
    } else {
        // Nó encontrado!
        if (node.left == null) return node.right // Caso com 0 ou 1 filho
        if (node.right == null) return node.left // Caso com 0 ou 1 filho

        // Caso com 2 filhos: Substitua pelo menor nó da subárvore direita (sucessor)
        val successor = minValueNode(node.right!!)
        node.value = successor.value
        node.right = delete(node.right, successor.value) // Remove o sucessor
    }
    return node
}

fun <T : Comparable<T>> minValueNode(node: TreeNode<T>): TreeNode<T> {
    var current = node
    while (current.left != null) {
        current = current.left!!
    }
    return current
}
```

---

### 4. **Traversal (Percursos na Árvore)**

#### **Inorder Traversal** (Esquerda → Raiz → Direita):
Visita os nós em **ordem crescente** (se for uma BST).

```kotlin
fun <T> inorderTraversal(node: TreeNode<T>?) {
    if (node == null) return
    inorderTraversal(node.left)
    println(node.value)
    inorderTraversal(node.right)
}
```

#### **Preorder Traversal** (Raiz → Esquerda → Direita):
Visita os nós na ordem da construção da árvore.

```kotlin
fun <T> preorderTraversal(node: TreeNode<T>?) {
    if (node == null) return
    println(node.value)
    preorderTraversal(node.left)
    preorderTraversal(node.right)
}
```

#### **Postorder Traversal** (Esquerda → Direita → Raiz):
Visita os filhos antes dos pais.

```kotlin
fun <T> postorderTraversal(node: TreeNode<T>?) {
    if (node == null) return
    postorderTraversal(node.left)
    postorderTraversal(node.right)
    println(node.value)
}
```

---

## Exemplo Prático em Kotlin

Neste exemplo, criaremos uma BST, realizaremos inserções, buscas e percursos.

```kotlin
fun main() {
    // Criação da árvore inicial
    var root: TreeNode<Int>? = null

    // Inserindo valores na BST
    val values = listOf(50, 30, 70, 20, 40, 60, 80)
    for (value in values) {
        root = insert(root, value)
    }

    println("Inorder Traversal (Ordenado):")
    inorderTraversal(root) // Saída: 20, 30, 40, 50, 60, 70, 80

    println("\nBusca pelo valor 40: ${search(root, 40)}") // Saída: true
    println("Busca pelo valor 90: ${search(root, 90)}") // Saída: false

    println("\nRemovendo o valor 70:")
    root = delete(root, 70) // Remove o valor 70
    inorderTraversal(root) // Saída: 20, 30, 40, 50, 60, 80
}
```

---

## Casos de Uso Famosos da BST

### 1. **Sistemas de Indexação**
Em sistemas como bibliotecas digitais e bancos de dados, a BST pode ser usada para organizar e buscar documentos com base em chaves (ex.: IDs ou nomes).

---

### 2. **Jogos e IA**
BSTs podem ser usadas para **processar decisões hierárquicas** e **organizar estados** em jogos com base em valores comparativos (ex.: sistemas de movimentação ou tabelas de estratégia).

---

### 3. **Autocompletar e Busca Rápida**
A BST pode ser utilizada para implementar mecanismo de busca eficiente e ordenado, como sistemas de **autocomplete** em editores e motores de busca.

---

### 4. **Organização de Dados Ordenados**
A BST é ideal para representar dados estruturados em listas ou tabelas ordenadas onde operações de busca, inserção e exclusão rápidas são necessárias.

---

## Exemplos de Problemas Resolvidos com BST

### **Problema: Encontrar o `k`-ésimo menor elemento na BST**
Este problema envolve usar o **Inorder Traversal**, que visita os elementos em ordem crescente.

```kotlin
fun <T> kthSmallest(node: TreeNode<T>?, k: Int): T? {
    val result = mutableListOf<T>()
    inorderTraversalHelper(node, result)
    return if (k <= result.size) result[k - 1] else null
}

fun <T> inorderTraversalHelper(node: TreeNode<T>?, result: MutableList<T>) {
    if (node == null) return
    inorderTraversalHelper(node.left, result)
    result.add(node.value)
    inorderTraversalHelper(node.right, result)
}

// Chamada no `main`:
println("3º menor valor na BST: ${kthSmallest(root, 3)}") // Saída: 40
```

---

## Conclusão

A Binary Search Tree é uma estrutura de dados poderosa e eficiente para armazenar e realizar operações em conjuntos ordenados. Em Kotlin, sua implementação é simples e flexível. Embora existam cenários em que sua eficiência pode ser prejudicada (ex.: árvores degeneradas), técnicas como **autossegurança** e **estruturas balanceadas** (AVL Tree ou Red-Black Tree) podem ser usadas.

A BST é amplamente usada em aplicações reais que envolvem buscas rápidas, decisões hierárquicas e manipulação de conjuntos de dados ordenados.