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
    private ProductRepository productRepository;

    @Transactional
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    public Product updateProduct(Long id, Product updateProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado."));

        existingProduct.setName(updateProduct.getName());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setStock(updateProduct.getStock());

        return productRepository.save(existingProduct);
    }

    @Transactional
    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Producto con ID " + id + " no encontrado.");
        }
        productRepository.deleteById(id);
    }
}