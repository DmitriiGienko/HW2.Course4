package ru.skypro.hw2.course4.hw2course4.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.skypro.hw2.course4.hw2course4.exceptions.IdNotFoundExceptions;
import ru.skypro.hw2.course4.hw2course4.model.Report;
import ru.skypro.hw2.course4.hw2course4.repository.ReportRepository;

@Service
public class ReportServiceImpl implements ReportService {

    ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public int addReport() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytesForProjections = objectMapper.writeValueAsBytes(reportRepository.getReport());
        return reportRepository.save(new Report(bytesForProjections)).getId();
    }

    @Override
    public ResponseEntity<Resource> getReportById(int id) {
        if (!reportRepository.existsById(id))
            throw new IdNotFoundExceptions();
        String fileName = "employeeReport.json";

        Resource resource = new ByteArrayResource(reportRepository.findById(id).get().getBytes());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + id + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }
}
