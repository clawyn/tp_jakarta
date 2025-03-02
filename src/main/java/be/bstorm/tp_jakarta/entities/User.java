package be.bstorm.tp_jakarta.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_")
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode @ToString
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(name = "FirstName",nullable = false, unique = false, length = 50)
    @Getter @Setter
    private String FirstName;

    @Column(name="lastName",nullable = false, unique = false, length = 50)
    @Getter @Setter
    private String LastName;


    @Column(name = "pseudonym",nullable = false, unique = true, length = 50)
    @Getter @Setter
    private String pseudonym;

    @Column(name="password",nullable = false)
    @Getter @Setter
    private String password;

//    @Column (name="accepted",nullable = false)
//    @Getter @Setter
//    private boolean accepted;

    @Column(name="role",nullable = false)
    @Getter @Setter
    private String role;



    public User (String pseudonym, String password) {
        this.pseudonym = pseudonym;
        this.password = password;
    }
    public User (String pseudonym, String password,String role) {
        this.pseudonym = pseudonym;
        this.password = password;

        this.role = role;
    }

    public User(String firstName, String lastName, String pseudonym, String password, String role) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.pseudonym = pseudonym;
        this.password = password;
        this.role = role;
    }

    public User (Long id,String pseudonym,String role) {
        this.id = id;
        this.pseudonym = pseudonym;
        this.role = role;
    }
}
