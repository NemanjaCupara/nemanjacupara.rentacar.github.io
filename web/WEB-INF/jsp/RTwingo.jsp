<%@page import="main.Automobili"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Renault Twingo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <body>

        <div id="page">
            <div id="vozniPark">
                <h1>Renault Twingo</h1>
            </div>

            <div id="nav">
                <ul>
                    <li><a href="home">Pocetna</a></li>
                    <li><a href="cars">Vozni Park</a></li>
                    <li><a href="logIn">Login</a></li>

                </ul>	
            </div>
            <div><table style="width:100%">
                    <tr>
                        <th>Proizvodjac</th>
                        <th>Model</th> 
                        <th>Gorivo</th>
                        <th>Menjac</th>
                        <th>KonjskihSnaga</th>
                        <th>Kubikaza(cm3)</th>
                        <th>Broj Vrata</th> 
                        <th>Broj Sedista</th>
                        <th>Cena</th> 
                    </tr>


                    <c:forEach items="${listaAutomobili}" var="automobili">
                        <tr>

                            <td>${automobili.proizvodjac}</td>
                            <td>${automobili.model}</td>
                            <td>${automobili.gorivo}</td>
                            <td>${automobili.menjac}</td>
                            <td>${automobili.konjskihSnaga}</td>
                            <td>${automobili.kubikaza}</td>
                            <td>${automobili.brojVrata}</td>
                            <td>${automobili.brojSedista}</td>
                            <td>${automobili.cena} €</td>

                        </tr>
                    </c:forEach>
                </table>
                <table style="width:80%">
                    <tr>    
                        <th>Renault Twingo</th>
                        <th>Datum uzimanja</th>
                        <th>Datum vracanja</th>
                        <th>Ime</th>
                        <th>Prezime</th>
                        <th>JMBG</th>
                        <th>ID</th>
                        <th>Unesi broj za 1 veci od ID</th>
                    </tr>



                    <tr>
                    <form method="POST" action="Iznajmi">
                        <td><input type="hidden" type="text" name="id" value="1"></td>
                        <td><input type="text" name="datumUzimanja" placeholder="GGGG-MM-DD"></td>
                        <td><input type="text" name="datumVracanja" placeholder="GGGG-MM-DD"></td>
                        <td><input type="text" name="Ime"></td>
                        <td><input type="text" name="Prezime"></td>
                        <td><input type="text" name="JMBG"></td>
                        <c:forEach items="${listaKorisnika}" var="korisnik">
                        <td>${korisnik.id}</td>
                        </c:forEach>
                        <td><input type="text" name="kor" placeholder="ID+1"</td>
                        <td><input type="submit" name="Iznajmi" value="Iznajmi"></td>
                    </form>
                    </tr>


                </table>
                <img src="https://www.carbuyersguide.net/uploaded/nc_images/generations/large/renault-twingo-10.png" style="width:70%">
            </div>

        </div>





    </body>
    <style>
        * {box-sizing: border-box;}
        body {font-family: Verdana, sans-serif;}
        .mySlides {display: none;}
        img {vertical-align: middle;}


        .slideshow-container {
            width: 600px;
            height: 500px;
            position: relative;
            margin: auto;
        }

        .text {
            color: black;
            font-size: 30px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }


        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }


        .dot {
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active {
            background-color: #717171;
        }


        .fade {
            -webkit-animation-name: fade;
            -webkit-animation-duration: 1.5s;
            animation-name: fade;
            animation-duration: 1.5s;
        }

        @-webkit-keyframes fade {
            from {opacity: .4} 
            to {opacity: 1}
        }

        @keyframes fade {
            from {opacity: .4} 
            to {opacity: 1}
        }


        @media only screen and (max-width: 300px) {
            .text {font-size: 11px}
        }
    </style>
    <style>
        table{
            border: 2px solid black;
            padding: 15px;
            text-align: center; 
            vertical-align: middle;
            font-weight: bold;
            font-size: 20px;
        }
        th{
            border: 2px solid black;
            padding: 15px;
            background: #990000;
            color: white;
        }td {
            border: 2px solid black;
            padding: 15px;
            text-align: center; 
            vertical-align: middle;
            font-weight: bold;
            font-size: 15px;
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