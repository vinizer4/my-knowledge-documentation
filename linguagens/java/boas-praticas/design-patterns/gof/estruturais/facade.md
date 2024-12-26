## Padrão de Projeto Facade em Java

O padrão de projeto Facade é um padrão estrutural que fornece uma interface simplificada para um subsistema complexo. Ele encapsula um conjunto de classes e fornece uma interface unificada para o cliente, escondendo a complexidade do subsistema.

**Motivação:**

* **Simplicidade:** Oferece uma interface simples para um subsistema complexo, escondendo a complexidade do cliente.
* **Reutilização:** Permite reutilizar o subsistema de forma mais fácil.
* **Desacoplamento:** Desacopla o cliente do subsistema, permitindo que o subsistema seja modificado sem afetar o cliente.

**Exemplo em Java:**

Imagine que você está desenvolvendo um sistema de banco que possui vários componentes, como autenticação, transações, relatório e gerenciamento de contas.

Sem o padrão Facade, o cliente teria que lidar com todos esses componentes individualmente, o que seria complexo e difícil de manter.

Com o padrão Facade, você pode criar uma classe `BancoFacade` que encapsula todos os componentes do sistema bancário e fornece uma interface simplificada para o cliente.

**Código Java:**

```java
// Classe para autenticação
class Autenticação {
    public boolean autenticar(String usuário, String senha) {
        // Lógica de autenticação
        return true;
    }
}

// Classe para transações
class Transações {
    public void transferir(String contaOrigem, String contaDestino, double valor) {
        // Lógica de transferência
        System.out.println("Transferindo R$ " + valor + " de " + contaOrigem + " para " + contaDestino);
    }
}

// Classe para relatórios
class Relatórios {
    public void gerarExtrato(String conta) {
        // Lógica de geração de extrato
        System.out.println("Gerando extrato da conta " + conta);
    }
}

// Classe para gerenciamento de contas
class GerenciamentoContas {
    public void criarConta(String nome, String cpf) {
        // Lógica de criação de conta
        System.out.println("Criando conta para " + nome + " (" + cpf + ")");
    }
}

// Classe Facade para o sistema bancário
class BancoFacade {
    private Autenticação autenticação;
    private Transações transações;
    private Relatórios relatórios;
    private GerenciamentoContas gerenciamentoContas;

    public BancoFacade() {
        autenticação = new Autenticação();
        transações = new Transações();
        relatórios = new Relatórios();
        gerenciamentoContas = new GerenciamentoContas();
    }

    public boolean logar(String usuário, String senha) {
        return autenticação.autenticar(usuário, senha);
    }

    public void transferir(String contaOrigem, String contaDestino, double valor) {
        transações.transferir(contaOrigem, contaDestino, valor);
    }

    public void gerarExtrato(String conta) {
        relatórios.gerarExtrato(conta);
    }

    public void criarConta(String nome, String cpf) {
        gerenciamentoContas.criarConta(nome, cpf);
    }
}

public class FacadeExample {
    public static void main(String[] args) {
        BancoFacade banco = new BancoFacade();

        // Autenticação
        if (banco.logar("joao", "1234")) {
            // Transferência
            banco.transferir("1234567890", "9876543210", 100.0);
            // Extrato
            banco.gerarExtrato("1234567890");
        }

        // Criação de conta
        banco.criarConta("Maria", "9876543210");
    }
}
```

**Saída:**

```
Transferindo R$ 100.0 de 1234567890 para 9876543210
Gerando extrato da conta 1234567890
Criando conta para Maria (9876543210)
```

**Benefícios:**

* **Simplicidade:** O cliente só precisa interagir com a classe `BancoFacade`.
* **Reutilização:** O subsistema bancário pode ser reutilizado em outros sistemas.
* **Desacoplamento:** O cliente não precisa saber como o subsistema funciona internamente.

**Observações:**

* O padrão Facade é um padrão estrutural que simplifica a interface para um subsistema complexo.
* O padrão Facade é especialmente útil para sistemas com vários componentes interdependentes.
* O padrão Facade pode ser usado em conjunto com outros padrões, como o padrão Singleton.


