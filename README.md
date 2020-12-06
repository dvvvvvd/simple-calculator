# simple-calculator

## Prerequisites
Java 11 <br/>
Maven <br/>
Docker <br/>

## Overview

This project implements a REST API for a Simple Calculator. The servlet is hosted on a Tomcat server deployed in a Docker container.

The following (POST) endpoints are exposed:

{host}/my-simple-calculator/calculation/add <br/>
{host}/my-simple-calculator/calculation/divide <br/>
{host}/my-simple-calculator/calculation/multiply <br/>
{host}/my-simple-calculator/calculation/subtract <br/>

(host is http://localhost:8080 when deployed using the Docker container).

Example of request body (JSON):

```json
{
  "leftHand": 1,
  "rightHand": 2
}
```

## Running the application

Simply run the "run.sh" shell script to compile, test, package and deploy the application.
