package com.example.invoicetrackerbackend.dto;

import java.math.BigDecimal;

public record InvoiceRequest(
        String description,
        BigDecimal amount,
        Long departmentId
) {}