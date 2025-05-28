package Repository;


import Service.InvoiceDetailService;
import entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailService, Long> {
    List<InvoiceDetail> findByInvoiceId(Long invoiceId);
}
