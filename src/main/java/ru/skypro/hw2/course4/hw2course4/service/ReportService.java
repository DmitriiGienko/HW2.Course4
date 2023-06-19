package ru.skypro.hw2.course4.hw2course4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface ReportService {

    int addReport() throws IOException;

    ResponseEntity<Resource> getReportById(int id);
}
