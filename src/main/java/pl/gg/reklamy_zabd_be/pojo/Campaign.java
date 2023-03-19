package pl.gg.reklamy_zabd_be.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    int id;
    String keywords;
    double bidAmount;
    double campaignFund;
    boolean status;
    int cityId;
    int radius;
    int productId;

    public Campaign(int id, String keywords, double bidAmount, double campaignFund, int cityId, int radius, int productId) {
        this.id = id;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFund = campaignFund;
        this.status = true;
        this.cityId = cityId;
        this.radius = radius;
        this.productId = productId;
    }
}
