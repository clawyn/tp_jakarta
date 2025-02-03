package be.bstorm.tp_jakarta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "weapon_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Weapon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(nullable = false, unique = true)
    private Long serialNumber;

    @Column(nullable = true, unique = false)
    @Getter @Setter
    private String type;

    @Column(nullable = false, unique = false)
    @Getter @Setter
    private String model;

    @Column(nullable = true, unique = false)
    @Getter @Setter
    private String history;

}
