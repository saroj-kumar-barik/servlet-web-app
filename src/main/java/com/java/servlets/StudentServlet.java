package com.java.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentServlet extends HttpServlet {
    public StudentServlet() {
//      getServletContext().log("constructors...");
        System.out.println("constructor");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hashcode "+this.hashCode());
        getServletContext().log("hashcode "+this.hashCode());
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("This is my first servlet program");
    }

    // Life Cycle of Servlet 1. Init 2. Service 3. destroy

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("param based init "+ this.getClass());
        config.getServletContext().log("param based init "+ this.getClass());
        super.init(config);
    }
    @Override
    public void init() throws ServletException {
        getServletContext().log("0 param based init "+this.getClass());
        System.out.println("0 param based init "+this.getClass());
    }
//
    @Override
    public void destroy() {
        super.destroy();
        getServletContext().log("destroy is executing: "+this.getClass());
        System.out.println("destroy is executing: "+this.getClass());
    }
//
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().log("service is executing");
        System.out.println("service is executing");
        super.service(req, resp);
    }
}
