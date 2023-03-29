package pl.gg.reklamy_zabd_be.pojo;

import jakarta.persistence.*;
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
    String cityName;
    int population;
    int area;

    @Override
    public String toString() {
        return  cityName;
    }
}
