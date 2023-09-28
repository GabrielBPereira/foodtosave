# Sample Spring Boot API

This is a simple Spring Boot application, which queries objects in a Postgresql database, and stores them in a Redis cache for a period of 10 seconds.

## How to run application

Using Maven, clean and install to build app (-DSkipTests to skip tests):

`$ mvn clean install`

In root directory up all containers using Docker:

`$ docker-compose build --no-cache`

`$ docker-compose up --force-recreate`

After the previous steps, the application is ready to receive requests in Postman.
The sql initialization script populates four Affiliate type objects in the database, making it possible to perform queries via id or name.

## Controller and routes

`/affiliate/id/{id}:` Returns an affiliate by id,404 HTTP code if not registered.

`/affiliate/id/{name}:` Returns an affiliate by name, 404 HTTP code if not registered.

`/affiliate/all:` Returns all affiliates, 404 HTTP code if not registered.

## View Redis database cache

To check cached affiliates, ensure you have redis-cli installed, and follow the steps below:

`$ redis-cli`

`127.0.0.1:6379> keys *`

After 10 seconds in the cache, the keys will expire.

## Lib versions

Java 17

Postgresql: _v9.5.25_

Docker: _v20.10.7_

Redis: _v7.0.0_
