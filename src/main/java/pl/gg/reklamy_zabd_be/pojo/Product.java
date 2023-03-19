package pl.gg.reklamy_zabd_be.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    int id;
    String name;
    int sellerId;
}
