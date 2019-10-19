<%--
  Created by IntelliJ IDEA.
  User: 国瑚
  Date: 2019/10/17
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" name="viewport">
    <title>广东药科大学成绩查询</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        /*		@font-face{
                font-family:'FontAwesome';
                src:url('./fonts/fontawesome-webfont.eot');
                src:url('./fonts/FontAwesome.otf');
                src:url('./fonts/fontawesome-webfont.svg');
                src:url('./fonts/fontawesome-webfont.ttf');
                src:url('./fonts/fontawesome-webfont.woff');
                src:url('./fonts/fontawesome-webfont.woff2');
                font-weight:normal;
                font-style:normal;
            }*/
        body{
            background:#EFEFEF;
        }
        /*	    #logo_xx,#logo_yb {
                     margin-left: 20px;
                     text-decoration: none;
                }*/
        h1{
            height: 85px;
            text-align: center;
            background-color:#00A5ED;
            font-weight: bold;
            line-height: 85px;
            font: '微软雅黑','黑体',sans-serif ;
            color: #EEE2E2;
            border-radius: .5em;
        }
        nav li {
            float: left;
            list-style: none;
            line-height: 80px;
            margin-left: 20px;
        }
        .navi{
            text-decoration: none;
            color: #00A5ED;
            font: '微软雅黑','黑体',sans-serif;
            font-size: 20px;
            cursor: pointer;
        }
        #container {
            background:#EFEFEF;
            width: 100%;
            height: 600px;
            margin: 0 auto;
            position: absolute;
            top: 80px;
        }
        #login{
            margin: auto auto;
            text-align: center;
        }
        fieldset {
            height: 60%;
            font-size: 25px;
        }
        legend{
            margin-left: 20px;
        }
        #footer h2{
            text-align: center;
            font-size: 18px;
        }
        #footer a{
            text-decoration: none;
            color: black;
        }
        #footer a:hover{
            color: blue;
        }
        .buts:hover {
            color: black;
            cursor: pointer;
        }
        .buts input{
            margin-left: 15%;
            width: 80px;
            padding-right: 2px;
            border-radius: .2em;
            background-color: #00A5ED;
            color: white;
            font-size: 15px;
            text-align: center;
        }
        .user_login {
            width: 320px;
            padding: 1px;
            border: 1px solid #DBDBD0;
            background-color: #FFFFFF;
            margin: 0 auto;
            margin-top: 15%;
            border-radius: .3em;
        }
        .user_login * {
            margin: 0;
            padding: 0;
            font: normal 20px/1.5em "宋体" ,Verdana,Lucida,Arial,Helvetica,sans-serif;
        }
        .user_login h3 {
            height: 44px;
            line-height: 44px;
            font-weight: bold;
            text-align: center;
            background-color: #00A5ED;
            border-radius: .3em;
            font-size: 25px;
            color: #EEE2E2;
        }
        .user_login .content {
            padding: 5px;
        }
        @media screen and (max-width: 640px) {
            .user_login {
                width: 316px;
                margin-top: 65px;
            }
            h1{
                height: 65px;
                text-align: center;
                background-color:#00A5ED;
                font-weight: bold;
                font-size:20px;
                line-height: 65px;
                font: '微软雅黑','黑体',sans-serif ;
                color: #EEE2E2;
                border-radius: .5em;
            }
        }
        .user_login .frm_cont {margin-bottom: 5px;}
        .user_login .frm_cont label {cursor: pointer;}
        .user_login .number input,.user_login .password input,.user_login .xn input,.user_login .xq input{
            width: 205px;
            height: 27px;
            padding: 3px 2px 0;
            border: 1px solid #A9A98D;
        }
    </style>

</head>
<body>
<div>
    <%
        Integer applicationCount = (Integer) application.getAttribute("applicationCount");
        if (applicationCount == null) {
            applicationCount = 0;
        }
        applicationCount = applicationCount + 1;
        application.setAttribute("applicationCount", applicationCount);
    %>
<header >
    <nav >
        <ul>
            <li>
                <a href="http://www.yiban.cn/mobile/index.html" target="_blank" class="navi" title="电脑用户下载手机易班app,就能在手机上查成绩了哦">
                    易班App
                </a>
            </li>
            <li>
                <a href="https://www.yooc.me/mobile/yooc_courses" target="_blank" class="navi" title="进入后有免费的教程哦">
                    易班优课
                </a>
            </li>
            <li>
                <a href="https://mp.weixin.qq.com/s/LobKKfwLMTWLrwzrkG7gBQ" target="_blank" class="navi" title="进入后扫码即可关注我们的公众号哦">
                    公众号推文
                </a>
            </li>
        </ul>
    </nav>
</header>
<div id="container">
    <h1>广东药科大学成绩查询系统</h1>
    <fieldset style="margin-right: auto;margin-left: auto;min-height: 100px;">
        <!--<legend>
            <h5><a href="http://www.gdpu.edu.cn/" target="_blank"><img src="logo2.png" alt="gdpu" width="100px" height="100px"></a></h5>
        </legend> -->
        <legend style="text-align: right;font-size: 15px">当前访问量：<%= applicationCount%></legend>
        <div class="user_login">
            <h3>学生登录</h3>
            <div class="content">
                <form action="infoView.jsp" method="post" name="form1">
                    <div class="frm_cont number">
                        <label for="number">学号：</label>
                        <input type="text" name="yhm" id="yhm" pattern="[0-9]{10}" title="请输入正确的学号" placeholder="请输入学生学号">
                    </div>
                    <div class="frm_cont password">
                        <label for="password">密码：</label>
                        <input type="password" name="mm" id="mm" required="required" title="请输入密码" placeholder="请输入教务系统密码">
                    </div>
                    <div class="frm_cont buts">
                        <input type="submit" value="立即查询" class="buts">
                        <input type="button" class="buts" value="刷新本页" onclick="location.reload();">
                    </div>
                </form>
            </div>
        </div>
    </fieldset>

    <div id="footer" style="display: flow-root ; postion:fixed;bottom:0;" >
        <div><h2>&copy;&nbsp;&nbsp;2019&nbsp;&nbsp;<a href="http://www.yiban.cn" target="_blank">广东药科大学易班学生工作站</a></h2></div>
    </div>
    <div>

    </div>
</div>



</body>
</html>
