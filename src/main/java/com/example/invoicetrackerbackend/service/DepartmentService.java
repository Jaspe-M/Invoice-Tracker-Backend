package com.example.invoicetrackerbackend.service;

import com.example.invoicetrackerbackend.entity.Department;
import com.example.invoicetrackerbackend.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateBudget(Long departmentId, BigDecimal newBudget) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
        department.setBudget(newBudget);
        return departmentRepository.save(department);
    }
}