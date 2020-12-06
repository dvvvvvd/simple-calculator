# simple-calculator

Prequisites: <br/>
Java 11 <br/>
Maven <br/>
Docker <br/>

This project runs a simple REST API implementing a Simple Calculator. The servlet is hosted on a Tomcat server deployed in a Docker container.

The following (POST) endpoints are exposed:

{host}/my-simple-calculator/calculation/add <br/>
{host}/my-simple-calculator/calculation/divide <br/>
{host}/my-simple-calculator/calculation/multiply <br/>
{host}/my-simple-calculator/calculation/subtract <br/>

(host is http://localhost:8080 when deployed using the Docker container).

Example of request body (JSON):

{
  "leftHand": 1
  "rightHand": 2
}

Simply run the "run.sh" to compile, package and deploy the application.
