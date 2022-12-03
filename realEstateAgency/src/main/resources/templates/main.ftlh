<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>

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

        .boxes_item{
            text-align: left;
            padding-left: 15px;
        }

        .sell_buy_btn{
            text-decoration: none;
            display: inline-block;
            vertical-align: top;
            margin: 0 15px;
        }

        a{
            text-decoration: none;
            padding-left: 10px;
        }
    </style>
</head>
<body>

<h1>Моя квартира</h1>

    <div class="sell_buy_btn">
        <a href="/signupcustomer">Приобрести</a>
        <a href="/signupowner">Продать</a>
        <a href="/employee/login">Сотрудникам</a>     
    </div>
    <img class="fon" src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">
    
    <div class="boxes">

    <h4>Наши предложения:</h4>
        <form action="flat/find" method="get">
            <b>Найти квартиру по адресу:</b><input name="address" type="text" >

            <input type="submit" value="Найти"/>
        </form>
        <br>
        <div class="boxes_item">
            <#list flats as flat>
                <img src="${flat.image}" height="200px">
                <p><a href="/flat-info/${flat.id}">Квартира ${flat.room}-комнатная, ${flat.surface}м2</a></p>
            </#list>
        </div>
    </div>
</body>
</html>