package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Product;

import java.util.List;

public interface ProductRepository {
    int save(Product product);
    int update(Product product);
    Product findById(int id);
    int deleteById(int id);
    List<Product> findAll();
    int deleteAll();
}
