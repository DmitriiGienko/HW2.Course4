package ru.skypro.hw2.course4.hw2course4.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class EmployeeExceptionHandler {
    // Метод обработки исключений IOException.
    // Срабатывает, когда в контроллере возникает IOException.
    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {
        // Возвращает статус 404 (Not Found) при возникновении IOException.
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    // Метод обработки исключений SQLException.
    // Срабатывает, когда в контроллере возникает SQLException.
    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        // Возвращает статус 500 (Internal Server Error)
        // при возникновении SQLException.
        String massage = "Файл не обнаружен!";
        return new ResponseEntity<>(massage, HttpStatus.BAD_GATEWAY);
    }

    // Метод обработки исключений Exception.
    // Срабатывает, когда в контроллере возникает Exception.
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        // Возвращает статус 403 (Forbidden) при возникновении Exception.
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
