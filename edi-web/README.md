Pré-requisitos para instalação:
1. Ter instalado em sua máquina um servidor de aplicação JavaEE, preferencialmente WildFly10 (o utilizado no desenvolvimento)

2. Ter instalado o MySqlServer e o mysql workbench (workbench não obrigatório)

3. Jdk 8 instalado

4. Ter o Maven configurado

Passos para instalar a aplicação:

1. Inserir em seu datasource o código abaixo:

<datasource jta="true" jndi-name="java:jboss/datasources/ediDS" pool-name="ediDS" enabled="true" use-java-context="true">
    <connection-url>jdbc:mysql://localhost:3306/EDI?useSSL=false</connection-url>
    <driver>mysql</driver>
    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
    <pool>
        <min-pool-size>5</min-pool-size>
        <max-pool-size>10</max-pool-size>
        <prefill>true</prefill>
    </pool>
    <security>
        <user-name>root</user-name>
        <password>root</password>
    </security>
    <statement>
        <prepared-statement-cache-size>32</prepared-statement-cache-size>
        <share-prepared-statements>true</share-prepared-statements>
    </statement>
</datasource>

3. Criar o módulo do mysql, com o jar (estará anexo no email) de conexão para o Banco.

4. Criar uma base de dados com o nome EDI: 
create database EDI charset utf8;

5. Executar os scripts sql abaixo:
INSERT INTO `EDI`.`INSTITUITION`(`id`,`name`)VALUES(1,'X');
INSERT INTO `EDI`.`INSTITUITION`(`id`,`name`)VALUES(2,'Y');


6. Testes das funcionalidades:
Os testes forma executados pelo Postman através das seguintes urls:

6.1 busca transações:
http://localhost:8080/edi-web/transaction/x

6.2 Insere transações
http://localhost:8080/edi-web/transaction
{
	"nameInstituitionSender":"X",
	"nameInstituitionReceived":"Y",
	"transactionList":["TED0114004851Antonio Alves da Silva        54561747150003256924032017"]
}