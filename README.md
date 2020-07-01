# LocadoraSpringBoot
Projeto Spring Boot para criação dos testes unitários e bug report

# Instruções para execução

Execute o ```run``` na classe ApiProductApplication.java

# API REST rotas para teste

**GET** requisições para ```http://localhost:8080/product``` retorna uma lista de produtos em formato JSON

**GET** requisições para ```http://localhost:8080/product/1``` retorna o produto com o ID 1

**POST** requisições para ```http://localhost:8080/product``` com um objeto produto JSON cria um novo produto

**PUT** requisições para ```http://localhost:8080/product/1``` com um objeto produto JSON atualiza o produto com ID 1

**DELETE** requisições para ```http://localhost:8080/product/1``` deleta o produto com ID 1

e possível também realizar o teste de cada uma dessa rotas acessando a interface do swagger ```http://localhost:8080/swagger-ui.html```

# Banco de dados H2

Essa API simples utiliza o banco de dados em memoria local H2 que e inicializado junto com a aplicação e pode ser acessada através do link  ```http://localhost:8080/h2-console```