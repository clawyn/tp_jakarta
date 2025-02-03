package be.bstorm.tp_jakarta.servlets;

import be.bstorm.tp_jakarta.entities.User;
import be.bstorm.tp_jakarta.services.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LogServlet extends HttpServlet {
    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        req.getRequestDispatcher("pages/log.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        String  pseudonym = req.getParameter("pseudonym");
        String password = req.getParameter("password");

        try {
            User user = userService.Log(pseudonym,password);
            req.getSession(true).setAttribute("currentUser",user);
            resp.sendRedirect(req.getContextPath()+ "/");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            req.getRequestDispatcher("pages/log.jsp").forward(req, resp);
        }
    }
}
