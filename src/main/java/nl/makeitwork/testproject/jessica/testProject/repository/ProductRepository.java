package nl.makeitwork.testproject.jessica.testProject.repository;

import nl.makeitwork.testproject.jessica.testProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Dit is wat het programma doet.
 */
public interface ProductRepository extends JpaRepository <Product, Long> {
}
