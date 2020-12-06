# simple-calculator

Prequisites:
Java 11
Maven
Docker

This project runs a simple REST API implementing a Simple Calculator. The servlet is hosted on a Tomcat server deployed in a Docker container.

The following (POST) endpoints are exposed:

{host}/my-simple-calculator/calculation/add
{host}/my-simple-calculator/calculation/divide
{host}/my-simple-calculator/calculation/multiply
{host}/my-simple-calculator/calculation/subtract

(host is http://localhost:8080 when deployed using the Docker container).

Example of request body (JSON):

{
  "leftHand": 1
  "rightHand": 2
}

Simply run the "run.sh" to compile, package and deploy the application.
