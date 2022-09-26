<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Калькулятора</title>
</head>
<body>
<h1>Калькулятора</h1><br/>


<form method="get" action="calcServlet">
    <label>Введите число:
        <input type="text" name="firsNumber"></br>
    </label><br/>
    <label>Введите число:
        <input type="text" name="secondNumber"></br>
    </label><br/>
    <label>Введите арифметическое действие:
        <input type="text" name="op"></br>
    </label>

    <button type="submit">Вычислить</button>
</form>
</body>
</html>