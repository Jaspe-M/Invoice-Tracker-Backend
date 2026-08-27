package com.example.invoicetrackerbackend.controller;

import com.example.invoicetrackerbackend.dto.InvoiceRequest;
import com.example.invoicetrackerbackend.entity.Invoice;
import com.example.invoicetrackerbackend.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @PostMapping
    public Invoice createInvoice(@RequestBody InvoiceRequest request) {
        return invoiceService.createInvoice(request.description(), request.amount(), request.departmentId());
    }
}