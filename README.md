# movie-booking

## Tech stack 
+ Spring boot 
+ MongoDB 
+ Docker - Docker compose



## API docs `/v1/api` 

+  Customer 
    + GET `/customers` : queries all customer 
    + GET `/customers/id`: queries the customer wiht mongo object id 
    + POST `/customers` : save customer record json
    + DELETE `customers/id`: delete the customer by mongo object id 
    + GET : `customers/search/findByEmail?email=hienminhnguyen711@gmail.com`: find customer by customer id 





## How to run 
+ Locally

+ Docker container 
    + `docker-compose up`
    + Attach bash to the running Mongo container 
        + `docker exec -i -t springboot-mongo /bin/bash`
    
    
    
   

    
    
    
#### Basic commands to run with mongoDB 
+ `show dbs`
+ `use dbbasename`
+ `show collections`
+ `db.movie.find()`



 