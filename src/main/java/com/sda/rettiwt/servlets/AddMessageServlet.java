package com.sda.rettiwt.servlets;

import com.sda.rettiwt.hibernate.dao.MessageDao;
import com.sda.rettiwt.hibernate.entity.Message;
import com.sda.rettiwt.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", value = "/addMessageServlet")
public class AddMessageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("message");

        Utils.getUserFromCookies(req)
                .ifPresent(u -> {
                    Message message = new Message();
                    message.setContent(msg);
                    message.setTimestamp(System.currentTimeMillis());
                    message.setUser(u);

                    MessageDao.getInstance().add(message);

                });

        resp.sendRedirect("/");
    }
}
