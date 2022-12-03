<!DOCTYPE html>
<html>
<head>
    <title>Log in for employee</title>
    
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
            
            <h4>Авторизация</h4>

            <form action="/employee/check" method="post">
            Имя: <input type="text" name="name"><br><br>
            Пароль: <input type="text" name="password"><br><br>

            <input type="submit" value="Войти"/>
            </form>
        
        </div>
</body>
</html>