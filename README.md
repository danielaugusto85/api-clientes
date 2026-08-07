# api-clientes

API Spring Boot para gerenciamento de clientes e planos.

## Visão geral

Este repositório contém uma API construída com Spring Boot para gerir clientes e planos. A API é organizada em uma arquitetura em camadas para manter separação de responsabilidades e facilitar manutenção e testes.

> Tecnologias principais:
- Spring Boot / Spring Web: https://spring.io/projects/spring-boot
- JDBC (sem Spring Data JPA): https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/
- Lombok: https://projectlombok.org/
- Swagger / OpenAPI (documentação da API): https://swagger.io/ e https://springdoc.org/
- Docker / Docker Compose (para execução do banco de dados): https://www.docker.com/ e https://docs.docker.com/compose/
- PostgreSQL: https://www.postgresql.org/
- pgAdmin: https://www.pgadmin.org/

## Estrutura em camadas

O projeto está dividido nos seguintes pacotes (camadas). Abaixo está a função de cada camada — não é feita a descrição das classes internas, apenas o propósito de cada pacote.

- configurations
  - Contém configurações da aplicação, como configuração do Swagger/OpenAPI, beans de infraestrutura, e configurações do DataSource/JDBC.

- controllers
  - Exposição dos endpoints HTTP da API. Recebem requisições, validam dados de entrada básicos e chamam os serviços apropriados.

- entities
  - Representações das entidades do domínio (modelos que correspondem às tabelas do banco de dados).

- services
  - Contém a lógica de negócio da aplicação. Os serviços orquestram operações entre repositórios, validam regras de negócio e preparam dados para os controladores.

- dtos
  - Objetos de transferência de dados usados para entrada e saída nas rotas (requests/responses), desacoplando a representação externa das entidades internas.

- repositories
  - Camada responsável pelo acesso ao banco de dados. Implementada com JDBC (queries SQL, mapeamento manual/result set mapping) em vez de usar Spring Data JPA.

## Banco de dados

O banco de dados é executado via Docker Compose definido em `docker-compose.yml`. O serviço provisiona um servidor PostgreSQL e o pgAdmin para administração. A conexão entre a aplicação e o banco é feita por JDBC.

## Observações

- A aplicação utiliza Lombok para reduzir boilerplate de código (getters/setters, construtores, builders etc.).
- A documentação das APIs está disponível via Swagger/OpenAPI (configurada na aplicação).
- Não há uso de Spring Data JPA: o acesso a dados é feito diretamente com JDBC, com SQL explícito nos repositórios.

---

Criado por: danielaugusto85
