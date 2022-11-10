<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Вход в ЛК</title>
</head>
<body>
<form>
    <p>
        <label for="login">Логин: </label>
        <input type="text" id="login" name="login" />
    </p>
    <p>
        <label for="password">Пароль: </label>
        <input type="password" id="password" name="password" />
    </p>
    <p>
        <button type="submit" formmethod="get" formaction="http://localhost:8080/entry">Отправить</button>
    </p>
</form>
</body>
</html>