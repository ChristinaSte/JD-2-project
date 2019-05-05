package com.itacademy.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponce;
import java.io.IOException;


@Webservlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = getInstance.getInstance( );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        User defaultUser = userService.getDefaultUser( );
        req.setAttribute("user", defaultUser);

        getServletContext( )
                .getRequestDispatcher("/WEB-INF/jsp/user.jsp")
                .forward(req, resp);
    }
}
