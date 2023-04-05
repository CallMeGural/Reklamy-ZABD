package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String productName;
    @ManyToOne
    Seller sellerId;

    @Override
    public String toString() {
        return productName;
    }
}
