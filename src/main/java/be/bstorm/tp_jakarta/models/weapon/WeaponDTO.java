package be.bstorm.tp_jakarta.models.weapon;

import be.bstorm.tp_jakarta.entities.Weapon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class WeaponDTO {
    private Long serialNumber;
    private String name;
    private String type;
    private String model;
    private String history;

    public static WeaponDTO fromWeapon (Weapon weapon){
        return new WeaponDTO(
                weapon.getSerialNumber(),
                weapon.getName(),
                weapon.getType(),
                weapon.getModel(),
                weapon.getHistory()
        ) ;
    }
}
