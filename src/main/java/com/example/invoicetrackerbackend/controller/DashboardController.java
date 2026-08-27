package com.example.invoicetrackerbackend.controller;

import com.example.invoicetrackerbackend.dto.ManagerDashboardDTO;
import com.example.invoicetrackerbackend.service.DashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:4173"})
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/manager")
    public ManagerDashboardDTO getManagerDashboard() {
        return dashboardService.getManagerDashboardData();
    }
}