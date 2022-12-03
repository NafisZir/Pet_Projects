<!DOCTYPE html>
<html>
<head>
    <title>Creating new deal</title>

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

        .container{
            display: flex;
            justify-content: center;
        }

        .clients {
            float: left;
            display: block;
            width: 300px;
            margin: 2px;
        }
            
        .flats {
            float: left;
            display: block;
            width: 300px;
            margin: 2px;
        }
    

    </style>
</head>
<body>

<h1>Сделка</h1>

    <img src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">

        <div class="boxes">
            <h4>Заполните поля:</h4>

            <form action="/deal/create" method="post">
                ID квартиры : <input type="text" name="flatId"><br><br>
                ID клиента: <input type="text" name="customerId"><br><br>
                Дата: <input type="text" name="date"><br><br>

                <input type="submit" value="Создать сделку"/>
            </form>
        </div>

        <div class="container">
            <div class="clients">
                Клиенты:
                <br>
                <#list customers as customer>
                    <b>ID клиента: </b>${customer.id}<br>
                    <b>Имя: </b>${customer.name}<br>
                    <b>Телефон: </b>${customer.phone}<br>
                    <br>
                </#list>
            </div>

            <div class="flats">
                Квартиры:
                <br>
                <#list flats as flat>
                    <b>ID квартиры: </b>${flat.room}<br>
                    <b>Количество комнат: </b>${flat.room}<br>
                    <b>Площадь: </b>${flat.surface} м2<br>
                    <b>Этаж: </b>${flat.floor}<br>
                    <b>Цена: </b>${flat.price}<br>
                    <b>Адрес: </b>${flat.address}<br>
                    <br>
                </#list>
            </div>
        </div>
</body>
</html>