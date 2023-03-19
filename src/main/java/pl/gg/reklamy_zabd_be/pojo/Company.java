package pl.gg.reklamy_zabd_be.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    int id;
    String name;
    int bankAccId;
}
