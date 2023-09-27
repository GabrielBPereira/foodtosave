FROM postgres:13.1-alpine
COPY ./sql/create_table.sql /docker-entrypoint-initdb.d/

FROM openjdk:17
ADD ./target/foodtosave-0.0.1-SNAPSHOT.jar /usr/src/foodtosave-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "foodtosave-0.0.1-SNAPSHOT.jar"]