package be.bstorm.tp_jakarta.models.weapon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class weaponDTO {
    private Long serialNumber;
    private String name;
    private String type;
    private String model;
    private String history;
}
