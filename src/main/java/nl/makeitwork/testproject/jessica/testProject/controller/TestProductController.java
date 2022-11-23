package nl.makeitwork.testproject.jessica.testProject.controller;

import nl.makeitwork.testproject.jessica.testProject.model.Product;
import nl.makeitwork.testproject.jessica.testProject.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Runt het programma van product.
 */

@Controller
public class TestProductController {

    private final ProductRepository productRepository;

    public TestProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"/products/all", "/"})
    protected String showProductOverview(Model model) {
        model.addAttribute("allProducts", productRepository.findAll());

        return "productOverview";
    }

    @GetMapping("/products/new")
    protected String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }


    @GetMapping("/products/edit/{productId}")
    protected String showEditProductForm(@PathVariable("productId") Long productId, Model model) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "productForm";
        }

        return "redirect:/product/all";
    }

    @PostMapping("/products/new")
    protected String saveProduct(@ModelAttribute("product") Product productToBeSaved, BindingResult result) {
        if (!result.hasErrors()) {
            productRepository.save(productToBeSaved);
        }
        return "redirect:/products/all";
    }


    @GetMapping("/product/delete/{productId}")
    protected String deleteProduct(@PathVariable("productId") Long productId) {
        Optional<Product> product = productRepository.findById(productId);

        if (product.isPresent()) {
            productRepository.delete(product.get());
        }

        return "redirect:/product/all";
    }
}
