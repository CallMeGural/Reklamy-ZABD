package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "podaj numer karty kredytowej")
    @CreditCardNumber(message = "To nie jest prawidłowy numer karty kredytowej")
    private String creditCardNumber;
    @NotEmpty(message = "podaj numer cvc")
    @Digits(integer = 3, fraction = 0, message = "Nieprawidłowy kod CVV")
    private String cvc;
    private boolean status;
    @NotNull
    @Min(value = 0)
    private double balance;
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public BankAccount(String creditCardNumber, String cvc, double balance, Company company) {
        this.creditCardNumber = creditCardNumber;
        this.cvc = cvc;
        this.status = true;
        this.balance = balance;
        this.company=company;
    }

    @Override
    public String toString() {
        return company.name;
    }

}
