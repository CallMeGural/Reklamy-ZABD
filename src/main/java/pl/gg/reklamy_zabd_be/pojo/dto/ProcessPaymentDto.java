package pl.gg.reklamy_zabd_be.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gg.reklamy_zabd_be.pojo.BankAccount;
import pl.gg.reklamy_zabd_be.pojo.Seller;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProcessPaymentDto {
    private BankAccount bankAccount;
    private Seller seller;
    double payment;
}
