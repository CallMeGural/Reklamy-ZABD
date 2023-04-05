package pl.gg.reklamy_zabd_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.pojo.Seller;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {
    List<Seller> findAllByCompany(Company company);
}
