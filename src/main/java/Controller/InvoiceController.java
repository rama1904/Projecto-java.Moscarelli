package Controller;



import Service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices() {

        List<InvoiceResponseDTO> invoices = invoiceService.findAllInvoice();
        return ResponseEntity.ok (invoice);
    }

    @GetMapping("/{id}")
    public Optional<InvoiceResponseDTO> getProductsById(@PathVariable Long id){
        InvoiceResponseDTO invoice = invoiceService.findInvoiceByid(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping
    public ResponseEntity<InvoiceResponseDTO> createinvoice(@RequestBody InvoiceResponseDTO invoiceResponseDTO) {
        InvoiceResponseDTO createdInvoice = invoiceService.createInvoice(InvoiceResponseDTO);
        return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponseDTO> Createinvoice (@RequestBody InvoiceResponseDTO invoiceResponseDTO){
        InvoiceResponseDTO invoice = invoiceService.findInvoiceByid(id);
        return ResponseEntity.ok(invoice);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        InvoiceController productService = null;
        productService.deleteProduct(id);
        return ResponseEntity.noContent() .build();
    }
}

