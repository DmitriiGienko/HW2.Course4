package ru.skypro.hw2.course4.hw2course4.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.skypro.hw2.course4.hw2course4.service.EmployeeServiceImpl;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        logger.error("Введены неверные данные!");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Введены неверные данные!");
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EmployeeNotFoundException e) {
        logger.error("Id не найден!)");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Id не найден!");
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        logger.error("BAD_REQUEST");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundExceptions.class)
    public ResponseEntity<?> handleNotFound(IdNotFoundExceptions e) {
        logger.error("Id не найден!)");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Id не найден!");
    }
}
