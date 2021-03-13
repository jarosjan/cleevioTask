# Cleevio Watch Task

Hello and welcome to my repo :hand:.

This project is for an interview purposes.

It is built on Java11, Spring, Maven and with the help of Hibernate it stores data into PostgreSQL database. There is also Lombok to make code more readable, and the code is tested by JUnit. The database runs along with pgAdmin in the docker container. Inside the project is attached a postman collection for testing purposes: `Cleevio.postman_collection.json`. The spring banner is also customized :tada:.

## To run this project you need:
1. Run `docker-compose up` in root folder of the project. It will run PostgreSQL database in docker and pgAdmin as a database editor. The database editor runs at `localhost:5050` with username `cleevio@cleevio.com` and password `cleevio`. It is not really necessary to login to run the application, but you can see the data there :metal:
   * In pgAdmin use `postgres` and `Password#42` to connect to the database.
2. After that, run the application. It should run on `localhost:8080`.

`WatchController.java` accepts JSON and also XML requests - the structure of requests are visible in postman collection. The accepted requests are configurable in `WebConfig.class`. For created new row in the database is returned code 201. In case of invalid requests is returned error code 400.

Thank you and have a nice day :star:.

JJ