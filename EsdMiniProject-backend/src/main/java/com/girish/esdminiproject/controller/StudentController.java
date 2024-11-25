package com.girish.esdminiproject.controller;

import com.girish.esdminiproject.dto.StudentDetails;
import com.girish.esdminiproject.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<StudentDetails> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/specialization/{specilization}")
    public List<StudentDetails> getStudents(@PathVariable("specilization") String specilization) {
        return studentService.getStudents(specilization);
    }
    @GetMapping("/domain/{domain}")
    public List<StudentDetails> getStudentsWithDomainName(@PathVariable("domain") String domain) {
        return studentService.getStudentsWithDomainName(domain);
    }
    @GetMapping("/calculate")
    public ResponseEntity<String> CalculateStudentSpecialization() {
        return ResponseEntity.ok(studentService.CalculateStudentSpecialization());
    }
}
