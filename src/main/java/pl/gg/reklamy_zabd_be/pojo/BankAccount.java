package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
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
    private int id;
    private String creditCardNumber;
    private String cvc;
    private boolean status;
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
