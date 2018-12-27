<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>

    </head>
    <body>
        <div id="page">

            <div id="nav">
                <ul>
                    <li><a href="home">Pocetna</a></li>
                    <li><a href="cars">Vozni Park</a></li>
                </ul>	
            </div>
            <div class="login-box">
                <img src="https://nextsexshop.com/images/user-avatar-main-picture.svg" class="avatar">
                <h1 id="Login">Login</h1>
                <h3 class="zaZaposlene"><strong> SAMO ZA ZAPOSLENE! </strong></h3><br>
                <form method="POST" action="rent">
                    <p>Username</p>
                    <input type="text" name="username" placeholder="Unesi Username">
                    <p>Password</p>
                    <input type="password" name="password" placeholder="Unesi Password" >
                    <input type="submit" name="submit" value="Login">

                </form>
            </div>
        </div>
    </body>
    <style>
        body{
            margin: 0;
            padding: 0;
            background: linear-gradient(to bottom, #999966 0%, #ffff99 100%);
            background-size: cover;
            background-position: center;
            font-family: sans-serif;
        }
        .zaZaposlene{
            background: #990000;
            color: white;
            font-size: 1.3em;
            padding: 5px;
        }
        .login-box{
            width: 320px;
            height: 420px;
            background: rgba(0, 0, 0, 0.5);
            color: #fff;
            top: 50%;
            left: 50%;
            position: absolute;
            transform: translate(-50%,-50%);
            box-sizing: border-box;
            padding: 70px 25px;
        }
        .avatar{
            width: 100px;
            height: 100px;
            border-radius: 50%;
            position: absolute;
            top: -50px;
            left: calc(50% - 50px);
        }
        h1{
            margin: 0;
            padding: 0 0 20px;
            text-align: center;
            font-size: 22px;
        }
        h3{
            margin: 0;
            padding: 0 0 20px;
            text-align: center;
            font-size: 15px;
        }
        #Login{
            color:white;
            margin: 0;
            padding: 0 0 20px;
            text-align: center;
            font-size: 40px;
        }

        .login-box p{
            margin: 0;
            padding: 0;
            font-weight: bold;
        }
        .login-box input{
            width: 100%;
            margin-bottom: 20px;
        }
        .login-box input[type="text"], input[type="password"]
        {
            border: none;
            border-bottom: 1px solid #fff;
            background: transparent;
            outline: none;
            height: 40px;
            color: #fff;
            font-size: 16px;
        }
        .login-box input[type="submit"]
        {
            border: none;
            outline: none;
            height: 40px;
            background: #990000;
            color: #fff;
            font-size: 18px;
            border-radius: 20px;
        }
        .login-box input[type="submit"]:hover
        {
            cursor: pointer;
            background: #ff3333;
            color: #000;
        }

        .login-box a{
            text-decoration: none;
            font-size: 14px;
            color: #fff;
        }
        .login-box a:hover
        {
            color: #ff3333;
        }

    </style>
    <style>
        p{ line-height: 1em; }
        h1, h2, h3, h4{
            color: #990000;
            font-weight: normal;
            line-height: 1.1em;
            margin: 0 0 .5em 0;
        }
        h1{ font-size: 3.0em; }
        h2{ font-size: 1.5em; }
        a{
            color: black;
            text-decoration: none;
        }
        a:hover,
        a:active{ text-decoration: none; }


        body{
            font-family: arial; font-size: 80%; line-height: 1.2em; width: 100%; margin: 0; background: #eee;
            background-image: url("http://hdblackwallpaper.com/wallpaper/2015/07/red-and-white-wallpaper-18-background-wallpaper.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        #page{ margin: 12px; }


        #logo{
            width: 35%;
            margin-top: 10px;
            margin-left: 5px;
            font-family: georgia;
            display: inline-block;
        }

        #nav{
            width: 60%;
            display: inline-block;
            text-align: right;
            float: right;
            font-size: 1.2em;
        }
        #nav ul{}
        #nav ul li{
            display: inline-block;
            height: 65px;
        }
        #nav ul li a{
            padding: 20px;
            background: #990000;
            color: white;
        }
        #nav ul li a:hover{
            background-color: #ff3333;
            box-shadow: 0px 1px 1px #666;
        }
        #nav ul li a:active{ background-color: #ff3333; }

        #content{
            margin: 30px 0;
            background: white;
            padding: 20px;
            clear: both;
        }
        #footer{
            border-bottom: 1px #ccc solid;
            margin-bottom: 10px;
        }
        #footer p{
            text-align: right;
            text-transform: uppercase;
            font-size: 80%;
            color: grey;
        }


        #content,
        ul li a{ box-shadow: 0px 1px 1px #999; }

        body,html{
            margin:0;
            padding:0;
            height:100%;
        }


        #vozniPark{
            width: 35%;
            margin-top: 10px;
            margin-left: 30px;
            font-family: georgia;
            display: inline-block;
        }
        .dropbtn {
            background-color: #990000;
            color: white;
            padding: 16px;
            font-size: 20px;
            border: none;
            cursor: pointer;
        }

        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {background-color: #990006;
                                   color: white;       
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        .dropdown:hover .dropbtn {
            background-color: #990000;
        }

    </style>
</html>

