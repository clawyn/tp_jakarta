package be.bstorm.tp_jakarta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "weapon_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Weapon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Column(name ="serialNumber", nullable = false, unique = true)
    private Long serialNumber;

    @Column(name = "name", nullable = false,unique = false)
    @Getter @Setter
    private String name;

    @Column(name ="type",nullable = true, unique = false)
    @Getter @Setter
    private String type;

    @Column(name ="model",nullable = true, unique = false)
    @Getter @Setter
    private String model;

    @Column(name ="history",nullable = true, unique = false)
    @Getter @Setter
    private String history;

    public Weapon(String name, String type, String model, String history) {
        this.name = name;
        this.type = type;
        this.model = model;
        this.history = history;
    }
}
