<!DOCTYPE html>
<html>
<head>
    <title>Show all the deals</title>

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
    <h1>Сделки</h1>

        <img src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">

    <div class="boxes">
     <#list deals as deal>
        <p><a href="/deal-info/${deal.id}">Сделка ID ${deal.id}</a></p>
        <form action="/deleteDeal/${deal.id}" method="post">
            <input type="submit" value="Удалить сделку"/>
        </form>
        <br>
     </#list>
    </div>

    <form action="/employee" method="get">
        <input type="submit" value="На главную"/>
    </form>
</body>
</html>