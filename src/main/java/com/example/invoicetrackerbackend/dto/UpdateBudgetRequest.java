package com.example.invoicetrackerbackend.dto;

import java.math.BigDecimal;

public record UpdateBudgetRequest(
        BigDecimal budget
) {}