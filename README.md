# Sistema de Eventos Acessíveis

API RESTful desenvolvida em Java com Spring Boot e PostgreSQL para o trabalho prático individual da disciplina de Desenvolvimento de API RESTful.

## 👨‍🎓 Dados do aluno

- **Nome:** João Vitor Clemente Ferreira
- **Tema escolhido:** Sistema de Eventos Acessíveis
- **Repositório GitHub:** https://github.com/JClemente-web/trabalhoindividual_api

## 📌 Descrição do projeto

Este projeto consiste no desenvolvimento de uma API RESTful para gerenciamento de eventos acessíveis, permitindo o cadastro e a consulta de informações sobre participantes, preferências de acessibilidade, eventos, organizadores e categorias de evento.

A aplicação foi construída seguindo arquitetura em camadas, uso de DTOs para entrada e saída de dados, validação com Bean Validation, tratamento global de exceções e documentação com Swagger/OpenAPI.

## 🧩 Entidades do sistema

- Participante
- PreferenciaAcessibilidade
- Evento
- Organizador
- CategoriaEvento

## 🚀 Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Bean Validation
- Swagger / OpenAPI
- Git / GitHub

## 📁 Estrutura de pacotes

- `controller` — recebe requisições HTTP e delega ao service.
- `service` — contém a lógica de negócio.
- `repository` — comunicação com o banco de dados via JPA.
- `entity` ou `domain` — mapeamento das entidades JPA.
- `dto` — objetos de transferência de dados.
- `exception` — exceções customizadas e handler global.
- `config` — configurações gerais da aplicação.

## ⚙️ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java 17 ou superior
- Maven
- PostgreSQL
- Git

## ▶️ Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/JClemente-web/trabalhoindividual_api
