## Java Optionals: Boas práticas para um código mais limpo e seguro

O Java Optional, introduzido no Java 8, é uma classe que encapsula a presença ou ausência de um valor. Utilizá-lo corretamente traz diversos benefícios, incluindo:

**Vantagens:**

* **Código mais legível:** A intenção de lidar com valores potencialmente nulos fica clara, tornando o código mais fácil de entender e manter.
* **Prevenção de NullPointerException:** Optionals ajudam a evitar o famoso `NullPointerException`, incentivando o tratamento de cenários onde um valor pode não existir.
* **Encadeamento de métodos:**  Possibilita a aplicação de uma sequência de operações em valores opcionais de forma elegante e concisa.

### Boas Práticas:

**1. Quando usar Optional:**

* **Valores de retorno de métodos:** Quando um método pode não retornar um valor válido, utilize `Optional` para indicar explicitamente essa possibilidade. Evite retornar `null`.
* **Variáveis com valores potencialmente nulos:** Armazene valores que podem ser nulos em um `Optional`.

**Exemplo:**

```java
// Retornando Optional
public Optional<Usuario> buscarUsuarioPorEmail(String email) {
    // ... lógica de busca
    if (usuario != null) {
        return Optional.of(usuario);
    } else {
        return Optional.empty();
    }
}

// Variável Optional
Optional<String> endereco = usuario.getEndereco(); 
```

**2. Evite usar Optional para:**

* **Parâmetros de métodos:**  É geralmente mais legível e seguro usar sobrecarga de métodos ou parâmetros com valores default.
* **Campos de classes:** Campos opcionais podem ser modelados de forma mais eficiente com tipos primitivos que aceitam nulos (e.g., `Integer` em vez de `int`) ou com a utilização de outras classes.
* **Coleções:**  Coleções vazias já expressam a ausência de elementos. Utilizar `Optional` para encapsulá-las adiciona complexidade desnecessária.

**3. Métodos Úteis:**

* `isPresent()`: Verifica se o Optional contém um valor.
* `get()`: Retorna o valor presente no Optional. Lança `NoSuchElementException` se o valor não estiver presente. **Use com cautela!**
* `orElse(T other)`: Retorna o valor presente no Optional ou o valor `other` fornecido, caso o Optional esteja vazio.
* `orElseGet(Supplier<? extends T> other)`: Similar ao `orElse`, mas recebe um `Supplier` que será invocado apenas se o Optional estiver vazio, permitindo a criação de objetos sob demanda.
* `orElseThrow(Supplier<? extends X> exceptionSupplier)`: Retorna o valor presente ou lança uma exceção fornecida pelo `Supplier`.
* `ifPresent(Consumer<? super T> consumer)`: Executa o código fornecido pelo `Consumer` apenas se o Optional contiver um valor.
* `map(Function<? super T, ? extends U> mapper)`: Aplica uma função ao valor presente no Optional, retornando um novo Optional com o resultado.
* `flatMap(Function<? super T, ? extends Optional<? extends U>> mapper)`: Similar ao `map`, mas útil para casos em que a função aplicada retorna outro Optional.

**4. Exemplo de encadeamento de métodos:**

```java
usuarioService.buscarUsuarioPorEmail("usuario@example.com") 
             .map(Usuario::getEndereco)
             .map(Endereco::getCidade)
             .ifPresent(System.out::println);
```

**5. Tratamento de Exceções:**

Evite usar `get()` diretamente se não tiver certeza de que o Optional contém um valor. Utilize `orElseThrow()` para lançar uma exceção mais informativa ou trate a ausência do valor de forma adequada ao contexto.

**Conclusão:**

Utilizar o Java Optional de forma consciente torna o código mais robusto, legível e menos propenso a erros. Ao seguir as boas práticas, você aproveita os benefícios do Optional para criar aplicações Java mais seguras e eficientes. Lembre-se de que o uso excessivo de Optional pode tornar o código verboso; use com moderação e bom senso.
