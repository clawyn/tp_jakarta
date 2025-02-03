package be.bstorm.tp_jakarta.models;

import be.bstorm.tp_jakarta.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class UserDTO {
    private Long id;
    private String pseudonym;
    private String role;
    private boolean  accepted;


    public static UserDTO fromUser(User user) {

        return new UserDTO(user.getId(), user.getPseudonym(), user.getRole(), user.isAccepted());
    }
}
