package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty(message = "podaj nazwe sprzedawcy")
    String name;
    @NotNull
    @Min(value = 0)
    double balance;
    @ManyToOne
    Company company;

    @Override
    public String toString() {
        return name;
    }
}
