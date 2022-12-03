<!DOCTYPE html>
<html>
<head>
    <title>Sign up page</title>
    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Montserrat:wght@400;700&family=Roboto:ital,wght@0,400;1,300&display=swap" rel="stylesheet">
    <style>

        h1{
            text-align: center;
            margin-top: 20px;
            font-size: 45px;
        }
        
        body{
            margin: 0;
            color: #333;
	        font-family:'Montserrat', sans-serif;	
            line-height: 1.6; 
        }
        
        img{
            width: 100%;
        }
        
        .boxes{
            text-align: center;
        }

    </style>

</head>
<body>


<h1>Моя квартира</h1>

<img src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">

<div class="boxes">
<h4>Введите данные о квартире, которую хотите продать:</h4>
<form action="/flat/new/${owner.getOwnerByPhone(phone)}" method="post">
    Цена: <input type="number" name="price">
    Количество комнат: <input type="number" name="room">
    Этаж: <input type="number" name="floor"><br><br>
    Площадь: <input type="number" name="surface">
    Адрес: <input type="text" name="address"><br><br>
    Фотография: <input type="text" name="image"><br><br>

    <input type="submit" value="Отправить"/>
</form>
</div>
</body>
</html>