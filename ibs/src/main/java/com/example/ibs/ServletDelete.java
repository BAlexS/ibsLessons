package com.example.ibs;

import com.example.ibs.logic.Model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servletDelete")
public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Model model = Model.getInstance();

        response.setContentType("text/html;charset=utf-8");

        request.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));

        if (id > 0) {
            if (id > model.getList().size()) {
                pw.print("<html>" +
                        "<h3>Такого пользователя нет</h3><br/>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            } else {
                String name = model.getList().get(id).getName();
                String surname = model.getList().get(id).getSurname();
                double salary = model.getList().get(id).getSalary();

                model.doDelete(id);

                pw.print("<html>" +
                        "<h3>Пользователь " + name + " " + surname + " " + salary + " успешно удален :)</h3>" +
                        "<a href=\"index.jsp\">Домой</a>" +
                        "</html>");
            }

        }

    }


}
