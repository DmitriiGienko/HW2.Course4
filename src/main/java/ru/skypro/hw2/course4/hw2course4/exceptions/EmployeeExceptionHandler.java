package ru.skypro.hw2.course4.hw2course4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Введены неверные данные!");
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleNotFound(EmployeeNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Id не найден!");
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdNotFoundExceptions.class)
    public ResponseEntity<?> handleNotFound(IdNotFoundExceptions e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Id не найден!");
    }
}
