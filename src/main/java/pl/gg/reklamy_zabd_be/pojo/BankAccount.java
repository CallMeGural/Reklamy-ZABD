package pl.gg.reklamy_zabd_be.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    int id;
    String creditCardNumber;
    String cvc;
    boolean status;
    double balance;

    public BankAccount(int id, String creditCardNumber, String cvc, double balance) {
        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.cvc = cvc;
        this.status = true;
        this.balance = balance;
    }
}
