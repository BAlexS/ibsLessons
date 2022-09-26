package com.example.calcservlet;

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
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/calcServlet")
public class calcServlet extends HttpServlet {
    Map<String, Integer> map  = new HashMap<String, Integer>();
    {
        map.put("result", 0);
    }


    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        StringBuffer jb = new StringBuffer();
        String line;

        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.print("Error");
        }

        JsonObject json = gson.fromJson(String.valueOf(jb), JsonObject.class);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();

        int result = 0;
        int theFirst = json.get("firstNumber").getAsInt();
        int theSecond = json.get("secondNumber").getAsInt();
        char operation = json.get("op").getAsCharacter();

        if (operation == '*') {
            result = theFirst * theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '+') {
            result = theFirst + theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '-') {
            result = theFirst - theSecond;
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '|') {
            result = (int)(theFirst / theSecond);
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else if (operation == '%') {
            result = (int)(theFirst % theSecond);
            map.put("result", result);
            pw.print(gson.toJson(map));

        } else {
            pw.print(gson.toJson("Invalid operation"));
        }

    }
}
