package com.example.ibs;

import com.example.ibs.logic.Model;

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


@WebServlet(urlPatterns = "/servletList")
public class ServletList extends HttpServlet {

    Model model = Model.getInstance();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer sb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.print("ERROR");
        }

        JsonObject json = gson.fromJson(String.valueOf(sb), JsonObject.class);

        request.setCharacterEncoding("utf-8");

        int id = json.get("id").getAsInt();

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        if (id == 0) {
            pw.print(gson.toJson(model.getList()));
        } else if (id > 0) {
            if (id > model.getList().size()) {
                pw.print(gson.toJson("NO SUCH USER IN DATABASE"));
            } else {
                pw.print(gson.toJson(model.getList().get(id)));
            }
        }

    }


//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        response.setContentType("text/html;charset=utf-8");
//        PrintWriter pw = response.getWriter();
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        if (id == 0) {
//            pw.print("<html>" +
//                    "<h3>Доступные пользователи</h3><br/>" +
//                    "ID пользователя: " +
//                    "<ul>");
//
//            for (Map.Entry<Integer, User> entry : model.getList().entrySet() ) {
//                pw.print("<li>" + entry.getKey() + "</li>" +
//                        "<ul>" +
//                        "<li>Имя: " + entry.getValue().getName() + "</li>" +
//                        "<li>Фамилия: " + entry.getValue().getSurname() + "</li>" +
//                        "<li>Зарплата: " + entry.getValue().getSalary() + "</li>" +
//                        "</ul>");
//            }
//
//            pw.print("</ul>" +
//                    "<a href=\"index.jsp\">Домой</a>" +
//                    "</html>" );
//        } else if (id > 0) {
//            if (id > model.getList().size()) {
//                pw.print("<html>" +
//                        "<h3>Такого пользователя нет</h3><br/>" +
//                        "<a href=\"index.jsp\">Домой</a>" +
//                        "</html>");
//            } else {
//                pw.print("<html>" +
//                        "<h3>Запрошенный пользователь:</h3><br/>" +
//                        "Имя: " + model.getList().get(id).getName() + "<br/>" +
//                        "Фамилия: " + model.getList().get(id).getSurname() + "<br/>" +
//                        "Зарплата: " + model.getList().get(id).getSalary() + "<br/>" +
//                        "<a href=\"index.jsp\">Домой</a>" +
//                        "</html>");
//            }
//        } else {
//            pw.print("<html>" +
//                    "<h3>ID должен быть больше 0!</h3><br/>" +
//                    "<a href=\"index.jsp\">Домой</a>" +
//                    "</html>");
//        }
//    }

}
