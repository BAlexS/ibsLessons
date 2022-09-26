package com.example.ibs;

import com.example.ibs.logic.Model;
import com.example.ibs.logic.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(urlPatterns = "/servletAdd")
public class ServletAdd extends HttpServlet {

    private AtomicInteger counter = new AtomicInteger(5);
    Model model = Model.getInstance();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//
//        request.setCharacterEncoding("UTF-8");
//        PrintWriter pw =response.getWriter();
//
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        double salary = Double.parseDouble(request.getParameter("salary"));
//
//        User user = new User(name, surname, salary);
//        model.add(counter.getAndIncrement(), user);
//
//        pw.print("<html>" +
//                "<h3>Пользователь " + name + " " + surname + " " + salary + " успешно создан! :)</h3>" +
//                "<a href=\"addUser.html\">Создать нового пользователя</a><br/>" +
//                "<a href=\"index.jsp\">Домой</a>" +
//                "</html>");
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        StringBuffer sb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject json = gson.fromJson(String.valueOf(sb), JsonObject.class );

        request.setCharacterEncoding("utf-8");

        String name = json.get("name").getAsString();
        String surname = json.get("surname").getAsString();
        double salary = json.get("salary").getAsDouble();

        User user = new User(name, surname, salary);
        model.add(counter.getAndIncrement(), user);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        pw.print(gson.toJson(model.getList()));

    }

}
