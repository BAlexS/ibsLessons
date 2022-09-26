<%@ page import="com.example.ibs.logic.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Домашняя страница</title>
</head>
<body>
<h1>Домашняя страница по работе с пользователями</h1>
Введите ID - пользователя (0 - для вывода всего списка пользователей)
</br>

Доступно:
<% Model model = Model.getInstance();
    out.print( model.getList().size()); %>


<form method="get" action="servletList">
    <label>ID:
        <input type="text" name="id"></br>
    </label>

    <button type="submit">Поиск пользователя</button>
</form>

<a href="addUser.html">Создать нового пользователя</a><br/>
<a href="deleteUser.html">Удалить текущего пользователя</a><br/>
<a href="putUser.html">Обноваить текущего пользователя</a>
</body>
</html>