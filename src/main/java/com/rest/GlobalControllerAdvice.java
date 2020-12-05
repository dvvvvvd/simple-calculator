package com.rest;

import com.rest.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyInputException.class)
    @ResponseBody
    public String handleEmptyInputException(HttpServletRequest request) {
        System.out.println("Failed to handle request for " + request.getPathInfo());
        return "Unable to process request, not all input parameters were provided";
    }
}
