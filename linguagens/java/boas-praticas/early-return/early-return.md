
## Boas práticas: Early Return em Java

O uso de `early return` é uma prática recomendada em programação que promove código mais limpo, legível e eficiente. A ideia central é **finalizar a execução de um método assim que a condição para seu término for atingida**, ao invés de aninhar diversos níveis de `if-else` ou utilizar variáveis de controle complexas.

**Benefícios do Early Return:**

* **Melhor legibilidade:** Reduz a necessidade de aninhamento profundo de código, facilitando a leitura e compreensão da lógica.
* **Código mais conciso:** Elimina código redundante e simplifica a estrutura, tornando-o mais fácil de manter.
* **Prevenção de erros:** Reduz a chance de erros relacionados a condições complexas e estados inesperados.
* **Melhoria de performance (em alguns casos):** Interrompe a execução do método assim que o resultado desejado é alcançado, evitando processamento desnecessário.

**Exemplos em Java:**

**1. Validação de parâmetros:**

```java
public void realizarOperacao(String nome, int idade) {
  // Verificação de parâmetros inválidos com early return
  if (nome == null || nome.isEmpty()) {
    return; // Finaliza a execução se o nome for inválido
  }
  if (idade < 0) {
    return; // Finaliza a execução se a idade for inválida
  }

  // Executa a operação principal somente se os parâmetros forem válidos
  // ...
}
```

**Sem Early Return:**

```java
public void realizarOperacao(String nome, int idade) {
  if (nome != null && !nome.isEmpty()) {
    if (idade >= 0) {
      // Executa a operação principal
      // ...
    } 
  }
}
```

**2. Busca em Lista:**

```java
public Produto encontrarProduto(List<Produto> produtos, int id) {
  for (Produto produto : produtos) {
    if (produto.getId() == id) {
      return produto; // Retorna o produto imediatamente quando encontrado
    }
  }
  return null; // Retorna null se o produto não for encontrado
}
```

**Sem Early Return:**

```java
public Produto encontrarProduto(List<Produto> produtos, int id) {
  Produto produtoEncontrado = null;
  for (Produto produto : produtos) {
    if (produto.getId() == id) {
      produtoEncontrado = produto;
      break;
    }
  }
  return produtoEncontrado;
}
```

**3. Cálculo Condicional:**

```java
public double calcularDesconto(double valor, int quantidade) {
  if (quantidade >= 10) {
    return valor * 0.2; // 20% de desconto
  } else if (quantidade >= 5) {
    return valor * 0.1; // 10% de desconto
  } else {
    return 0; // Sem desconto
  }
}
```

**Conclusão:**

A utilização de `early return` em Java contribui significativamente para a qualidade do código, tornando-o mais legível, conciso e menos propenso a erros. Adotar essa prática como padrão em seus projetos resultará em um código mais profissional e manutenível.
