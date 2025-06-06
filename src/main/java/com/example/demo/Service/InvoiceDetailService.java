package Service;


import Controller.InvoiceDetailController;
import Repository.ClientRepository;
import Repository.InvoiceDetailRepository;
import entities.Client;
import entities.InvoiceDetail;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class InvoiceDetailService {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetail getDetailsByInvoiceId (Long invoiceId) {
       return invoiceDetailRepository. findById (invoiceId);

    }
    public InvoiceDetail updateInvoiceDetail(Long id, InvoiceDetail updateDetail) {
        InvoiceDetail existing = invoiceDetailRepository.findById(id).orElse(null);
        if (existing == null) {return null;}
        existing.setAmount(updateDetail.getAmount() == 0 ? existing.getAmount() : updateDetail.getAmount());
        existing.setPrice(updateDetail.getPrice() == 0 ? existing.getPrice() : updateDetail.getPrice());
        return invoiceDetailRepository.save(existing);
    }


    public void deleteInvoiceDetail(Long id) {
        InvoiceDetail detail = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        invoiceDetailRepository.delete(detail);
    }
}