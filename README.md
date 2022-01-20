# onlineshop-web

Datasource:
docker run --name onlineshop_container -p 5431:5432 --env POSTGRES_PASSWORD=postgres --env POSTGRES_USER=postgres --env POSTGRES_DB=postgres --name onlineshop-db postgres:10w

or

docker run -p 5432:5432 --env POSTGRES_PASSWORD=demo --env POSTGRES_USER=demo --env POSTGRES_DB=demo --name demo-db postgres:10

## Create database tables 

To create the tables for customer and items execute 'create-db.sql' found in the resources directory.