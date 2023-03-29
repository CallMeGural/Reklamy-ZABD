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
    private final SellerRepository sellerRepository;

    public List<Seller> getAllSellers() {
        return sellerRepository.findAll();
    }

    public Seller getSellerById(int id) {
        return sellerRepository.findById(id).orElseThrow();
    }

    public Seller saveSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller updateSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public void deleteSellerById(int id) {
         sellerRepository.deleteById(id);
    }

    public void deleteAllSellers() {
         sellerRepository.deleteAll();
    }
}
