package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Nazwa nie może być pusta")
    String name;
    @NotEmpty(message = "Podaj słowa kluczowe")
    String keywords;
    @Min(value = 0)
    double bid;
    @Min(value = 0)
    double fund;
    boolean status;
    @OneToOne
    @JoinColumn(name = "city_id")
    City city;
    @Min(value = 1)
    int radius;
    @OneToOne
    @JoinColumn(name = "product_id")
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
