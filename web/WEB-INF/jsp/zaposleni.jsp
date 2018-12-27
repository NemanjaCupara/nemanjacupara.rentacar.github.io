<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Zaposleni</title>
    </head>

    <body>
        <div id="page">

            <div id="nav">
                <ul>
                    <li><a href="nZap">Novi Zaposleni</a></li> 
                </ul>	
            </div>
            <h1 id="Login">Zaposleni</h1>
            <table style="width:100%">
                <tr>
                    <th>Ime</th>
                    <th>Prezime</th>
                    <th>Pozicija</th>
                    <th>Username</th>
                    <th>Password</th>
                </tr>
                <c:forEach items="${listaZaposleni}" var="zaposleni">

                    <tr>
                        <td>${zaposleni.ime}</td>
                        <td>${zaposleni.prezime}</td>
                        <td>${zaposleni.pozicija}</td>
                        <td>${zaposleni.username}</td>
                        <td>${zaposleni.password}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
    <style>
        table,  td {
            border: 2px solid black;
            padding: 15px;
            text-align: center; 
            vertical-align: middle;
            font-weight: bold;
        }
        th{
            border: 2px solid black;
            padding: 15px;
            background: #990000;
            color: white;
        }
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
