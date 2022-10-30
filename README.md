It Bootcamp Java Test task
***************************************
Requirements
Mandatory:
     Multi-module maven project (3-tier three-module development architecture);
     Version control system - Git (The test project must be uploaded to GitHub and must be made available to the public).
     Technology:
        Java 11;
        Log4j2 as a logging system;
        Spring Boot 2 (or Tomcat 9 + Spring 5);
        Hibernate 5;
        MySQL 8.
Optional:
     Using Docker and Docker Compose to containerize a project;
     Unit and Integration tests for the application;
     Using Liquibase/Flyway for database storage.
API
    Requirements:
        Format: JSON;    
        Architectural style: REST.
        
Endpoint for adding a user:
    Main fields:
        Surname (40 characters, latin letters only);
        Name (20 characters, latin letters only);
        Middle name(40 characters, latin letters only);
        Email(50 characters, standard pattern);
        Role(Administrator, Sale User, Customer User, Secure API User).        
Endpoint to get all users:
    Main fields:
        Full name;
        Email;
        Role.
Entries should be sorted by email in alphabetical order.
Optional:
    Error processing;
    Paginate records by 10 to get users.        
