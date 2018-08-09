package com.sda.rettiwt.servlets;

import com.sda.rettiwt.hibernate.dao.UserDao;
import com.sda.rettiwt.hibernate.entity.User;
import com.sda.rettiwt.utils.Utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nick = req.getParameter("nick");
        String pass = req.getParameter("pass");

        Optional<List<User>> userList = UserDao.getInstance().getAll();
        Optional<User> first = userList.get()
                .stream()
                .filter(u -> u.getNick().equals(nick) && u.getPass().equals(pass))
                .findFirst();
        if (first.isPresent()) {
            String id = String.valueOf(first.get().getId());
            resp.addCookie(new Cookie(Utils.USER_COOKIE_NAME, id));
            resp.sendRedirect("/");
        } else {
            req.setAttribute("errorMessage", "Invalid user or password");
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(req, resp);
        }
    }
}
