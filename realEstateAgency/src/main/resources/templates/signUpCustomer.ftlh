<!DOCTYPE html>
<html>
<head>
    <title>Sign up page</title>

    <link href="https://fonts.googleapis.com/css2?family=Kaushan+Script&family=Montserrat:wght@400;700&family=Roboto:ital,wght@0,400;1,300&display=swap" rel="stylesheet">
    
    <style>
        h1{
            text-align: center;
            margin-top: 1px;
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
            margin-top: -10px;
            text-align: center;
        }

    </style>
</head>
<body>

    <h1>Моя квартира</h1>

    <img src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">

    <div class="boxes">
        <h4>Заполните заявку:</h4>

        <form action="/customer/new" method="post">
            Имя: <input type="text" name="name"><br><br>
            Фамилия: <input type="text" name="surname"><br><br>
            Телефон: <input type="text" name="phone"><br><br>

            <input type="submit" value="Оставить заявку!"/>
        </form>
    </div>
</body>
</html>