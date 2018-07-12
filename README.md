# customermanagement
Managing the customer profile of an organisation.

This spring-boot application provides REST API interface for customer management operations like Create, Update, Delete and Get.

API contract Definition: rjavaria_CUST_PROFILE_OAS3.0_v1_swagger.yaml

API Interface:  au.com.rjavaria.profile.customer.api.CustomersApi

## Request Headers
Accept : application/json

Content-Type : application/json

Authorization Type : Basic Auth
  - username : rajesh
  - password : pass123

## Create Customer API
URI : localhost:9089/customers/

HTTP Method : POST

Json Request Body :
```json
{
  "accountid": "rjavaria",
  "firstname": "Rajesh",
  "lastname": "Javaria",
  "title": "Mr.",
  "dob": "01/01/1985",
  "email": "rajesh.javaria@gmail.com",
  "homeaddress": {
    "street": "21, Best Road",
    "suburb": "Seven Hills",
    "postcode": 2147,
    "state": "NSW"
  },
  "officeaddress": {
    "street": "21, Best Road",
    "suburb": "Seven Hills",
    "postcode": 2147,
    "state": "NSW"
  }
}
```

## Update Customer API
URI : localhost:9089/customers/{accountid}

HTTP Method : PUT

Json Request Body :
```json
{
  "accountid": "rjavaria",
  "firstname": "Rajesh",
  "lastname": "Javaria",
  "title": "Mr.",
  "dob": "01/01/1985",
  "email": "rajesh.javaria@gmail.com",
  "homeaddress": {
    "street": "88, Best Road",
    "suburb": "Seven Hills",
    "postcode": 2147,
    "state": "NSW"
  },
  "officeaddress": {
    "street": "21, Best Road",
    "suburb": "Seven Hills",
    "postcode": 2147,
    "state": "NSW"
  }
}
```

## Delete Customer API
URI : localhost:9089/customers/{accountid}

HTTP Method : DELETE

## Get Customer API
URI : localhost:9089/customers/{accountid}

HTTP Method : GET

##	Integration:
The integration and deployment of APIs can be well managed by API Management platforms like Apigee, Axway etc. APIs can be integrated in Cloud, Hybrid environment or at on-premises by one of these APIs management service.

AWS API Gateway is another easiest way to integrate/deploy micro services exposing REST APIs. AWS API Gateway also provides proxy integration with AWS Lambda, we can simply upload Spring Boot Application to Lambda, and create AWS Lambda function to trigger this Spring -boot application. 

aws-serverless-java-container supports API Gateway's proxy integration models for requests and responses makes easy to run Spring-boot applications. This library receives events object from Lambda and translates them to a request object for the spring boot framework. Similarly, it translates responses from the framework into valid return values for API Gateway.


##	Security:
Customer APIs code which is checked in to Git using Basic Authentication. 

APIs security must be approached from the APIs consumption and exposure perspectives. 
Authentication of trusted Apps can be implemented using API key(client credentials) or Basic Authentication. 

Authentication of Untrusted Apps can be implemented using Two-way TLS(MASL) or OpenID connect. 

Other Authentication mechanism can be LDAP, Active directory or persisting client credentials in database. 

APIs should also be protected from Rate-limiting(throttling) and DDoS attacks.

Authorization that could be Granting access to resources and allowing some certain actions should be implemented using oAuth2.0. 
