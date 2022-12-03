<!DOCTYPE html>
<html>
<head>
    <title>Information about requests</title>

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
            display: flex;
            justify-content: center;
        }

        .buyers {
            float: left;
            display: block;
            width: 300px;
            margin: 2px;
        }
            
        .sellers {
            float: left;
            display: block;
            width: 300px;
            margin: 2px;
        }
    </style>
</head>
<body>


<h1>Информация о заявках</h1>
    <img src="http://dgdesign.ru/uploads/posts/2015-11/1446817830_shapka-sayta-gorod.jpg" alt="">
<br><br>
    <div class="boxes">
        <div class="buyers">
            Клиенты:
            <br>
            <#list customers as customer>
                <b>ID клиента: </b>${customer.id}<br>
                <b>Имя: </b>${customer.name}<br>
                <b>Телефон: </b>${customer.phone}<br>
                <br>
            </#list>
        </div>
        <br>
        <div class="sellers">
            Желающие продать:
            <br>
            <#list owners as owner>
                <b>ID клиента: </b>${owner.id}<br>
                <b>Имя: </b>${owner.name}<br>
                <b>Телефон: </b>${owner.phone}<br>
                <br>
            </#list>
        </div>
    </div>
</body>
</html>