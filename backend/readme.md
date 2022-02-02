Steps:

1.Check java8 installed or not
java -version
2.Check maven installed or not
mvn --version
3. Run below command for build
mvn clean install
4. Run application using below command
cd <APP_DIR>/target
java -java credit-card-services-<verson>.jar
5.Check application is up and running 
http://localhost:8080/swagger-ui/

Functionality.

1) Create Credit Type 1 or 2

http://localhost:8080/creditCardType

2) Fetch all credit card types

http://localhost:8080/creditCardTypeList

3) Apply credit card using creditcard type id customer details

http://localhost:8080/custCreditCardApplication

2) Fetch all customer and status of the application

http://localhost:8080/custCreditCardApplication

