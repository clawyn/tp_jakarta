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

@WebServlet("/weaponAdd")
public class AddWeaponServlet extends HttpServlet {
    @Inject
    private WeaponService weaponService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException , ServletException {
        req.getRequestDispatcher("/pages/addWeapon.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String model = req.getParameter("model");
        String history = req.getParameter("history");

        try{
            weaponService.addWeapon(new Weapon( name, type, model, history));
            resp.sendRedirect(req.getContextPath() + "/addWeapon");
        }catch (Exception e){
            System.out.println(e.getMessage());
            req.getRequestDispatcher("/pages/addWeapon.jsp").forward(req, resp);
        }
    }

}
