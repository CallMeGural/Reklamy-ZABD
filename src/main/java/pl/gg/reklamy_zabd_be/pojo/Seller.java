package pl.gg.reklamy_zabd_be.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    int id;
    String name;
    int bankAccId;
    int companyId;
}
