// Application.java
package com.aegis.prime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// ProductController.java
package com.aegis.prime.controller;

import com.aegis.prime.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ProductController {

    private final List<Product> products = Arrays.asList(
        new Product("Tier I", "Aegis Core", "$4,500", Arrays.asList("256-bit AES Hardware Encryption", "Biometric Multi-Factor Auth", "Air-Gapped Transaction Signing", "Titanium Chassis")),
        new Product("Tier II", "Aegis Prime", "$12,000", Arrays.asList("Post-Quantum Lattice Cryptography", "Decentralized Mesh Networking", "Zero-Knowledge Proof Engine", "Sapphire Glass Interface")),
        new Product("Tier III", "Aegis Sovereign", "$45,000", Arrays.asList("Custom Silicon Secure Enclave", "Satellite Uplink Capability", "Autonomous Threat Neutralization", "Bespoke Artisan Assembly"))
    );

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/products/{name}")
    public Product getProductByName(@PathVariable String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}

// Product.java
package com.aegis.prime.model;

import java.util.List;

public class Product {
    private String tier;
    private String name;
    private String price;
    private List<String> features;

    public Product(String tier, String name, String price, List<String> features) {
        this.tier = tier;
        this.name = name;
        this.price = price;
        this.features = features;
    }

    public String getTier() { return tier; }
    public String getName() { return name; }
    public String getPrice() { return price; }
    public List<String> getFeatures() { return features; }
}
