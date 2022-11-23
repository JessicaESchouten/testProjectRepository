package nl.makeitwork.testproject.jessica.testProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Auteur Jessica Schouten.
 * <p>
 * Dit is wat het programma doet.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private Integer price = 0;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
