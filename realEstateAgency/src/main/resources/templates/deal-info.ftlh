<!DOCTYPE html>
<html>
<head>
    <title>Information about deal</title>

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
        
        .fon{
            width: 100%;
        }
        
        .boxes{
            margin-top: -10px;
            text-align: center;
            text-decoration: none;
        }
        .about_buying{
            text-align: center;
        }
    </style>
</head>
<body>
<h1>Информация о сделке</h1>

    <img class="fon" src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">

<div class="about_buying">
    <b>Номер сделки: </b>${deal.id}<br>
    <b>Дата: </b>${deal.date}<br>
    <b>Покупатель: </b>${customer}<br>
    <b>Риэлтор: </b>${employee}<br>
    <b>Квартира: </b><a href="/flat-info/${flat.id}">${flat.address}</a><br>

    <form action="/deleteDeal/${deal.id}" method="post">
        <input type="submit" value="Удалить сделку">
    </form>
    <form action="/deal/show" method="get">
        <input type="submit" value="Назад"/>
    </form>
</div>
</body>
</html>