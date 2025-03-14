# Casa do Código - Desafio

Este projeto é uma implementação do desafio "Casa do Código", utilizando **Spring Boot**, **JPA** e **MySQL**. O objetivo é simular uma aplicação para gestão de livros, com funcionalidades básicas de cadastro e consulta.

## Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.4.5**
- **Spring Data JPA**
- **Spring Web**
- **MySQL** (banco de dados principal)
- **Maven** (para gerenciamento de dependências)

## Dependências

- **spring-boot-starter-data-jpa**: Para integração com JPA (Java Persistence API).
- **spring-boot-starter-web**: Para criar e expor APIs RESTful.
- **mysql-connector-java**: Conector JDBC para MySQL.
- **spring-boot-starter-validation**: Para validações automáticas dos dados.
- **spring-boot-starter-test**: Dependência para testes unitários e de integração.

## Como Rodar o Projeto

### Pré-requisitos

- **Java 11** ou superior
- **Maven** instalado

### Passos

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/casa-do-codigo.git
    ```

2. Navegue até a pasta do projeto:

    ```bash
    cd casa-do-codigo
    ```

3. Compile o projeto e baixe as dependências com Maven:

    ```bash
    mvn clean install
    ```

4. Para rodar o projeto, execute o seguinte comando:

    ```bash
    mvn spring-boot:run
    ```

### Compilando o projeto
./mvnw clean install

### Executando o projeot
./mvnw spring-boot:run

### Executando os testes
./mvnw test

5. A aplicação estará disponível em `http://localhost:8080`.

## Configuração do Banco de Dados

A configuração do banco de dados MySQL pode ser feita no arquivo `application.properties` (ou `application.yml`):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/casa_do_codigo
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
