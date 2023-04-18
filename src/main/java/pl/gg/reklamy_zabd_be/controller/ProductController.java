package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.City;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.service.ProductService;
import pl.gg.reklamy_zabd_be.service.SellerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final SellerService sellerService;

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product_list";
    }

    @GetMapping("/list/{id}")
    public String getAllCompanyProducts(@PathVariable int id,Model model) {
        model.addAttribute("products",productService.getAllCompanyProducts(id));
        return "product_list";
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("sellers", sellerService.getAllSellers());
        return "product_edit";
    }

    @GetMapping("/form")
    public String productForm(Model model) {
        model.addAttribute("product",new Product());
        model.addAttribute("sellers", sellerService.getAllSellers());
        return "product_form";
    }

    @PutMapping("/{id}")
    public String updateProduct(@Valid @ModelAttribute("product") Product Product,
                                Model model) {
        productService.updateProduct(Product);
        model.addAttribute("product", Product);
        model.addAttribute("sellers", sellerService.getAllSellers());
        return "product_edit";
    }

    @PostMapping
    public String addProduct(@Valid Product Product) {
        productService.saveProduct(Product);
        return "redirect:/products/list";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/products/list";
    }

    @DeleteMapping
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "redirect:index";
    }

}
