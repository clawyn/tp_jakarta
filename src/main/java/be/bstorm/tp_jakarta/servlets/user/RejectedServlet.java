package be.bstorm.tp_jakarta.servlets.user;

import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.models.user.UserDTO;
import be.bstorm.tp_jakarta.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet ("/rejected")
public class RejectedServlet extends HttpServlet {
    @Inject
    private UserService userService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.findAll();

        List<UserDTO> dtos = users.stream()
                .map(u -> UserDTO.fromUser(u))
                .collect(Collectors.toList());
        req.setAttribute("users", dtos);
        req.getRequestDispatcher("/pages/admin.jsp").forward(req, resp);
    }

}
