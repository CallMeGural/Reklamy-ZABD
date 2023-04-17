package pl.gg.reklamy_zabd_be.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gg.reklamy_zabd_be.pojo.Company;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountDto {
    private int id;
    private Company company;
    private String creditCardNumber;
    private String cvc;
    private double balance;
}
