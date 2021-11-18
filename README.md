# arquitetura-software-microservicos
Repositório referentex a prova da disciplina de Arquitetura de Software do curso de Sistemas de Informação - UNIFACISA ministrada pelo professor Daniel Abella.

# Nome do Projeto

SGE - Siste de Gestão de Eventos

# Projetos/Sistemas Relacionados

* [API SGE](https://github.com/luan-alencar/arquitetura-software-microservicos)


# Sistema

TODO completar informações

O SGE é um sistema desenvolvido orientado a microserviços para gerenciar a gestão de eventos de uma determinada região

## Postgres

O banco de dados da solução é o Postgres.

## Elasticsearch

Banco de dados não relacional, utilizado para criar documentos para realização de buscas mais performática envolvendo um número maior de tabelas:


### Indexação

A indexação principal é iniciada a partir da classe ElasticsearchReindexResource dentro do usuarioservice:

GET <host-da-aplicação>/acessoservice/api/elasticsearch/reindex

## Serviços

Os serviços da solução são APIs REST utilizadas para consumo e geração de dados dentro dos modelos. Todas as regras negociais são controladas por eles.

### Acessoservice

É o serviço responsável por gerenciar usuários, regras de negócio e persistencia de dados.

### Documentservice

O Documentservice, que está no repositório da API, deve ser utilizado para fazer as requisições a partir do Feign para armazenar dentro de buckets diversos Document Objects com minIO.


## Compose dos containers

Vá na pasta docker e execute:

```
docker-compose -f docker-compose-dev.yml up -d
```
Os containers serão montados e estarão prontos.

Em casos de ser necessário refazer/recria-las todas tabelas e apagar os dados da base execute:

```
docker-compose -f docker-compose-dev.yml down
```

e depois suba novamente.

Ou então:

```
docker-compose -f docker-compose-dev.yml up -d --force-recreate
```



## Serviços:

Os serviços são compilados com o maven:

```
    mvn clean install -DskipTests    
```