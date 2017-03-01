package com.mateusz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by RENT on 2017-03-01.
 */
public interface Controller {
    void handleGet(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
