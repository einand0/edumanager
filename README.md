# EduManager

## 📖 Descrição
**EduManager** é um sistema de gerenciamento de cursos online desenvolvido em **Java** com **Spring Boot** e **JPA/Hibernate**.  
O projeto permite cadastrar **alunos, professores, cursos** e gerenciar **matrículas**, incluindo relações complexas como **Many-to-Many** entre alunos e cursos.

Este projeto foi feito para estudo de **relacionamentos JPA**, **API REST** e **banco de dados em memória H2**.

---

## 🛠 Tecnologias utilizadas
- Java 21
- Spring Boot 3.x  
- Spring Data JPA  
- H2 Database (em memória)  
- Maven  
- Lombok (para reduzir boilerplate)  

---

## 📦 Estrutura do projeto

com.einando.edumanager

│
├── entity → entidades JPA (Student, Teacher, Course, Enrollment)

├── repository → interfaces JpaRepository

├── service → lógica de negócio

├── controller → endpoints REST

├── dto → Data Transfer Objects (para requests/responses)


---

## ⚡ Funcionalidades
1. Cadastrar alunos, professores e cursos  
2. Matricular alunos em cursos (Many-to-Many via Enrollment)  
3. Listar cursos de um aluno  
4. Listar alunos de um curso  

---

## 🏁 Setup do projeto

### 1. Clonar o repositório
```bash
git clone <URL_DO_REPOSITORIO>
cd edumanager
```
### 2. Build com Maven
```
mvn clean install
```
### 3. Rodar a aplicação
```
3. Rodar a aplicação
```
4. Acessar H2 Console

 URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Usuário: sa

Senha: (vazio)
