<#ftl encoding='UTF-8'>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/css/styles.css" type="text/css"/>
    <title>Title</title>
</head>
<body>
<#if user ??>
    <div class="form-style-2-heading">Здравствуйте, ${user.name}!</div>
</#if>

<div class="form-style-2">
    <div class="form-style-2-heading">Книги</div>
    <table border=1>
        <thead>
        <tr>
            <th>ID книги</th>
            <th>Название</th>
            <th>Автор</th>
            <th>Количество</th>
            <th>Стоимость</th>

        </tr>
        </thead>
        <tbody>
        <#list booksFromServer as book>
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.author.authorName}</td>
                <td>${book.count}</td>
                <td>${book.cost}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</br></br>

<div class="form-style-2">
    <div class="form-style-2-heading">Добавить книгу</div>
    <form method="POST" action="/books" accept-charset="UTF-8">

        <table>
            <tr><td>Название книги</td><td><input type= "text" name="name"  maxlength="50" required id="name"/>
            </td></tr>

            <tr><td>Автор</td><td><input type= "text" name="author"  maxlength="50" required id="author"/>
            </td></tr>

            <tr><td>Количество</td><td><input type= "text" pattern="\d*" name="count" maxlength="4" required id="count"/>
            </td></tr>

            <tr><td>Стоимость, руб</td><td><input type= "text" pattern="\d*" name="cost" maxlength="7" required id="cost"/>
            </td></tr>

        </table>


        </br></br>
        <input type= 'submit' value= 'Добавить'/>


    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">Редактировать данные о книге</div>
    <form method="POST" action="/books?upd" accept-charset="UTF-8">

        <table>

            <tr><td>Название книги</td><td><input type= "text" name="name"  maxlength="50"
                                                  required id="name"/>
            </td></tr>

            <tr><td>Стоимость, руб</td><td><input type= "text" pattern="\d*" name="cost" maxlength="7"
                                                  required id="cost"/>
            </td></tr>

        </table>


        </br></br>
        <input type= 'submit' value= 'Редактировать'/>
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">Удалить книгу</div>
    <form method="POST" action="/books?del" accept-charset="UTF-8">

        <table>
            <tr><td>ID</td><td><input type= "text" pattern="\d*" name="id" maxlength="4"
                                      required id="id"/>
            </td></tr>
        </table>


        </br></br>
        <input type= 'submit' value= 'Удалить'/>
    </form>
</div>

</body>
</html>
