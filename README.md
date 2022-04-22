# Movie booking API's
Author: irfan.htc40@gmail.com

A Spring boot application initialized using spring boot initializr (https://start.spring.io/)

# For live deployed version:

API URL: https://move-be.herokuapp.com/api/v1/movies

Website: https://movie-fe.herokuapp.com/


## How to run?

- Its typical spring boot app. To run this application you need java and postgres.
- Setup the env variable defined in application.properties file 

For running postgres:
- Either you can download and run directly on your machine
- Or You can use docker to run postgres image
    - pull image:  docker pull postgres
    - run container: docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres  --name postgres postgres
    - exec container: docker exec -ti postgres bash
    - for killing exit containers: docker rm $(docker ps -a -q)

Postgres (helpfull commands)
- connect to shell: psql
- psql -U postgres for login using posgres user
- \du  for list of roles
- \l for list of databases
- CREATE USER admin WITH PASSWORD 'admin';
- create database movies;
- GRANT ALL PRIVILEGES ON DATABASE "movies" to admin;
- psql -U admin -p admin // for connecting with db;
- \c movies


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
