package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Embeddable
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @NotEmpty
    String cityName;
    @NotNull
    @Min(value = 0)
    int population;
    @NotNull
    @Min(value = 1)
    int area;

    @Override
    public String toString() {
        return  cityName;
    }
}
