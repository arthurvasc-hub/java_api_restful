# API RESTful de Usuários

Esta é uma **API RESTful** desenvolvida com **Spring Boot** e **Java** para gerenciar usuários. A API oferece operações básicas de CRUD (Criar, Ler, Atualizar, Deletar) e foi projetada para ser usada como base para sistemas de gerenciamento de usuários.

## Funcionalidades

- **GET** `/users`: Recupera todos os usuários.
- **GET** `/users/{id}`: Recupera um usuário específico por ID.
- **POST** `/users`: Cria um novo usuário.
- **PUT** `/users/{id}`: Atualiza um usuário existente.
- **DELETE** `/users/{id}`: Deleta um usuário pelo ID.

## Tecnologias Utilizadas

- **Java** 17
- **Spring Boot** 3.x
- **Spring Web** (para os controladores REST)
- **Spring Data JPA** (para interação com o banco de dados)
- **Spring Security** (para segurança e autenticação)
- **H2 Database** (banco de dados em memória para testes, pode ser substituído por outro banco)
- **Swagger OpenAPI 3.0** (para documentação interativa)
- **dotenv-java** (para gerenciar variáveis de ambiente)

## Instalação

Para rodar esta API localmente, siga os passos abaixo:

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

### Passos para rodar o projeto

1. **Clone este repositório**:

   ```bash
   git clone https://github.com/arthurvasc-hub/java_api_restful
   cd java_api_restful
2. **Instale as dependências:**:
   Se você tiver o Maven instalado, execute o seguinte comando:
   - mvn clean install
3. **Execute a aplicação:**:
   Para rodar a API, utilize o comando abaixo:
   - mvn spring-boot:run
   O servidor será iniciado no http://localhost:8080.

### Acessando a Documentação da API com Swagger

A API vem com Swagger integrado para gerar a documentação interativa. Para acessar:

Abra o navegador e acesse http://localhost:8080/swagger-ui.html
A documentação interativa estará disponível para testar os endpoints diretamente pela interface web.

###Como Contribuir

Se você deseja contribuir para este projeto, siga os passos abaixo:

Faça um fork do repositório.
Crie uma branch para sua feature (git checkout -b feature/nome-da-feature).
Faça commit das suas alterações (git commit -m 'Add new feature').
Envie para a branch principal (git push origin feature/nome-da-feature).
Abra um Pull Request.

  
