package com.mateusz.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RENT on 2017-03-01.
 */
public class LoginController implements Controller {
    @Override
    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        writer.write("<h1> Hello From Login Controller");
        writer.write("<ul>");
        for (int i = 0; i < cookies.length; i++) {
            writer.write("<li>" + cookies[i].getName() + ": " + cookies[i].getValue() + "</li>");
        }
        writer.write("</ul>");
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("Hello")) {
                Cookie cookie = cookies[i];
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
    }
}
