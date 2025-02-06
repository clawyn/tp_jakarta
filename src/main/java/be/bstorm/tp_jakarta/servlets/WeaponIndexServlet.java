package be.bstorm.tp_jakarta.servlets;

import be.bstorm.tp_jakarta.entities.Weapon;
import be.bstorm.tp_jakarta.models.weapon.WeaponDTO;
import be.bstorm.tp_jakarta.services.WeaponService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

//@WebServlet(value = "/", loadOnStartup = 1)
//public class WeaponIndexServlet extends HttpServlet {
//    @Inject
//    private WeaponService weaponService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Weapon> weapons = weaponService.findAll();
//
//        List<WeaponDTO> dtos = weapons.stream()
//                .map(w -> WeaponDTO.fromWeapon(w))
//                .collect(Collectors.toList());
//        req.setAttribute("weapons", dtos);
//        req.getRequestDispatcher("/pages/index.jsp").forward(req, resp);
//    }
//}
