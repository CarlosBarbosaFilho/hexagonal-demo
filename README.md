# hexagonal-demo (Spring Boot + Java 21 + Arquitetura Hexagonal)

Este projeto demonstra **Arquitetura Hexagonal (Ports & Adapters)** com **Spring Boot 3.x** e **Java 21**.

## Estrutura
- `domain/`: modelo e portas (interfaces) **sem dependência de Spring**
- `application/`: casos de uso (services) que orquestram o domínio
- `adapter/in`: entrada (REST)
- `adapter/out`: saída (persistência JPA)

## Rodar
```bash
mvn clean test
mvn spring-boot:run
```

A API ficará em `http://localhost:8080`.

### Endpoints
- `POST /items` cria um item
- `GET /items/{id}` busca por id

Exemplo:
```bash
curl -X POST http://localhost:8080/items -H "Content-Type: application/json" -d '{"name":"Item A"}'
```

## Tratamento global de erros
Implementado via `@RestControllerAdvice` retornando `ProblemDetail`.
