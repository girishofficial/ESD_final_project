package com.girish.esdminiproject.controller;

import com.girish.esdminiproject.dto.EmployeeRequest;
import com.girish.esdminiproject.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }


}

