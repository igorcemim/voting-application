# API de Votação
API para gerenciamento de sessões de votação.

## Documentação da API
https://voting-application-igorc.herokuapp.com/docs

## Como executar o projeto

### Pré-requisitos
- JDK 11 (para executar via Gradle)
- Docker e Docker Compose (para executar via Docker)

### Utilizando Docker
```sh
docker-compose up
```

### Utilizando Gradle
No Linux/Mac:
```sh
./gradlew bootRun
```
No Windows:
```sh
./gradlew.bat bootRun
```

### Executar os testes
```sh
./gradlew test
```

### Deploy com Heroku
- Fazer um fork do projeto utilizando Github.
- Criar um novo app no Heroku.
- Adicionar o addon Heroku Postgres. O Heroku configurará automaticamente as variáveis de ambiente SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME e SPRING_DATASOURCE_PASSWORD utilizadas pelo Spring para estabelecer a conexão ao banco de dados.
- Realizar o deploy do fork criado através do Github.
