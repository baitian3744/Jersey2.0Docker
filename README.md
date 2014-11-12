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

Chrome Testing
-----------------
Here is a Link to POSTMAN extension of Chrome. 
a)Install Chrome
b)Install POSTMAN Extension
c)Import the collection from https://www.getpostman.com/collections/3c9feea2521a7c713cbe

 
 Testing via CMD Prompt
-------------------------



 1. curl http://localhost:8080/application.wadl
    
    to get all the resources under this service
    
 2. curl http://localhost:8080/ping 
    
    to test whether app is working or not

 3. curl http://localhost:8080/employees 

    to give all the  employees which should be Empty for the first time
    
 4. curl -H  "Accept: application/json" -H "Content-Type: application/json" -d "{
                                                                                    "employees": [
                                                                                        {
                                                                                            "name": {
                                                                                                "fname": "harry"
                                                                                            },
                                                                                            "age": 21,
                                                                                            "mailingAddress": {
                                                                                                "addressline1": "FL",
                                                                                                "addressline2": "KOL",
                                                                                                "city": "DOCA",
                                                                                                "state": "FL",
                                                                                                "country": "US",
                                                                                                "pinCode": 2220
                                                                                            }
                                                                                        }
                                                                                    ]
                                                                                }" -X POST http://localhost:8080/employees  | python -mjson.tool
     To create the employees for first time
    
 5. curl http://localhost:8080/employees/1 
    to drill down to single employee
 
 6. curl -H  "Accept: application/json" -H "Content-Type: application/json" -d "{
                                                                                    \"name\": {
                                                                                        \"fname\": \"harry C\"
                                                                                    },
                                                                                    \"age": \"21\",
                                                                                    \"mailingAddress\": {
                                                                                        \"addressline1\": "FL",
                                                                                        \"addressline2\": "KOL",
                                                                                        \"city\": \"DOCA\",
                                                                                        \"state\": \"FL\",
                                                                                        \"country\": \"US\",
                                                                                        \"pinCode\": 2220
                                                                                     },
                                                                                    \"id\": 2
                                                                                }"-X POST http://localhost:8080/employees/1  | python -mjson.tool