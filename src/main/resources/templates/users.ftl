<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    <title>Title</title>
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">Пользователи</div>
    <table border=1>

        <tr>
            <th>ID</th>
            <th>Логин</th>
            <th>Дата рождения</th>

        </tr>

         <#list usersFromServer as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.birthDate}</td>
        </tr>
         </#list>

    </table>
</div>

</body>
</html>
