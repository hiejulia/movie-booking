<a href="https://www.buymeacoffee.com/hientech" target="_blank"><img src="https://img.shields.io/badge/-buy_me_a%C2%A0coffee-gray?logo=buy-me-a-coffee" alt="Buy Me A Coffee"></a>
  <br>
# movie-booking

## Project overview 
+ Simle content management and media sharing tool



## Tech stack 
+ Spring boot
+ Restful API 
    + CORS
    + Spring data with mongoDB repositories
    + Spring security   
+ MongoDB 
+ Docker - Docker compose
+ Testing : JUnit/Mockito/MockMVC/AssertJ/Hamcrest 
+ Java 8 





## API docs `/v1/api` 

+  Customer 
    + GET `/customers` : queries all customer 
    + GET `/customers/id`: queries the customer wiht mongo object id 
    + POST `/customers` : save customer record json
    + DELETE `customers/id`: delete the customer by mongo object id 
    + GET : `customers/search/findByEmail?email=hienminhnguyen711@gmail.com`: find customer by customer id 





## How to run 
+ Locally
    + `mvn spring-boot:run`
+ Docker container 
    + `docker-compose up`
    + Attach bash to the running Mongo container 
        + `docker exec -i -t springboot-mongo /bin/bash`
    
    
    
    
+ Swagger API docs 
    + Open Swagger API doc : `localhost:8080/swagger-ui.html`
   

    
    
    
#### Basic commands to run with mongoDB 
+ `show dbs`
+ `use dbbasename`
+ `show collections`
+ `db.movie.find()`



 
