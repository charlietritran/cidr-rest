///////////////////////////////////////////////
//
// SIMPLE SPRING MVC SWITCHING TO REST API
// REF: https://www.viralpatel.net/spring-4-mvc-rest-example-json/
//
///////////////////////////////////////////////

+ HOW TO RUN:
- Deploy the .war file to tomcat and hit: http://localhost:8085/cidr-rest/customers FOR a GET



1) Compile: mvn clean install ( generate pkg)
2) Run: Right-Click on SpringBatchApplication.java and run as: Java Application -> console will start generate log msgs
3) Invoke job: Open web browser and enter: http://localhost:8083/invokejob (default port for springboot has been updated to 8083 in application.properties)
4) View h2 DB: Ipen web browser and enter: http://http://localhost:8083/h2-console/login.do, enter db url: jdbc:h2:file:./DB and hiot connect.
5) Check to see if batch meta data tables have been created.


spring.h2.console.enabled=true
spring.datasource.platform=h2
spring.datasource.driverClassName = org.h2.Driver
spring.datasource.url=jdbc:h2:file:~/test;
spring.datasource.username=sa
spring.datasource.password=