package com.rest;

import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyInputException.class)
    @ResponseBody
    public String handleEmptyInputException(HttpServletRequest request) {
        System.out.println("Failed to handle request for " + request.getPathInfo());
        return "Unable to process request, not all input parameters were provided";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    @ResponseBody
    public String handleInvalidInputException(HttpServletRequest request) {
        System.out.println("Failed to handle request for " + request.getPathInfo());
        return "Unable to process request, input was invalid for the requested operation";
    }
}
