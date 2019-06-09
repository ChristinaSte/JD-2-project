package com.itacademy.stetsko.web.servlet;

import com.itacademy.stetsko.database.entity.User;
import com.itacademy.stetsko.service.UserService;
import lombok.Getter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Getter
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User defaultUser = userService.getDefaultUser( );
        req.setAttribute("user", defaultUser);

        getServletContext( )
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
