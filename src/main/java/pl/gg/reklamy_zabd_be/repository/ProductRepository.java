package pl.gg.reklamy_zabd_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
//    int save(Product product);
//    int update(Product product);
//    Product findById(int id);
//    int deleteById(int id);
//    List<Product> findAll();
//    int deleteAll();
}
