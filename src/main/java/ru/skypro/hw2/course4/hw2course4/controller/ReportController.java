package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.hw2.course4.hw2course4.service.ReportServiceImpl;

@RestController
@RequestMapping("/report")
public class ReportController {
    ReportServiceImpl reportService;

    public ReportController(ReportServiceImpl reportService) {
        this.reportService = reportService;
    }

    @PostMapping(value = "/report")
    public int createReport() {

        return reportService.addReport();
    }

    @GetMapping(value = "/report/{id}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getEmployeeInfoById(@RequestParam int id) {
        return reportService.getReportById(id);
    }



}
