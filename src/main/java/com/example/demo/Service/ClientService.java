package Service;



import Repository.ClientRepository;
import entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Long id, Client updateClient) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + id + " no encontrado"));

        if (updateClient.getFirstName() != null) existingClient.setFirstName(updateClient.getFirstName());
        if (updateClient.getLastName() != null) existingClient.setLastName(updateClient.getLastName());
        if (updateClient.getEmail() != null) existingClient.setEmail(updateClient.getEmail());

        return clientRepository.save(existingClient);
    }

    @Transactional
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Cliente con ID " + id + " no encontrado");
        }
        clientRepository.deleteById(id);
    }
}
