package com.inorg.miniproject.controller;

import com.inorg.miniproject.model.Category;
import com.inorg.miniproject.model.Product;
import com.inorg.miniproject.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("products")
    public List<Product> getCategories() {
        return productRepository.findAll();
    }

    @GetMapping("products/{productId}")
    public String getProductsbyId(@PathVariable Integer productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return "Category does not exist";
        }
        return product.toString();
    }

    @PostMapping("products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("products/{productId}")
    public String updateProductbyId(@PathVariable Integer productId, @RequestBody Product updatedProduct) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            return "Product does not exist";
        }
        product.setProduct_name(updatedProduct.getProduct_name());
        return "Product name updated!";
    }

    @DeleteMapping("products/{productId}")
    public String deleteProductbyId(@PathVariable Integer productId) {
        productRepository.deleteById(productId);
        return "Deleted product";
    }
}