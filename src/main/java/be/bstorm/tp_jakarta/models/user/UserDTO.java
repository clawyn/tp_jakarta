package be.bstorm.tp_jakarta.models.user;

import be.bstorm.tp_jakarta.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String pseudonym;
    private String role;




    public static UserDTO fromUser(User user) {

        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPseudonym(),
                user.getRole());
    }
}
