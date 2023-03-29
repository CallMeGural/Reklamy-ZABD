package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
