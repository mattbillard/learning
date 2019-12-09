# Miscellaneous features from various tutorials
11/2019

Generated with Spring Initializr 
- Spring Web

- Spring Data JPA
- Rest Repositories
- H2 Database
- MySQL Driver
- Postgres Driver
- Spring Data Elasticsearch (Access+Driver)
- Spring Cache Abstraction

- Thymeleaf
- Spring Security

- Spring Boot Actuator 
- Spring Boot DevTools
- Lombok


## Features in this project
- Devtools / hot reloading 
  - (This also adds H2 console at http://localhost:8080/h2-console/, with   jdbc_url=jdbc:h2:mem:testdb, user=sa, password=(blank))
- Actuator
- CommandLineRunner
- Lazy initialization
- Static files - webapp directory
- Error pages
- Login / Security (Disabled b/c it's annoying for development. Uncomment in pom.xml and WebSecurityconfig.java)
- WAR packaging
- REST controller
- Databases - H2 database, JPA / REST Repository, MySQL, PostgreSQL
- ElasticSearch 
- Caching
- Lombok (code generation)
- Docker 


## Requirements
- Java v1.8 
- MySQL v8.0.18 - `brew install mysql`
- PostgreSQL v11.5 - `brew install postgres`
- Elasticsearch v7.4.2
- Docker v19.03.5 - https://download.docker.com/mac/stable/Docker.dmg


## Set up
### MySQL
  Run the following 
  ```
  mysql.server start
  mysql -u root
  drop database testdb;
  create database testdb;
  create user 'myuser'@'%' identified by 'mypass';
  grant all on testdb.* to 'myuser'@'%';
  ```

### PostgreSQL (Ready but not currently used by this project. You'd have to comment out MySQL and uncomment PostgreSQL in pom.xml and application.properties. Also update docker-compose.yaml)
  Run the following 
  ```
  brew services start postgresql
  psql postgres
  drop database if exists testdb;
  create database testdb;
  create user myuser with encrypted password 'mypass';
  grant all privileges on database testdb to myuser;
  \l
  ```


## Elasticsearch
  Make sure Elasticsearch is installed
  From the directory you installed it to, run 
  ```
  ./elasticsearch
  ```


## Run 
- Option 1 
    - Start MySQL
      ```
      mysql.server start
      ```
    - Start Elasticsearch 
      ```
      cd PATH/TO/ELASTICSEARCH/BIN
      ./elasticsearch
      ```
    - Then run
      ```
      mvn spring-boot:run
      ```
- Option 2 - with Docker installed, run 
  ```
  docker-compose up
  ```
  Shut down is 
  ```
  docker-compose down -v
  ```



## Try it out

  ## Visit these
  http://localhost:8080/
  http://localhost:8080/books
  http://localhost:8080/api/v1/books?size=10&page=0&sort=description,asc  
  http://localhost:8080/h2-console
  http://localhost:8080/public/test.js
  http://localhost:8080/does-not-exist
  http://localhost:8080/actuator/health


  ## Database
  // Generate, CRUD, list, page, deleteAll
  curl -i -X GET    http://localhost:8080/api/v1/books/generate/3
  curl -i -X POST   http://localhost:8080/api/v1/books -H "Content-Type: application/json" -d '{"title":"aaa"}'
  curl -i -X GET    http://localhost:8080/api/v1/books/DOCUMENT_ID
  curl -i -X PUT    http://localhost:8080/api/v1/books -H "Content-Type: application/json" -d '{"title":"bbb", "id":"DOCUMENT_ID"}'
  curl -i -X DELETE http://localhost:8080/api/v1/books/DOCUMENT_ID
  curl -i -X GET    http://localhost:8080/api/v1/books
  curl -i -X GET    http://localhost:8080/api/v1/books?page=0&size=5&sort=title,asc
  curl -i -X GET    http://localhost:8080/api/v1/books/delete-all


  ## JPA REST Repository
  FYI, you can access the Authors with no controller required b/c it is a JPARepository
  Get, post, put, patch, and delete work

  curl -X POST      http://localhost:8080/authors -H "Content-Type:application/json" -d '{"firstName": "Bilbo", "lastName": "Baggins"}'
  curl -i -X GET    http://localhost:8080/authors



  ## Elasticsearch
  // App - search
  http://localhost:8080/api/v1/books/search?search=non

  // Elasticsearch - list
  http://localhost:9200/book_index/book_type/_search?pretty
