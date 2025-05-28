package Controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import Service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import Service.InvoiceDetailService.InvoiceDetailResponseDTO;

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

    @GetMapping("/invoices/{invoiceId}/details")
    public ResponseEntity<List<InvoiceDetailResponseDTO>> getDetailsByInvoiceId(@PathVariable Long invoiceId) {
        List<InvoiceDetailResponseDTO> details = invoiceDetailService.getDetailsByInvoiceId(invoiceId);
        if (details == null || details.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/invoice-details/{detailId}")
    public ResponseEntity<InvoiceDetailResponseDTO> getInvoiceDetailById(@PathVariable Long detailId) {
        InvoiceDetailResponseDTO detail = invoiceDetailService.getInvoiceDetailById(detailId);
        if (detail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detail);
    }
}