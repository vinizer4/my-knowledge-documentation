## Testes de Integração com RabbitMQ e Testcontainers: Um Ambiente Confiável e Repetível 🚀

Testar a integração com sistemas externos, como filas de mensagens, pode ser um desafio. **Testcontainers** surge como uma solução poderosa, permitindo criar e gerenciar contêineres Docker durante seus testes de integração, garantindo um ambiente isolado, consistente e repetível.

Neste guia, vamos explorar como usar Testcontainers para integrar seus testes Java com uma instância do RabbitMQ:

### 1. Por Que Testcontainers para RabbitMQ?

* **Isolamento:** Execute seus testes em um ambiente isolado, sem depender de uma instância externa do RabbitMQ.
* **Repetibilidade:**  Garanta a consistência dos testes, já que cada teste terá sua própria instância do RabbitMQ configurada de forma idêntica.
* **Controle:**  Configure a instância do RabbitMQ de acordo com suas necessidades específicas de teste.
* **Facilidade de Uso:**  Testcontainers simplifica a criação e o gerenciamento de contêineres Docker, integrando-se perfeitamente ao JUnit.

### 2. Configurando o Ambiente:

* **Dependências (Maven):**

 ```xml
 <dependencies>
     <!-- Testcontainers -->
     <dependency>
         <groupId>org.testcontainers</groupId>
         <artifactId>testcontainers</artifactId>
         <version>1.17.6</version> <!-- Ou versão mais recente -->
         <scope>test</scope>
     </dependency>
     <dependency>
         <groupId>org.testcontainers</groupId>
         <artifactId>rabbitmq</artifactId>
         <version>1.17.6</version> <!-- Ou versão mais recente -->
         <scope>test</scope>
     </dependency>

     <!-- RabbitMQ Client -->
     <dependency>
         <groupId>com.rabbitmq</groupId>
         <artifactId>amqp-client</artifactId>
         <version>5.16.0</version> <!-- Ou versão mais recente -->
     </dependency>

     <!-- JUnit -->
     <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-api</artifactId>
         <version>5.9.2</version> <!-- Ou versão mais recente -->
         <scope>test</scope>
     </dependency>
     <dependency>
         <groupId>org.junit.jupiter</groupId>
         <artifactId>junit-jupiter-engine</artifactId>
         <version>5.9.2</version> <!-- Ou versão mais recente -->
         <scope>test</scope>
     </dependency>
 </dependencies>
 ```

### 3. Criando um Teste de Integração com RabbitMQ e Testcontainers:

**Exemplo:**

```java
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Testcontainers
public class RabbitMQIntegrationTest {

    @Container
    private static final RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3.11-management-alpine");

    @Test
    public void testarConexaoRabbitMQ() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMQContainer.getHost());
        factory.setPort(rabbitMQContainer.getAmqpPort());
        factory.setUsername(rabbitMQContainer.getAdminUsername());
        factory.setPassword(rabbitMQContainer.getAdminPassword());

        try (Connection connection = factory.newConnection()) {
            assertNotNull(connection); 
        }
    }
}
```

**Explicação do Código:**

1. **`@Testcontainers`:** Anotação que indica que a classe usa Testcontainers.
2. **`@Container`:** Anotação que declara o contêiner Docker a ser usado (neste caso, `RabbitMQContainer`).
3. **`rabbitMQContainer`:**  Instância do `RabbitMQContainer`, configurada para usar a imagem "rabbitmq:3.11-management-alpine".
4. **`testarConexaoRabbitMQ`:** Um teste que verifica se é possível estabelecer uma conexão com o RabbitMQ.
5. **`ConnectionFactory`:** Configura a conexão com o RabbitMQ usando as informações do contêiner.
6. **`assertNotNull(connection)`:**  Verifica se a conexão foi estabelecida com sucesso.

### 4.  Executando os Testes:

Ao executar este teste com JUnit, Testcontainers iniciará automaticamente um contêiner Docker com RabbitMQ antes do teste e o encerrará após a conclusão.

### Conclusão: Testes de Integração Confiáveis e Repetíveis

Testcontainers facilita a integração de seus testes Java com RabbitMQ, proporcionando um ambiente controlado, isolado e repetível. Isso garante a confiabilidade dos seus testes e reduz a dependência de infraestrutura externa, tornando o processo de teste mais eficiente e eficaz.

