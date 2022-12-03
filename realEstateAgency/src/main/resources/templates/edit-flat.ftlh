<!DOCTYPE html>
<html>
<head>
    <title>Edit flat</title>
</head>
<body>
<h1>Редактирование квартиры</h1><hr>

<br>
<form action="/editFlat/${flat.id}" method="post">
    <b>Количество комнат: </b><input name="room" type="number" value="${flat.room}"><br>
    <b>Площадь: </b><input name="surface" type="number" value="${flat.surface} м2"><br>
    <b>Этаж: </b><input name="floor" type="number" value="${flat.floor}"><br>
    <b>Цена: </b><input name="price" type="number" value="${flat.price}"><br>
    <b>Адрес: </b><input name="address" type="text" value="${flat.address}"><br>
    <b>Фотография: </b><input name="image" type="text" value="${flat.image}"><br>

    <input type="submit" value="Редактировать"/>
</form>

</body>
</html>