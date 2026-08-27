package com.example.invoicetrackerbackend.service;

import com.example.invoicetrackerbackend.dto.DepartmentBudgetDTO;
import com.example.invoicetrackerbackend.dto.ManagerDashboardDTO;
import com.example.invoicetrackerbackend.entity.Department;
import com.example.invoicetrackerbackend.entity.Invoice;
import com.example.invoicetrackerbackend.entity.InvoiceStatus;
import com.example.invoicetrackerbackend.repository.DepartmentRepository;
import com.example.invoicetrackerbackend.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private final DepartmentRepository departmentRepository;
    private final InvoiceRepository invoiceRepository;

    public DashboardService(DepartmentRepository departmentRepository, InvoiceRepository invoiceRepository) {
        this.departmentRepository = departmentRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public ManagerDashboardDTO getManagerDashboardData() {
        BigDecimal totalBudget = departmentRepository.calculateTotalCompanyBudget();
        BigDecimal totalSpent = invoiceRepository.calculateTotalSpent();
        long pendingInvoices = invoiceRepository.countByStatus(InvoiceStatus.PENDING);

        List<Department> departments = departmentRepository.findAll();
        List<DepartmentBudgetDTO> departmentBudgets = new ArrayList<>();
        long overBudgetCount = 0;

        for (Department dept : departments) {
            BigDecimal spent = invoiceRepository.calculateDepartmentSpent(dept.getId());
            if (spent.compareTo(dept.getBudget()) > 0) {
                overBudgetCount++;
            }
            departmentBudgets.add(new DepartmentBudgetDTO(dept.getId(), dept.getName(), spent, dept.getBudget()));
        }

        List<Invoice> recentInvoices = invoiceRepository.findTop2ByOrderByCreatedAtDesc();

        return new ManagerDashboardDTO(
                totalBudget,
                totalSpent,
                pendingInvoices,
                overBudgetCount,
                departmentBudgets,
                recentInvoices
        );
    }
}