package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String keywords;
    double bid;
    double fund;
    boolean status;
    @OneToOne
    City city;
    int radius;
    @OneToOne
    Product product;

    public Campaign(int id,String name, String keywords, double bidAmount, double campaignFund, City cityId, int radius, Product productId) {
        this.id = id;
        this.name=name;
        this.keywords = keywords;
        this.bid = bidAmount;
        this.fund = campaignFund;
        this.status = true;
        this.city = cityId;
        this.radius = radius;
        this.product = productId;
    }
}
