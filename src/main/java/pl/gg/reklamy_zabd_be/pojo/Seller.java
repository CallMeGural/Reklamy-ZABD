package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    double balance;
    @ManyToOne
    Company companyId;

    @Override
    public String toString() {
        return name;
    }
}
