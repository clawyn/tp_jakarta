package be.bstorm.tp_jakarta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(nullable = false, unique = false, length = 50)
    @Getter @Setter
    private String FirstName;

    @Column(nullable = false, unique = false, length = 50)
    @Getter @Setter
    private String LastName;


    @Column(nullable = false, unique = true, length = 50)
    @Getter @Setter
    private String pseudonym;

    @Column(nullable = false)
    @Getter @Setter
    private String password;

    @Column (nullable = false)
    @Getter @Setter
    private boolean accepted;

    @Column(nullable = false)
    @Getter @Setter
    private String role;


    public User (String pseudonym, String password, boolean accepted) {
        this.pseudonym = pseudonym;
        this.password = password;
        this.accepted = accepted;
    }
    public User (String pseudonym, String password) {
        this.pseudonym = pseudonym;
        this.password = password;
    }
    public User (String pseudonym, String password, boolean accepted, String role) {
        this.pseudonym = pseudonym;
        this.password = password;
        this.accepted = accepted;
        this.role = role;
    }
    public User (String pseudonym, String password, String role, boolean accepted) {
        this.pseudonym = pseudonym;
        this.password = password;
        this.role = role;
        this.accepted = accepted;
    }



}
