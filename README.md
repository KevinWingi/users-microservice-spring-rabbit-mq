This project is an example of **asynchronous communication** between microservices using **Rabbit MQ** and leveraging the **Broker pattern**.

This users microservice is responsible for creating a new user (inserting into the database) and then producing (Producer) the email structure and sending it to the Broker.

[Another microservice](https://github.com/KevinWingi/emails-microservice-spring-sendgrid-rabbit) will be responsible to consume (Consumer) this broker email content and send it

# Endpoint to create a new user
- `POST` **`{api}`**/users

# Tools:
- Java 17
- Spring Data JPA
- Spring Boot
- Rabbit MQ
- [CloudAMQP](https://cloudamqp.com/) for managing Rabbit MQ servers in the CLOUD.

# Docker 
- [Docker Image](https://hub.docker.com/repository/docker/kevinwingi/users-ms/general)
