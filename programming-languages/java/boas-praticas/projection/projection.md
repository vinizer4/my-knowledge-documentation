## Padrão Projection com Spring Data JPA: Simplificando a Busca e Mapeamento de Dados

O padrão Projection, em conjunto com o Spring Data JPA, oferece uma maneira elegante e eficiente de buscar dados diretamente no formato desejado, eliminando a necessidade de mappers para transformar entidades em DTOs.

**Vantagens:**

* **Performance Aprimorada:** Consultas mais eficientes, pois apenas os dados necessários são recuperados do banco de dados.
* **Código Mais Limpo:** Elimina a necessidade de classes DTO e mappers, tornando o código mais conciso e legível.
* **Manutenção Simplificada:** Menos código significa menos bugs e menos tempo gasto em manutenção.

### Tipos de Projeções:

1. **Interfaces:**

   Definimos uma interface com os métodos que representam os atributos desejados da entidade. A interface não precisa implementar nenhuma lógica, apenas declarar os métodos "getters".

   ```java
   public interface UsuarioInfo {
       Long getId();
       String getNome();
       String getEmail();
   }
   ```

   No repositório, a interface de projeção é utilizada como tipo de retorno:

   ```java
   public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
       List<UsuarioInfo> findAllProjectedBy();
   }
   ```

   O Spring Data JPA se encarrega de gerar a consulta SQL que recupera apenas os atributos especificados na interface.

2. **Classes:**

   Similar ao uso de interfaces, mas com a flexibilidade de adicionar lógica extra na classe de projeção, caso necessário.

   ```java
   public class UsuarioDetalhes {
       private Long id;
       private String nome;
       private String email;

       // Construtor
       public UsuarioDetalhes(Long id, String nome, String email) {
           this.id = id;
           this.nome = nome;
           this.email = email;
       }

       // Getters
   }
   ```

   No repositório, utilizamos `@Query` para especificar a projeção:

   ```java
   public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
       @Query("SELECT new com.example.projeto.dto.UsuarioDetalhes(u.id, u.nome, u.email) FROM Usuario u")
       List<UsuarioDetalhes> encontrarTodosDetalhes();
   }
   ```

### Exemplo Completo:

**Entidade:**

```java
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    // ... getters e setters ...
}
```

**Interface de Projeção:**

```java
public interface UsuarioInfo {
    Long getId();
    String getNome();
    String getEmail();
}
```

**Repositório:**

```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<UsuarioInfo> findAllProjectedBy(); 
}
```

**Serviço:**

```java
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioInfo> obterTodosUsuarios() {
        return usuarioRepository.findAllProjectedBy();
    }
}
```

**Controller:**

```java
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioInfo> listarUsuarios() {
        return usuarioService.obterTodosUsuarios();
    }
}
```

Neste exemplo, a consulta ao endpoint `/usuarios` retornará uma lista de objetos `UsuarioInfo` contendo apenas o `id`, `nome` e `email`, sem a necessidade de criar um DTO explicitamente.

### Conclusão:

O padrão Projection com Spring Data JPA simplifica o desenvolvimento, tornando o código mais eficiente, limpo e fácil de manter. Utilize essa abordagem para otimizar suas consultas e reduzir a complexidade do seu código.