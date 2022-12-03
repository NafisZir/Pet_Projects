<!DOCTYPE html>
<html>
<head>
    <title>Information about flat</title>
</head>
<body>
<h1>Информация о квартире</h1><hr>

<br>
<div>
    <img src="${flat.image}" height="500px">
</div>
<b>Количество комнат: </b>${flat.room}<br>
<b>Площадь: </b>${flat.surface} м2<br>
<b>Этаж: </b>${flat.floor}<br>
<b>Цена: </b>${flat.price}<br>
<b>Адрес: </b>${flat.address}<br>

<form action="/signupcustomer" method="get">
    <input type="submit" value="Посмотреть квартиру"/>
</form>

</body>
</html>