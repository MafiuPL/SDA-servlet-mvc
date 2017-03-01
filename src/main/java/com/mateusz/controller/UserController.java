package com.mateusz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by RENT on 2017-03-01.
 */
public class UserController implements Controller{

    public void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<h1>Hello From User Controller</h1>");

    }
}
