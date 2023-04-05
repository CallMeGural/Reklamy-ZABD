package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.Seller;
import pl.gg.reklamy_zabd_be.service.CompanyService;
import pl.gg.reklamy_zabd_be.service.SellerService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {


    private final SellerService sellerService;
    private final CompanyService companyService;

    @GetMapping
    public String getAllSellers(Model model) {
        model.addAttribute("sellers", sellerService.getAllSellers());
        return "sellers_list";
    }

    @GetMapping("/{id}")
    public String getSellerById(Model model, @PathVariable int id) {
        Seller seller = sellerService.getSellerById(id);
        model.addAttribute("seller", seller);
        return "seller_edit";
    }

    @GetMapping("/form")
    public String sellerForm(Model model) {
        model.addAttribute("seller",new Seller());
        model.addAttribute("companies",companyService.getAllCompanies());
        return "seller_form";
    }

    @PutMapping
    public String updateSeller(@Valid @ModelAttribute("seller") Seller seller,
                               Model model) {
        sellerService.updateSeller(seller);
        model.addAttribute("seller", seller);
        return "seller_edit";
    }

    @PostMapping
    public String addSeller(@Valid Seller seller) {
        sellerService.saveSeller(seller);
        return "redirect:/sellers/list";
    }

    @DeleteMapping("/{id}")
    public String deleteSellerById(@PathVariable int id) {
        sellerService.deleteSellerById(id);
        return "redirect:/sellers/list";
    }

    @DeleteMapping
    public String deleteAllSellers() {
        sellerService.deleteAllSellers();
        return "redirect:index";
    }
}
