# Pós-graduação em Backend Jr - Disciplina: Backend

## 👨‍🏫 Professor
**Rodrigo Fujioka**: 
🔗 [@fuji_bjj](https://www.instagram.com/fuji_bjj)


## 📘 Disciplina
**Backend**

Esta disciplina é uma **continuação da disciplina iniciada pelo Professor Kelson**, disponível no repositório:
🔗 [https://github.com/kelsonvictr/pos_backend_aluno_online_2025_1](https://github.com/kelsonvictr/pos_backend_aluno_online_2025_1)

Tem como objetivo avançar nos conhecimentos em desenvolvimento backend com Spring Boot, 
focando em boas práticas, validações, integração com serviços externos e testes.

---

## 📅 Cronograma de Aulas

| Data     | Tipo da Aula        | Tópicos abordados |
|----------|---------------------|-------------------|
| 10/05    | Aula Presencial     | - Apresentação<br>- Reforço: EndPoints, APIs, Verbos HTTP, Microserviços<br>- Swagger<br>- @Query<br>- Bean Validators<br>- Lombok<br>- Cache<br>- Integração com serviços externos |
| 07/06    | Aula Presencial     | - Custom Bean Validators<br>- Handle de Exceptions<br>- Geração de Testes Unitários com I.A.<br>- DTOs<br>- Spring Schedule |
| 14/06    | Aula Online (Plus)  | - Boas práticas de programação<br>- Clean Code<br>- Orientações finais |

---

## 📚 Conteúdo Programático

- REST APIs com Spring Boot
- Anotações avançadas com `@Query` e `@ControllerAdvice`
- Validações com Bean Validation e validadores customizados
- Lombok para redução de boilerplate
- DTO e mapeamento com ModelMapper
- Integração com serviços externos (ex: ViaCep)
- Spring Cache
- Agendamentos com Spring Schedule
- Geração de testes com apoio de IA
- Boas práticas e Clean Code

---

## 🧰 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.x
- Maven
- PostgreSQL / H2
- Git + GitHub
- Postman / Insomnia

---

## 📎 Organização do Repositório

Este repositório conterá:
- Exemplos práticos abordados em aula
- Exercícios complementares
- Desafios sugeridos
- Material de apoio

---

## 💬 Contato

Em caso de dúvidas ou envio de atividades:
- Utilize o Google Classroom
- Participe das aulas presenciais e online

## 📚 Materiais Complementares para Estudos

### 🔹 Testes com Spring Boot
- [Documentação oficial do Spring Boot Test](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)
- [Testando Controladores com MockMvc - Baeldung](https://www.baeldung.com/spring-mvc-test-examples)
- [MockMvc explicado (Spring Blog)](https://spring.io/guides/gs/testing-web/)
- [Spring Boot Annotations explicadas](https://www.baeldung.com/spring-annotations)

### 🔹 Mockito (Mock para testes unitários)
- [Mockito - Guia completo (Baeldung)](https://www.baeldung.com/mockito-series)
- [Mockito Quickstart](https://www.vogella.com/tutorials/Mockito/article.html)

### 🔹 Jackson e ObjectMapper
- [Conversão de objetos para JSON com Jackson](https://www.baeldung.com/jackson-object-mapper-tutorial)

---

### ⚙️ Spring Cache
- [Caching com Spring Boot - Baeldung](https://www.baeldung.com/spring-cache-tutorial)
- [Documentação Oficial - Spring Cache Abstraction](https://docs.spring.io/spring-framework/reference/integration/cache.html)
- [@Cacheable, @CacheEvict, @CachePut - explicações práticas](https://www.baeldung.com/spring-cache-annotations)

---

### 💼 Lombok
- [Lombok - Documentação oficial](https://projectlombok.org/features/all)
- [Guia rápido: @Data, @Getter, @Builder, @Slf4j e mais](https://www.baeldung.com/intro-to-project-lombok)
- [Como configurar no IntelliJ e VSCode](https://projectlombok.org/setup/overview)

---

### 🪵 Logs com SLF4J / Logback
- [Como usar SLF4J com Spring Boot](https://www.baeldung.com/spring-boot-logging)
- [Configurações avançadas com Logback](https://www.baeldung.com/logback)
- [Melhores práticas para logs de aplicações](https://sematext.com/blog/logging-best-practices/)

---

### 🔗 Integração com Feign
- [Documentação oficial do OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)
- [Guia prático - Feign com Spring Boot](https://www.baeldung.com/spring-cloud-openfeign)
- [Tratando erros e fallback com Feign](https://www.baeldung.com/spring-cloud-openfeign-error-handling)

---

### ❌ Handler de Exceptions
- [Tratamento Global com @ControllerAdvice](https://www.baeldung.com/exception-handling-for-rest-with-spring)
- [ResponseEntityExceptionHandler explicado](https://www.baeldung.com/spring-boot-exception-handling)
- [Boas práticas para mensagens de erro em APIs REST](https://reflectoring.io/spring-boot-exception-handling/)

---

### ✅ Bean Validation (javax.validation)
- [Validações com Bean Validation (JSR-380)](https://www.baeldung.com/javax-validation)
- [Validações personalizadas com @Constraint](https://www.baeldung.com/spring-custom-validation)
- [Spring Boot + DTO + Validation](https://www.baeldung.com/spring-boot-bean-validation)

---

### ⏰ Spring Schedule (Tarefas agendadas)
- [Agendamento com @Scheduled](https://www.baeldung.com/spring-scheduled-tasks)
- [Cron com Spring Schedule](https://www.baeldung.com/spring-scheduled-tasks#cron-expressions)
- [Documentação oficial do Spring](https://docs.spring.io/spring-framework/reference/integration/scheduling.html)

---

### 🧼 Boas Práticas de Desenvolvimento e Clean Code
- [Guia de Clean Code com exemplos Java - Baeldung](https://www.baeldung.com/java-clean-code)
- [Resumo do livro Clean Code (Robert C. Martin)](https://github.com/JuanCrg90/Clean-Code-Notes)
- [Refatoração com foco em legibilidade](https://dev.to/ryanlanciaux/refactoring-with-clean-code-principles-in-java-5b6n)
- [Princípios SOLID explicados](https://www.baeldung.com/solid-principles)

---

### 🔄 ModelMapper (DTO x Entidades)
- [Documentação oficial do ModelMapper](http://modelmapper.org/)
- [Spring Boot + ModelMapper – Exemplo completo](https://www.baeldung.com/java-modelmapper)
- [Por que usar DTO e como mapear com ModelMapper](https://www.javaguides.net/2022/06/modelmapper-in-spring-boot.html)

---

### 🧮 Spring Data JPA
- [Spring Data JPA - Documentação oficial](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [JPQL vs Métodos derivados - Baeldung](https://www.baeldung.com/spring-data-derived-queries)
- [Como usar @Query e parâmetros nomeados](https://www.baeldung.com/spring-data-jpa-query)
- [Referência de palavras-chave para queries Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)


---
_Gerado em 10/05/2025_
