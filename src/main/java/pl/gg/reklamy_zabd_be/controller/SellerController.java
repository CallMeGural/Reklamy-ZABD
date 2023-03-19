package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Seller;
import pl.gg.reklamy_zabd_be.service.SellerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @GetMapping("/{id}")
    public Seller getSellerById(@PathVariable int id) {
        return sellerService.getSellerById(id);
    }

    @PutMapping
    public int updateSeller(Seller seller) {
        return sellerService.updateSeller(seller);
    }

    @PostMapping
    public int addSeller(Seller seller) {
        return sellerService.saveSeller(seller);
    }

    @DeleteMapping("/{id}")
    public int deleteSellerById(@PathVariable int id) {
        return sellerService.deleteSellerById(id);
    }

    @DeleteMapping
    public int deleteAllSellers() {
        return sellerService.deleteAllSellers();
    }
}
