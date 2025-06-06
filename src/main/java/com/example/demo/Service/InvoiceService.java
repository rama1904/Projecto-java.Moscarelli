package Service;

import Repository.InvoiceRepository;
import entities.Invoice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> findInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Transactional
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Transactional
    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice existingInvoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura con ID " + id + " no encontrada"));

        if (invoiceDetails.getDate() != null) {
            existingInvoice.setDate(invoiceDetails.getDate());
        }
        if (invoiceDetails.getAmount() != null) {
            existingInvoice.setAmount(invoiceDetails.getAmount());
        }

        return invoiceRepository.save(existingInvoice);
    }

    @Transactional
    public void deleteInvoice(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Factura con ID " + id + " no encontrada");
        }
        invoiceRepository.deleteById(id);
    }
}