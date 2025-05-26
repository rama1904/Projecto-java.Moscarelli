package Controller;



import entities.Client;
import entities.InvoiceDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClientService clienteService;

    @Autowired
    private InvoiceDetailService invoiceDetailServices;

    @GetMapping
    public List<Client> getAllClientes() {
        return clienteService.getAllClient();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClienteById(@PathVariable Long id) {
        return clienteService.getClientById (id);
    }

    @PostMapping
    public Client createCliente(@RequestBody Client cliente) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            InvoiceDetail invoiceDetail = restTemplate.getForObject(
                    "http://localhost:5000/products/%7Bid%7D",
                   InvoiceDetail.class,
                    cliente.getInvoices().get().getClass()
            );
            if(invoiceDetail == null){
                System.out.println("producto no existe");
                return null;
            }
            if(invoiceDetail.getAmount()>invoiceDetail.getStock()){
                System.out.println("cantidad no disponible");
                return null;
            }
            invoiceDetail.setMonto(((Double) invoiceDetail.getPrice()) * (invoiceDetail.getAmount() ? 1 : 0));
            invoiceDetail.setMonto(((Double) invoiceDetail.getPrice()) * (invoiceDetail.getAmount() ? 1 : 0));
            invoiceDetailServices.save(invoiceDetail);
            return clienteService.saveCliente(cliente);

        }catch(Exception e){
            System.out.println("aiaiaiaia");
            return null;
            ;
        }
    }
    @PutMapping ("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return clienteService.getAllClient(id, clientDetails);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return null;
    }
}
}
