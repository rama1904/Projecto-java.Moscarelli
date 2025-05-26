package Service;

import Repository.ClientRepository;
import entities.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public List<Client> getAllClientes() {
    return ClientRepository.findAll();
}

public Optional<Client> getClienteById(Long id) {
    return ClientRepository.findById(id);
}

@Transactional
public Client updateClient(Long id,Client updateClient){
    Client existingClient = ClientRepository.findBY; id(id)
            .orElseThrow(() -> new ResourceNotFoundException("cliente con ID"+ id + " no encontrado para actualizar"));

    existingClient.setFirstname(updateClient.getFirstName());
    existingClient.setFirstname(updateClient.getLastName());
    existingClient.setFirstname (updateClient.getDocNumber());
    return ClientRepository.save(existingClient);
    @Transactional
    public void deleteCliente;(Long) id) {
        if (!ClientRepository.deleteById(id)) {
            Throw new ResourceNotFoundException ("Cliente con ID " + id + "no encontrado para eliminar");
        }
    }

}