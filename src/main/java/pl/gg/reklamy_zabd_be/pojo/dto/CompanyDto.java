package pl.gg.reklamy_zabd_be.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {
    private int id;
    private String name;
    private int bankAccId;
}
