package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.repository.ProductRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Product Product) {
        return productRepository.save(Product);
    }

    public void deleteProductById(int id) {
         productRepository.deleteById(id);
    }

    public void deleteAllProducts() {
         productRepository.deleteAll();
    }
}
