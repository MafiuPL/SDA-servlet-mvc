package com.mateusz.servlet;

import com.mateusz.controller.Controller;
import com.mateusz.controller.CookieController;
import com.mateusz.controller.UserController;
import org.apache.commons.lang3.StringUtils;

import javax.naming.ldap.Control;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RENT on 2017-03-01.
 */
public class HelloServlet extends HttpServlet {

    private Map<String, Controller> controllerMap;

    @Override
    public void init() throws ServletException {
        this.controllerMap = new HashMap<String, Controller>();
        this.controllerMap.put("users", new UserController());
        this.controllerMap.put("cookie", new CookieController());
        this.controllerMap.put("login", new UserController());
        this.controllerMap.put("default", (request, response) ->
                response.getWriter().write("<h1>Hello from deafult controller</h1>"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String requestURI = req.getRequestURI();
        String relativePath = requestURI.substring(StringUtils.ordinalIndexOf(requestURI, "/", 2) + 1);
        Map<String, Controller> controllerMap = this.controllerMap;
        Controller controller = controllerMap.get(relativePath);
        if (controller == null) {
            controller = controllerMap.get("default");
        }
        controller.handleGet(req, resp);
    }
}
