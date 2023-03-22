package pl.gg.reklamy_zabd_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.repository.JdbcProductRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    JdbcProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public int saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    public int updateProduct(Product Product) {
        return productRepository.update(Product);
    }

    public int deleteProductById(int id) {
        return productRepository.deleteById(id);
    }

    public int deleteAllProducts() {
        return productRepository.deleteAll();
    }
}
