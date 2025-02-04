package be.bstorm.tp_jakarta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "weapon_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class Weapon {
    @Id
    @Getter @Setter
    @Column(name ="currentUser != null && currentUser.accepted.equals(true) && currentUser.role.equals('admin')", nullable = false, unique = true)
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

}
