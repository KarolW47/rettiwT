package com.sda.rettiwt.servlets;

import com.sda.rettiwt.hibernate.dao.UserDao;
import com.sda.rettiwt.hibernate.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        String email = req.getParameter("email");
        String pass = req.getParameter("pass");

        User user = new User();
        user.setEmail(email);
        user.setNick(nick);
        user.setPass(pass);
        user.setCreationTS(System.currentTimeMillis());

        UserDao.getInstance().add(user);

        resp.sendRedirect("/");
    }
}
