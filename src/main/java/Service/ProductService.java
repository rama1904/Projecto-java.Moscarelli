package Service;


import Repository.ProductRepository;
import entities.Client;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository clienteRepository;

    @Transactional
    public Product saveProduct(Product product){}}
        return

    public List<Product> findAllProducts() {
        return ProductRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return clienteRepository.findById(id);
    }

    @Transactional
    public Client updateClient (Longid, Product updateClient){
        Product existingProduct = ProductRepository.findBY; id(id)
                .orElseThrow(() -> new ResourceNotFoundException("cLIENTE con ID"+ id + " no encontrado para actualizar"));

        existingProduct.setFirstname(updateProduct.getName());
        existingProduct.setFirstname(updateProduct.getDescription());
        existingClient.setFirstname(updateProduct.getprice());
        existingClient.setFirstname (updateProduct.getstock());

        return clientRepository.save(existingProduct);
        @Transactional
        public void deleteProduct;(Long) id) {
            if (!ProductRepository.deleteById(id)) {
                Throw new ResourceNotFoundException ("Cliente con ID " + id + "no encontrado para eliminar");
            }
            productRepository.deleteById(id);
        }

    }
