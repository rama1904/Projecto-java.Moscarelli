package Controller;

import Service.InvoiceService;
import entities.InvoiceDetail;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import Service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class InvoiceDetailController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvoiceDetailResponseDTO {
        private Long detailID;
    }

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @GetMapping("invoiceDetail/{invoiceid}")
    public ResponseEntity<InvoiceDetail> getDetailsByInvoiceId(@PathVariable Long invoiceId) {
        InvoiceDetail details = invoiceDetailService.getDetailsByInvoiceId(invoiceId);
        if (details == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/invoice-details/{detailId}")
    public ResponseEntity<InvoiceDetail> getInvoiceDetailById(@PathVariable Long detailId) {
        InvoiceDetail detail = invoiceDetailService.findById(detailId);
        if (detail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detail);
    }
}