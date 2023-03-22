package pl.gg.reklamy_zabd_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.gg.reklamy_zabd_be.pojo.Product;
import pl.gg.reklamy_zabd_be.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = new ArrayList<>(productService.getAllProducts());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PutMapping
    public int updateProduct(Product Product) {
        return productService.updateProduct(Product);
    }

    @PostMapping
    public int addProduct(Product Product) {
        return productService.saveProduct(Product);
    }

    @DeleteMapping("/{id}")
    public int deleteProductById(@PathVariable int id) {
        return productService.deleteProductById(id);
    }

    @DeleteMapping
    public int deleteAllProducts() {
        return productService.deleteAllProducts();
    }

}
