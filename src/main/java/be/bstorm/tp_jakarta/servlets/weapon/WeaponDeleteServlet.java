package be.bstorm.tp_jakarta.servlets.weapon;

import be.bstorm.tp_jakarta.services.WeaponService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/weapon/delete")
public class WeaponDeleteServlet extends HttpServlet {

    @Inject
    private WeaponService weaponService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Long serialNumber = Long.valueOf(req.getParameter("serialNumber"));

        weaponService.deleteBySerialNumber(serialNumber);
        resp.sendRedirect(req.getContextPath() + "/");

    }
}
