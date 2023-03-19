package pl.gg.reklamy_zabd_be.repository;

import pl.gg.reklamy_zabd_be.pojo.Company;
import pl.gg.reklamy_zabd_be.pojo.Seller;

import java.util.List;

public interface SellerRepository {
    int save(Seller seller);
    int update(Seller seller);
    Seller findById(int id);
    int deleteById(int id);
    List<Seller> findAll();
    int deleteAll();
}
