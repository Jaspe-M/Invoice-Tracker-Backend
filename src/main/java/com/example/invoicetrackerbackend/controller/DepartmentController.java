package com.example.invoicetrackerbackend.controller;

import com.example.invoicetrackerbackend.dto.UpdateBudgetRequest;
import com.example.invoicetrackerbackend.entity.Department;
import com.example.invoicetrackerbackend.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{id}/budget")
    public Department updateBudget(
            @PathVariable Long id,
            @RequestBody UpdateBudgetRequest request
    ) {
        return departmentService.updateBudget(id, request.budget());
    }
}