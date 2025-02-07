package be.bstorm.tp_jakarta.servlets.user;


import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/user/update")
public class UserUpdateServlet extends HttpServlet {
    @Inject
    private UserService userService;

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        Long id = Long.valueOf(req.getParameter("id"));

        User user = userService.findById(id);

        req.setAttribute("user", user);

        req.getRequestDispatcher("/pages/userUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
//        String firstName = req.getParameter("FirstName");
//        String lastName = req.getParameter("lastName");
        String pseudonym = req.getParameter("pseudonym");
//        String password = req.getParameter("password");
        String role = req.getParameter("role");
        Long newId = Long.valueOf(req.getParameter("newId"));

        User user = new User( pseudonym, role);
        userService.update(user, newId );

        resp.sendRedirect(req.getContextPath() + "/pages/userUpdate" );
    }
}
