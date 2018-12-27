<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>

    <head>
        <title>Rent a Car</title>

    </head>
    <body>

        <div id="page">
            <div id="logo">
                <h1>Rent a Car</h1>
            </div>
            <div id="nav">
                <ul>
                    <li><a href="cars">Vozni Park</a></li>
                    <li><a href="logIn">Login</a></li>
                </ul>	
            </div>
            <div id="content">
                <h2>Dobrodosli na zvanicnu stranicu firme Rent a Car</h2>
                <div class="dropdown">
                    <button class="dropbtn">Proizvodjac</button>
                    <div class="dropdown-content">
                        <c:forEach items="${listaProizvodjac}" var="proizvodjac">
                            <a href="cars">${proizvodjac.ime}</a>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div id="ta2">
                <h2>Unesi komentar</h2>

                <table style="width:100%">
                    <tr>
                        <th>Ime</th>
                        <th>Komentar</th>

                    </tr>
                    <tr>
                    <form action="unesi">
                        <td><input type="text" name="ime"size="15"></td>
                        <td><input type="text" name="komentar" size="50"></td>

                        <td><input type="submit" name="submit" value="Unesi" ></td>
                    </form>
                    </tr>
                </table>
            </div>
            <div id="ta1">
                <h2>Komentari korisnika</h2>
                <table style="width:100%">
                    <tr>
                        <th>Ime</th>
                        <th>Komentar</th>

                    </tr>
                    <c:forEach items="${listaKomentara}" var="komentar">
                        <tr>
                            <td>${komentar.ime}</td>
                            <td>${komentar.komentar}</td>

                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>


    </body>
    <style>
        table,  td {
            border: 1px solid black;
            padding: 10px;
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
        #ta1{
            padding: 5%;
            float: right;}
        #button{
            font-size: 1.2em;
            width: 20%;
            float: right;
            padding: 10px;
            background: #990000;
            color: white;}
        #button:hover{background-color: #ff3333;
                      box-shadow: 0px 1px 1px #666;}
        #button:active{ background-color: #ff3333; }
        #ta2{
            padding: 2.3%;
            float: left;}
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
