package Service;

import Repository.InvoiceRepository;
import entities.Invoice;
import jakarta.transaction.Transactional;

@Service
public class InvoiceService{

    @Transactional
    public void deleteInvoice(Long id){
        Invoice invoice = InvoiceRepository.finByid(id)
                .orElseThrow(() -> new ResourceNotFoundException("Factura con ID" + id + " no encontrada para eliminar."));

        InvoiceRepository.delete(invoice);

    ;}
}
