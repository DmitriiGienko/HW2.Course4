package ru.skypro.hw2.course4.hw2course4.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    private static final String massage = "Сотрудник не найден, проверьте ID";

    public EmployeeNotFoundException() {
        super(massage);
    }
}
