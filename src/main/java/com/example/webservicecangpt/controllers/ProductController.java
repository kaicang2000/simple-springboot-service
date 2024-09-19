package com.example.webservicecangpt.controllers;

import com.example.webservicecangpt.entities.Products;
import com.example.webservicecangpt.entities.PurchaseOrderDetails;
import com.example.webservicecangpt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable String productCode) {
        Products product = productService.getProductById(productCode);
        return ResponseEntity.ok(product);
    }

//    @PostMapping
//    public ResponseEntity<Products> createProduct(@RequestBody @Valid Products product) throws ServiceException {
//        Products createdProduct = productService.saveProduct(product);
//        return ResponseEntity.created(URI.create("/api/products/" + createdProduct.getId())).body(createdProduct);
//    }

    @PutMapping
    public ResponseEntity<String> updateProductStock(
            @RequestBody List<PurchaseOrderDetails> orderDetails) {
        productService.updateProductStock(orderDetails);
        return ResponseEntity.ok("Product stock updated successfully");
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) throws ServiceException {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }
}