package ru.skypro.hw2.course4.hw2course4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        String massage = "Неверные данные!";
        return new ResponseEntity<>(massage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
