# API Clínica IA

**Uma API para gerenciamento de uma clínica**

Este projeto é um exemplo de API RESTful para gerenciamento de uma clínica médica, desenvolvido como parte de um processo de aprendizado. Ele oferece funcionalidades essenciais para o controle de pacientes, médicos e agendamentos de consultas, com uma proposta de integração futura com inteligência artificial para análise preditiva de sintomas.

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- ![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white) **Java**: Linguagem de programação principal.
- ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white) **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
- ![Maven](https://img.shields.io/badge/Apache_Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white) **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- ![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white) **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- ![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white) **Flyway**: Ferramenta de migração de banco de dados (observado pelos arquivos `V*.sql`).
- ![Insomnia](https://img.shields.io/badge/Insomnia-4000FF?style=for-the-badge&logo=insomnia&logoColor=white) **Insomnia**: Ferramenta para testar APIs REST.
- ![VSCode](https://img.shields.io/badge/VSCode-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white) **VSCode**: Ambiente de Desenvolvimento Integrado (IDE).

## Funcionalidades

A API oferece as seguintes funcionalidades principais:

- **Cadastro e Gerenciamento de Pacientes**: Permite adicionar, listar, atualizar e inativar dados de pacientes.
- **Cadastro e Gerenciamento de Médicos**: Permite adicionar, listar, atualizar e inativar dados de médicos, incluindo suas especialidades.
- **Agendamento de Consultas**: Funcionalidade para agendar e gerenciar consultas médicas.
- **Integração com IA (Proposta)**: Análise preditiva de sintomas, sugerindo possíveis diagnósticos com base nos dados dos pacientes (funcionalidade futura).

## Estrutura do Projeto

A estrutura do projeto segue o padrão de aplicações Spring Boot, com a organização de pacotes por módulos e responsabilidades:

```
api-clinica-IA/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── med/
│   │   │       └── voll/
│   │   │           └── api/
│   │   │               ├── ApiApplication.java
│   │   │               ├── controller/
│   │   │               │   ├── HelloController.java
│   │   │               │   ├── MedicoController.java
│   │   │               │   └── PacienteController.java
│   │   │               ├── endereco/
│   │   │               │   ├── DadosEndereco.java
│   │   │               │   └── Endereco.java
│   │   │               ├── medico/
│   │   │               │   ├── DadosAtualizacaoMedico.java
│   │   │               │   ├── DadosCadastroMedico.java
│   │   │               │   ├── DadosListagemMedico.java
│   │   │               │   ├── DadosDetalhadoMedico.java
│   │   │               │   ├── Especialidade.java
│   │   │               │   ├── Medico.java
│   │   │               │   └── MedicoRepository.java
│   │   │               └── paciente/
│   │   │                   ├── DadosAtualizacaoPaciente.java
│   │   │                   ├── DadosCadastroPaciente.java
│   │   │                   ├── DadosListagemPaciente.java
│   │   │                   ├── DadosDetalhadoPaciente.java
│   │   │                   ├── Paciente.java
│   │   │                   └── PacienteRepository.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── migration/
│   │               ├── V1__create-table-medicos.sql
│   │               ├── V2__alter-table-medicos-add-column-telefone.sql
│   │               ├── V3__alter-table-medicos-add-column-ativo.sql
│   │               ├── V4__create-table-pacientes.sql
│   │               ├── V5__alter-table-pacientes.sql
│   │               └── V6__alter-table-pacientes-add-column-cpf.sql
│   └── test/
│       └── java/
│           └── med/
│               └── voll/
│                   └── api/
│                       └── ApiApplicationTests.java
├── .gitignore
├── mvnw
├── mvnw.cmd
└── pom.xml
```

## Como Rodar o Projeto

Para configurar e executar o projeto localmente, siga os passos abaixo:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

- **Java Development Kit (JDK) 17 ou superior**
- **Maven**
- **MySQL Server**

### Configuração do Banco de Dados

1.  Crie um banco de dados MySQL com o nome `voll_api`.
2.  Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/voll_api
    spring.datasource.username=root
    spring.datasource.password=sua_senha_mysql
    ```

    *Altere `sua_senha_mysql` para a senha do seu usuário root ou crie um usuário específico para o banco de dados.* 

3.  As migrações do banco de dados serão aplicadas automaticamente pelo Flyway na inicialização da aplicação.

### Executando a Aplicação

1.  Navegue até o diretório raiz do projeto (`api-clinica-IA`).
2.  Compile o projeto usando Maven:

    ```bash
    ./mvnw clean install
    ```

3.  Execute a aplicação Spring Boot:

    ```bash
    ./mvnw spring-boot:run
    ```

    A API estará disponível em `http://localhost:8080`.

## Endpoints da API

Os principais endpoints disponíveis na API são:

### Médicos

-   `POST /medicos`: Cadastra um novo médico.
-   `GET /medicos`: Lista todos os médicos ativos (paginado).
-   `PUT /medicos`: Atualiza informações de um médico existente.
-   `DELETE /medicos/{id}`: Inativa um médico (exclusão lógica).
-   `GET /medicos/{id}`: Detalha informações de um médico específico.

### Pacientes

-   `POST /pacientes`: Cadastra um novo paciente.
-   `GET /pacientes`: Lista todos os pacientes ativos (paginado).
-   `PUT /pacientes`: Atualiza informações de um paciente existente.
-   `DELETE /pacientes/{id}`: Inativa um paciente (exclusão lógica).
-   `GET /pacientes/{id}`: Detalha informações de um paciente específico.

### Hello World (Exemplo)

-   `GET /hello`: Endpoint de exemplo para verificar se a API está funcionando.

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões de melhorias, novas funcionalidades ou encontrar algum bug, sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.

