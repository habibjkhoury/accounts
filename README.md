# TRANSFER

-  an API to be used for transfer from one account to another .

`/api/v1/account/transfer`

*Once the endpoint is called, a transfer request will be initiated from one account to another.*


-  Another Endpoint will output the user information showing id, iban, and balance of the account.

`api/v1/account/{id}`

## other details:

- configured docker-compose and Dockerfile to be able to build a docker image of the application using this command:

`docker-compose up`

- swagger documentation which can be accessed using the below endpoint:

`/swagger-ui.html`

- the application can be started by running the maven command `mvn spring-boot:run`

- H2 in memory database with data inserted on startup as below:

> `insert into account(ID, IBAN, BALANCE) VALUES (1, 123, 100);`
> 
> `insert into account(ID, IBAN, BALANCE) VALUES (2, 456, 200);`
