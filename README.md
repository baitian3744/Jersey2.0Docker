Jersey2-Spring4-Servlet-3-Spock
===============================

Jersey2-Spring4-Servlet-3-Spock : 

Objective :To Demonstrate a Spring application 
            a) without application.xml and to use JavaConfig 
            b) without web.xml ,use servlet 3.0 spec  
            c) Make use of Spock for Testing

Stack used :

Jersey 2.0
Spring 4.0.1
Spock 0.7



Steps
---------

1.Import the project and run mvn clean  jetty:run

this would fire up the Jersey Service on local
you can now use curl or any browser extension to point the resources
 

GET http://localhost:8080/resources/application.wadl
    
    to get all the resources under this service
GET http://localhost:8080/resources/ping 
    
    to test whether app is working or not

GET http://localhost:8080/resources/employees 

    to give all the hardcoded employees
    
GET http://localhost:8080/resources/employees/111 
   to drill down to single employee