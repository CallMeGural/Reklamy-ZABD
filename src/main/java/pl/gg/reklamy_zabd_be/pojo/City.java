package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotEmpty
    String cityName;
    @NotNull
    int population;
    @NotNull
    int area;

    @Override
    public String toString() {
        return  cityName;
    }
}
