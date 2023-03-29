package pl.gg.reklamy_zabd_be.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products_list";
    }

    @GetMapping("/{id}")
    public String getProductById(Model model, @PathVariable int id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "product_edit";
    }

    @PutMapping
    public String updateProduct(@Valid @ModelAttribute("product") Product Product,
                                Model model) {
        productService.updateProduct(Product);
        model.addAttribute("product", Product);
        return "product_edit";
    }

    @PostMapping
    public String addProduct(@Valid Product Product) {
        productService.saveProduct(Product);
        return "redirect:/companies/list";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
        return "redirect:/companies/list";
    }

    @DeleteMapping
    public String deleteAllProducts() {
        productService.deleteAllProducts();
        return "redirect:index";
    }

}
