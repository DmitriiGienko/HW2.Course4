package ru.skypro.hw2.course4.hw2course4.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.exceptions.IdNotFoundExceptions;
import ru.skypro.hw2.course4.hw2course4.model.Report;
import ru.skypro.hw2.course4.hw2course4.repository.ReportRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepository reportRepository;

    private static final Logger logger = LoggerFactory.getLogger(PositionServiceImpl.class);

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public int addReport() throws IOException {
        logger.info("Вызван метод создания доклада");
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytesForProjections = objectMapper.writeValueAsBytes(reportRepository.getReport());
        String fileName = "fileReport.txt";
        Path path = Paths.get(fileName);
        Files.write(path, bytesForProjections);
        logger.debug("Доклад создан");
        return reportRepository.save(new Report(path.toString())).getId();

    }

    @Override
    public ResponseEntity<Resource> getReportById(int id) {
        if (!reportRepository.existsById(id))
            throw new IdNotFoundExceptions();

        logger.info("Вызван метод получения доклада по id {}", id);
        Path path = Paths.get(reportRepository.findById(id).get().getFilePath());
        try {
            byte[] bytes = Files.readAllBytes(path);
            String fileName = "employeeReport.json";
            Resource resource = new ByteArrayResource(bytes);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + id + "\"")
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(resource);
        } catch (IOException ioException) {
            ioException.getCause();
            return null;
        }
    }

}
