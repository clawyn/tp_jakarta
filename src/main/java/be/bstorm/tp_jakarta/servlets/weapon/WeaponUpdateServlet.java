package be.bstorm.tp_jakarta.servlets.weapon;

import be.bstorm.tp_jakarta.entities.Weapon;
import be.bstorm.tp_jakarta.services.WeaponService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/update")
public class WeaponUpdateServlet extends HttpServlet {
    @Inject
    private WeaponService weaponService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Long serialNumber = Long.parseLong(req.getParameter("serialNumber"));
        Weapon weapon = weaponService.findBySerialNumber(serialNumber);
        req.setAttribute("weapon",weapon);
        req.getRequestDispatcher("/pages/weaponUpdate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Long serialNumber = Long.valueOf(req.getParameter("serialNumber"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String model = req.getParameter("model");
        String history = req.getParameter("history");
        Long newSerialNumber = Long.parseLong(req.getParameter("newSerialNumber"));

        Weapon weapon = new Weapon(serialNumber, name, type, model, history);
        weaponService.update(weapon, newSerialNumber);

        resp.sendRedirect(req.getContextPath() + "/pages/weaponUpdate");


    }
}
