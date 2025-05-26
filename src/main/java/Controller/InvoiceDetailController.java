package Controller;


import Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api") // La ruta base puede ser /api, luego se especifica más
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    // Endpoint para obtener todos los detalles de una factura específica
    // Ejemplo: GET /api/invoices/1/details
    @GetMapping("/invoices/{invoiceId}/details")
    public ResponseEntity<List<InvoiceDetailResponseDTO>> getDetailsByInvoiceId(@PathVariable Long invoiceId) {
        List<InvoiceDetailResponseDTO> details = invoiceDetailService.findDetailsByInvoiceId(invoiceId);
        return ResponseEntity.ok(details);
    }



    @GetMapping("/invoice-details/{detailId}")
    public ResponseEntity<InvoiceDetailResponseDTO> getInvoiceDetailById(@PathVariable Long detailId) {
        InvoiceDetailResponseDTO detail = invoiceDetailService.findDetailById(detailId);
        return ResponseEntity.ok(detail);
    }}

