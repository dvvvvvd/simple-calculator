package com.rest;

import com.rest.exception.EmptyInputException;
import com.rest.exception.InvalidInputException;
import org.hibernate.TransactionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleCalculationController.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyInputException.class)
    @ResponseBody
    public String handleEmptyInputException(HttpServletRequest request, Exception e) {
        LOGGER.error("Failed to handle request for " + request.getPathInfo());
        return "Unable to process request, not all input parameters were provided";
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    @ResponseBody
    public String handleInvalidInputException(HttpServletRequest request, Exception e) {
        LOGGER.error("Failed to handle request for " + request.getPathInfo(), e);
        return "Unable to process request, input was invalid for the requested operation";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({PersistenceException.class, TransactionException.class})
    @ResponseBody
    public String handleDatabaseException(HttpServletRequest request, Exception e) {
        LOGGER.error("Failed to handle request for " + request.getPathInfo(), e);
        return "Unable to process request, an error occurred at the database";
    }
}
