# simple-calculator

## Prerequisites
Java 11 <br/>
Maven <br/>
Docker <br/>

## Overview

This project implements a REST API for a Simple Calculator deployed using a servlet. The servlet is deployed on a dockerized Tomcat server. The API accepts a list of (JSON) calculation objects as the request body. 

A dockerized MySQL database is also deployed when you run the application. Calculations sent over the API are persisted in the database in the schema called "public" and the table called "SIMPLE_CALCULATION". You can access the database on port 8100. Username is "root" and password is "rootpassword".

The following (POST) endpoints are exposed:

{host}/my-simple-calculator/calculation <br/>

(host is http://localhost:8080 when deployed using the Docker container).

Example of request body (JSON):

```json
[
    {
        "rightHand": 1,
        "leftHand": 1,
        "operator": "ADD"
    },
        {
        "rightHand": 1,
        "leftHand": 1,
        "operator": "SUBTRACT"
    },
        {
        "rightHand": 1,
        "leftHand": 1,
        "operator": "DIVIDE"
    },
    {
        "rightHand": 1,
        "leftHand": 1,
        "operator": "MULTIPLY"
    }
]
```

Response (JSON):

```json
[
    {
        "result": 2.0
    },
    {
        "result": 0.0
    },
    {
        "result": 1.0
    },
    {
        "result": 1.0
    }
]
```

## Running the application

Simply run the "run.sh" shell script to compile, test, package and deploy the application.
