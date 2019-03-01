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
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>首页</title>

    <style>
        * {margin: 0;padding: 0}
        body{background-color: white;}
        #calendar {width: 98%;margin: 0 auto;overflow: hidden;border: 1px solid white;border-radius:3%;padding: 10px 0 30px 0;position: relative;background-color: #00CCFF;color: white;}
        #calendar h4 {text-align: center;margin-bottom: 10px;border-bottom: 1px solid #000;padding-bottom: 10px;border-color: white;}
        #calendar .a1 {position: absolute;top: 20px;left: 20px;}
        #calendar .a2 {position: absolute;top: 20px;right: 20px;}
        #calendar .week {height: 30px;line-height: 20px;}
        #calendar .week li {float: left;width: 14%;height: 30px;text-align: center;list-style: none;}
        #calendar .dateList {overflow: hidden;clear: both}
        #calendar .dateList li {float: left;width: 14%;height: 30px;text-align: center;line-height: 30px;list-style: none;}
        #calendar .dateList .ccc {color: #ccc;}
        #calendar .dateList .red {background: #F90;color: #fff;}
        #calendar .dateList .sun {color: #f00;}
        .lastMonth,.nextMonth{color:#C0C0C0;}
        .circle{color:white;background-color:#00CCFF;border-radius: 50%;-moz-border-radius: 50%;-webkit-border-radius: 50%;}
        .top{
            width: 100%;
        }
        .top img{
            width: 100%;
            height: 200px;
        }
        .container{
            width: 90%;
            height: 337px;
            margin: 4% auto;
        }
        .bottom{
            width: 100%;
            height: 100px;
            background-color: blue;
        }
    </style>

    <script type="text/javascript" src="../js/jquery-1.7.1.js"></script>
</head>
<body>
    <div>
        <div class="top">
            <img src="<%= imageName%>">
        </div>
        <div class="container">
            <div id="calendar">
                <h4>2013年10月</h4>
                <%--<a href="##" class="a1">上月</a>--%>
                <%--<a href="##" class="a2">下月</a>--%>
                <ul class="week">
                    <li>日</li>
                    <li>一</li>
                    <li>二</li>
                    <li>三</li>
                    <li>四</li>
                    <li>五</li>
                    <li>六</li>
                </ul>
                <ul class="dateList"></ul>
            </div>
        </div>
        <div class="bottom"></div>
    </div>
</body>
</html>
<script>
    var iNow=0;

    $(function(){
        //必要的数据
        //今天的年 月 日 ；本月的总天数；本月第一天是周几？？？
        run(0);
    });

    function run(n) {

        var oDate = new Date(); //定义时间
        oDate.setMonth(oDate.getMonth()+n);//设置月份
        var year = oDate.getFullYear(); //年
        var month = oDate.getMonth(); //月
        var today = oDate.getDate(); //日

        //计算本月有多少天
        var allDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];

        // var lastMonth;
        // if(month !=0){
        //     lastMonth = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month-1];
        // }else{
        //     lastMonth = 31;
        // }

        //判断闰年
        if(month == 1) {
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                allDay = 29;
            }
        // }else if(month == 2){
        //     if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        //         lastMonth = 29;
        //     }
        }

        //判断本月第一天是星期几
        oDate.setDate(1); //时间调整到本月第一天
        var week = oDate.getDay(); //读取本月第一天是星期几

        //console.log(week);
        $(".dateList").empty();//每次清空
        //插入空白
        for(var i = 0; i < week; i++) {
            //本月第一天
            // var lastMonthLastDay = lastMonth - week + i +1;
            // $(".dateList").append("<li onclick='lastMonthClick()' class='lastMonth'>"+lastMonthLastDay+"</li>");
            $(".dateList").append("<li></li>");
        }

        //日期插入到dateList
        for(var i = 1; i <= allDay; i++) {
            $(".dateList").append("<li>" + i + "</li>")
        }

        /*var nextDays = 7-(allDay+week)%7;
        for(var i = 1 ; i <= nextDays ; i++){
            $(".dateList").append("<li onclick='nextMonthClick()' class='nextMonth'>" + i + "</li>")
        }*/

        //标记颜色=====================
        $(".dateList li").each(function(i, elm){
            //console.log(index,elm);
            var val = $(this).text();
            //console.log(val);
            if (n==0) {
                if(val==today){
                    // if(!$(this).hasClass("lastMonth")&&!$(this).hasClass("nextMonth")){
                    //     $(this).addClass('circle');
                    // }
                    $(this).addClass('circle');
                }else if(i%7==0  ||  i%7==6   ){
                    // if(!$(this).hasClass("lastMonth")&&!$(this).hasClass("nextMonth")){
                    //     $(this).addClass('sun');
                    // }
                    $(this).addClass('sun');
                }
            }else if(i%7==0  ||  i%7==6   ){
                // if(!$(this).hasClass("lastMonth")&&!$(this).hasClass("nextMonth")){
                //     $(this).addClass('sun');
                // }
                $(this).addClass('sun');
            }
        });

        //定义标题日期
        $("#calendar h4").text(year + "年" + (month + 1) + "月");
    };

    /*$(".a1").click(function(){
        iNow--;
        run(iNow);
    });

    $(".a2").click(function(){
        iNow++;
        run(iNow);
    })
    function lastMonthClick(){
        iNow--;
        run(iNow);
    }
    function nextMonthClick(){
        iNow++;
        run(iNow);
    }*/
</script>
