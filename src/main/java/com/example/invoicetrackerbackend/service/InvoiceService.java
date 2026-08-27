package com.example.invoicetrackerbackend.service;
import com.example.invoicetrackerbackend.entity.Department;
import com.example.invoicetrackerbackend.entity.Invoice;
import com.example.invoicetrackerbackend.repository.DepartmentRepository;
import com.example.invoicetrackerbackend.repository.InvoiceRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final DepartmentRepository departmentRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, DepartmentRepository departmentRepository) {
        this.invoiceRepository = invoiceRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice createInvoice(String description, BigDecimal amount, Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        Invoice invoice = new Invoice(description, amount, department);
        return invoiceRepository.save(invoice);
    }
}