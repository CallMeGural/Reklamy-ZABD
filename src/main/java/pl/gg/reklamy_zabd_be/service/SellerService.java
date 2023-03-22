package pl.gg.reklamy_zabd_be.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gg.reklamy_zabd_be.pojo.Seller;
import pl.gg.reklamy_zabd_be.repository.SellerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(int id) {
        return sellerRepository.findById(id);
    }

    public int saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public int updateSeller(Seller seller) {
        return sellerRepository.update(seller);
    }

    public int deleteSellerById(int id) {
        return sellerRepository.deleteById(id);
    }

    public int deleteAllSellers() {
        return sellerRepository.deleteAll();
    }
}
