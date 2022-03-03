## INSTRUÇÕES

#### Requisitos

- Você deverá ter o [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) ou superior instalado no seu PC;
- Utilize o [Intellij IDEA Community](https://www.jetbrains.com/pt-br/idea/download/#section=windows) para rodar a aplicação;
- Você deve ter o [MySQL 8 ou superior](https://dev.mysql.com/downloads/installer/) instalado no seu PC;
- Crie um banco de dados com o nome **db_fiap** no MySQL;
- Edit o arquivo `applications.properties` e garanta que o **username** e **password** correspondem ao seu banco de dados, conforme o exemplo abaixo:

`spring.datasource.username=seu_user_name`

`spring.datasource.password=sua_senha`

**Dica:** geralmente o username do MySQL é **root**

Quando você rodar a aplicação pela primeira vez, as tabelas serão criadas no banco de dados :smile:


#### Insira dados na tabela role

Após a primeira execução você deverá inserir dados na tabela role, então, digite o seguinte comando no seu editor SQL preferido:

`INSERT INTO role VALUES(1, 'ROLE_ADMIN');`

`INSERT INTO role VALUES(2, 'ROLE_USER');`



Pronto, seu backend está configurado e funcionando. Aproveite!! :rocket:

