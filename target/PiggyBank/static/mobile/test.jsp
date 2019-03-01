<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    public static String getDuringDay(int hour){
        if (hour >= 7 && hour < 11) {
            return "上午";
        }if (hour >= 11 && hour <= 13) {
            return "中午";
        }if (hour >= 14 && hour <= 18) {
            return "下午";
        }
        return "晚上";
    }
%>
<%
    Date now = new Date();
    int hours = now.getHours();

    Random random = new Random();
    int x = random.nextInt(9);
    String imageName = "../images/1-"+x+".jpg";
%>
<html>
<head>
    <title>存钱罐</title>
    <style>
        .top{
            width: 100%;
        }
        .top img{
            width: 100%;
            height: 350px;
        }
        .container{
            width: 80%;
            height: 600px;
            background-color: black;
            margin: 10px auto;
        }
        .bottom{
            width: 100%;
            height: 100px;
            background-color: blue;
        }
    </style>
</head>
<body>
    <div>
        <div class="top">
            <img src="<%= imageName%>">
        </div>
        <div class="container"></div>
        <div class="bottom"></div>
    </div>
</body>
</html>
