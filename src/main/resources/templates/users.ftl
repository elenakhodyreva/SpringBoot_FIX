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
<br><br>
<div class="form-style-2">
    <div class="form-style-2-heading">Редактировать данные о пользователе</div>
    <form method="POST" action="/users" accept-charset="UTF-8">

        <table>
            <tr><td>Логин</td><td><input type= "text" name="newName"  maxlength="50"
                                         required id="newName"/>
            </td></tr>

            <tr><td>Новый пароль</td><td><input type= "text" name="newPassword" maxlength="50"
                                                required id="newPassword"/>
            </td></tr>

        </table>
        </br></br>
        <input type= 'submit' value= 'Редактировать'/>
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">Удалить пользователя</div>
    <form method="POST" action="/users" accept-charset="UTF-8">

        <table>
            <tr><td>ID</td><td><input type= "text" pattern="\d*" name="userIdDelete" maxlength="4"
                                      required id="userIdDelete"/>
            </td></tr>
        </table>

        </br></br>
        <input type= 'submit' value= 'Удалить'/>
    </form>
</div>

</body>
</html>
