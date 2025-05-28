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

    public List<InvoiceDetailController.InvoiceDetailResponseDTO> getDetailsByInvoiceId(Long invoiceId) {
        List<InvoiceDetail> details = invoiceDetailRepository.findByInvoiceId(invoiceId);
        return details.stream()
                .map(d -> new InvoiceDetailController.InvoiceDetailResponseDTO(d.getId()))
                .collect(Collectors.toList());
    }

    public InvoiceDetailController.InvoiceDetailResponseDTO findDetailById(Long detailId) {
        InvoiceDetail detail = invoiceDetailRepository.findById(detailId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new InvoiceDetailController.InvoiceDetailResponseDTO(detail.getId());
    }

    @Transactional
    public InvoiceDetail updateInvoiceDetail(Long id, InvoiceDetail updateDetail) {
        InvoiceDetail existing = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (updateDetail.getAmount() != null) existing.setAmount(updateDetail.getAmount());
        if (updateDetail.getPrice() != null) existing.setPrice(updateDetail.getPrice());
        return invoiceDetailRepository.save(existing);
    }

    @Transactional
    public void deleteInvoiceDetail(Long id) {
        InvoiceDetail detail = invoiceDetailRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        invoiceDetailRepository.delete(detail);
    }
}