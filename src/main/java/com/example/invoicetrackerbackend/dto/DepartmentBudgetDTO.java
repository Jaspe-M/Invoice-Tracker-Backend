package com.example.invoicetrackerbackend.dto;

import java.math.BigDecimal;

public record DepartmentBudgetDTO(
        Long id,
        String name,
        BigDecimal spent,
        BigDecimal budget
) {}