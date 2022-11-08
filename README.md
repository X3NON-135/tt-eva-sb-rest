# REST application build with SpringBoot
Simple app to give opportunities for users to filter data with corresponding name filters. 
## App with layered structure
* Layer of controller. Main endpoints to communicate with back-end.
* Layer of service. Doing business logic.
* Layer of repository. Communication with database. 

## Stack of technologies
- Java 11
- Spring Boot 2.7.5
- JPA (Hibernate)
- Lombok
- MySQL/PostgreSQL

## How to use
1. Fork this repo
2. Clone to your IDE project
3. To connect your DB, set up ```application.properties``` in /main/resources
4. Open any web-browser and send request as http://localhost:port/shop/product?nameFilter=...