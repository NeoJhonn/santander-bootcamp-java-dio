# Bootcamp Java Santander Dio

- Java RESTful API criada para Bootcamp Java Santander Dio 2024.
- Link para criação do projeto no [Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.3.1&packaging=jar&jvmVersion=17&groupId=br.com.jhonny_azevedo&artifactId=santander-bootcamp-java-dio&name=santander-bootcamp-java-dio&description=Java%20RESTfull%20API%20criada%20para%20Bootcamp%20Java%20Santander%20Dio%202024&packageName=br.com.jhonny_azevedo.bootcamp_java_dio&dependencies=web,data-jpa,postgresql,h2).
- Acesse [JSON Editor Online](https://jsoneditoronline.org/) e faça a abstração do JSON do projeto:

```
{
  "name": "Jhonny",
  "account": {
    "number": "00000-0",
    "agency": "00000-0",
    "balance": 1350.35,
    "limit": 1300.00
  },
  "features": [
    {
      "icon": "URL",
      "description": "decrição da feature"
    }
  ],
  "card": [
    {
      "number": "xxxx xxxx xxxx xxxx",
      "limit": 1000.00
    }
  ],
  "news": [
    {
      "icon": "URL",
      "description": "decrição da novidade"
    }
  ]
}
```

- No chatGPT crie os diagramas de classes usando o JSON com o seguinte pronpt:

```
Gere um diagrama de classes(usando a sintaxe Mermaid) tendo em vista o seguinte JSON que representa um 
usuário de um banco. Mantenha uma extrutura simples e fiel ao modelo que vou passar. Além disso mantenha
o nome das classes em inglês:
{
  "name": "Jhonny",
  "account": {
    "number": "00000-0",
    "agency": "00000-0",
    "balance": 1350.35,
    "limit": 1300.00
  },
  "features": [
    {
      "icon": "URL",
      "description": "decrição da feature"
    }
  ],
  "card": [
    {
      "number": "xxxx xxxx xxxx xxxx",
      "limit": 1000.00
    }
  ],
  "news": [
    {
      "icon": "URL",
      "description": "decrição da novidade"
    }
  ]
}
```

- Copie o diagrama gerado e cole usando snipped Mermaid(```mermaid):

## Diagrama de Classes com [Mermaid](https://mermaid.js.org/syntax/classDiagram.html)

```mermaid
classDiagram
    class User {
        +String name
        +Account account
        +List~Feature~ features
        +List~Card~ card
        +List~News~ news

    class Account {
        +String number
        +String agency
        +float balance
        +float limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +float limit
    }

    class News {
        +String icon
        +String description
    }

    User "1" *-- "1" Account
    User "1" *-- "N" Feature
    User "1" *-- "1" Card
    User "1" *-- "N" News
