## Mocks em Testes Unitários com Mockito: Isolando Dependências para Testar com Precisão 🎯

No universo dos testes unitários, o objetivo é verificar o funcionamento correto de uma parte específica do seu código (uma "unidade", que pode ser uma classe ou método) de forma isolada. Mas, na prática, essa unidade pode depender de outros componentes, como bancos de dados, APIs externas ou até mesmo outras classes dentro do seu projeto. É aí que os **mocks** entram em cena, atuando como dublês que simulam o comportamento dessas dependências.

### Entendendo o Conceito de Mock:

Imagine um mock como um ator que substitui um componente real durante um teste. Ele não executa a lógica real do componente original, mas é programado para se comportar de uma maneira predefinida, permitindo que você:

* **Isole a unidade de código em teste:**  Você se concentra apenas no comportamento da unidade que está testando, sem se preocupar com os detalhes da implementação ou com a disponibilidade de outros componentes.
* **Controle o ambiente de teste:**  Defina os valores retornados pelos mocks, as exceções que eles devem lançar e até mesmo verifique se foram chamados da maneira esperada.
* **Acelere seus testes:**  Mocks geralmente são muito mais rápidos do que interagir com dependências reais, especialmente se essas dependências envolverem operações de I/O, rede ou acesso a banco de dados.
* **Garanta a repetibilidade:**  Os mocks sempre se comportam da mesma maneira, garantindo que seus testes sejam determinísticos e consistentes, independentemente do estado externo.

### Mockito:  Simplificando a Criação e Uso de Mocks

Mockito é um framework de mocking popular em Java que facilita a criação e o uso de mocks em seus testes unitários, tornando-os mais concisos, legíveis e eficazes.

**Dependência (Maven):**

```xml
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>4.8.1</version> <!-- Ou versão mais recente -->
  <scope>test</scope>
</dependency>
```

### Criando e Configurando Mocks com Mockito:

```java
import org.mockito.Mockito;

// Cria um mock para a interface 'RepositorioDeUsuarios'
RepositorioDeUsuarios repositorioMock = Mockito.mock(RepositorioDeUsuarios.class);

// Define que 'repositorioMock.buscarPorEmail("teste@example.com")' retornará um objeto 'Usuario' específico
Usuario usuario = new Usuario("Teste", "teste@example.com");
Mockito.when(repositorioMock.buscarPorEmail("teste@example.com")).thenReturn(usuario);
```

### Exemplo Completo: Testando um Serviço de Autenticação

```java
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class ServicoDeAutenticacaoTest {

    @Test
    public void testarAutenticacaoValida() {
        // 1. Cria mocks para as dependências
        RepositorioDeUsuarios repositorioMock = Mockito.mock(RepositorioDeUsuarios.class);
        CriptografiaSenha criptografiaMock = Mockito.mock(CriptografiaSenha.class);

        // 2. Configura o comportamento dos mocks
        Usuario usuario = new Usuario("Teste", "teste@example.com", "senha123");
        Mockito.when(repositorioMock.buscarPorEmail("teste@example.com")).thenReturn(usuario);
        Mockito.when(criptografiaMock.verificarSenha("senha123", usuario.getSenha())).thenReturn(true);

        // 3. Cria o objeto a ser testado, injetando os mocks
        ServicoDeAutenticacao servico = new ServicoDeAutenticacao(repositorioMock, criptografiaMock);

        // 4. Executa o método que se deseja testar
        boolean resultado = servico.autenticar("teste@example.com", "senha123");

        // 5. Asserções: verifica se o resultado está de acordo com o esperado
        assertTrue(resultado); 
        
        // Verifica se os mocks foram chamados como esperado
        Mockito.verify(repositorioMock).buscarPorEmail("teste@example.com");
        Mockito.verify(criptografiaMock).verificarSenha("senha123", usuario.getSenha());
    }
}
```

### Conclusão: Testes Mais Precisos, Rápidos e Confiáveis

Usar mocks em seus testes unitários Java com Mockito proporciona um controle preciso sobre o ambiente de teste, permitindo que você se concentre na lógica da unidade que está testando, sem se distrair com os detalhes de implementação ou a disponibilidade de outros componentes. Isso resulta em testes mais rápidos, confiáveis e fáceis de manter, contribuindo para a qualidade e a robustez do seu código. 
