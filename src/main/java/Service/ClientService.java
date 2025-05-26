package Service;



import Repository.ClientRepository;
import entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Client saveCliente(Client cliente) {
        return clientRepository.save(cliente);
    }

    public List<Client> getAllClientes() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClienteById(Long id) {
        return clientRepository.findById(id);
    }
}

@Transactional
public Client updateClient(Long id, Client updateClient) {
    // Buscar al cliente existente por ID
    Client existingClient = clientRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + id + " no encontrado para actualizar"));


    if (null != updateClient.getNombre()) {
        existingClient.getNombre(updateClient.getNombre());
    }
    if (updateClient.getApellido() != null) {
        existingClient.setApellido(updateClient.getApellido());
    }
    if (updateClient.getEmail() != null) {
        existingClient.setEmail(updateClient.getEmail());
    }

    // Guardar los cambios y devolver el cliente actualizado
    return clientRepository.save(existingClient);
}
    @Transactional
    public void deleteCliente(Long id) {
        clientRepository.deleteById(id);
        throw new ResourceNotFoundException("Cliente con ID " + id + " no encontrado para eliminar");
    }

    @Transactional
    public Client updateClient(Long id, Client updateClient) {
        // Buscar al cliente existente por ID
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente con ID " + id + " no encontrado para actualizar"));

        if (updateClient.getNombre() != null) {
            existingClient.setNombre(updateClient.getNombre());
        }
        if (updateClient.getApellido() != null) {
            existingClient.setApellido(updateClient.getApellido());
        }
        if (updateClient.getEmail() != null) {
            existingClient.setEmail(updateClient.getEmail());
        }

        // Guardar los cambios y devolver el cliente actualizado
        return clientRepository.save(existingClient);
    }
}
