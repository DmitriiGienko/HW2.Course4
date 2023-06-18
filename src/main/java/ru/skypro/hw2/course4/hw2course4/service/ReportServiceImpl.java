package ru.skypro.hw2.course4.hw2course4.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.dto.EmployeeDTO;
import ru.skypro.hw2.course4.hw2course4.model.Report;
import ru.skypro.hw2.course4.hw2course4.repository.ReportRepository;

import java.nio.charset.StandardCharsets;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @SneakyThrows
    public int addReport() {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytesForProjections = objectMapper.writeValueAsBytes(reportRepository.getReport());
        return reportRepository.save(new Report(bytesForProjections)).getId();
    }

    @SneakyThrows
    public ResponseEntity<Resource> getReportById(int id) {
        String fileName = "employeeReport.json";

        Resource resource = new ByteArrayResource(reportRepository.findById(id).get().getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + id + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}
