<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/7/2021
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Menu Page</title>

    <!-- Bootstrap core CSS -->
    <link href="Template/css-3/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS for the '3 Col Portfolio' Template -->
    <link href="Template/css-3/3-col-portfolio.css" rel="stylesheet">

<%--    ajax--%>
</head>

<body>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="pageforward" style="font-size: 30px; color: chartreuse;"> QD FOOD</a>
        </div>

    </div>
    <!-- /.container -->
    <div class="nav-search" id="nav-search" style="margin-left: 1150px;">
        <form name="myform" action="homecontroller" method="post">
            <input  type="text" placeholder="Bạn muốn nấu món gì?" style="border-radius: 10px;height: 40px;width: 230px;border: none" name="namefood"/>
            <input type="submit" value="Tìm kiếm" style="border-radius: 5px; border: none;height: 40px;background-color: #00adef"/>
        </form>
    </div>
    <!-- /.nav-search -->
</nav>

<div class="container">

    <div class="row">

        <div class="col-lg-12">
            <h1 class="page-header">Danh Sách Món Ăn
                <small>Thông tin lấy về từ vnexpress.net</small>
            </h1>
        </div>

    </div>
    <p> ${messfind}</p>
    <div class="row">
        <c:forEach items="${list}" var="list">
            <div class="col-md-4 portfolio-item">
                <a href="#project-link">
                    <img class="img-responsive" src="Template/images/features.jpg">
                </a>
                <h3 style="width: 350px;overflow: hidden;text-overflow: ellipsis;line-height: 25px;-webkit-line-clamp: 1;height: 28px;display: -webkit-box;-webkit-box-orient: vertical;"><a href="tutorialforward?monanid=${list.monanid}">${list.danhmuctu}</a>
                </h3>
                <p style="width: 350px;overflow: hidden;text-overflow: ellipsis;line-height: 25px;-webkit-line-clamp: 3;height: 75px;display: -webkit-box;-webkit-box-orient: vertical;">${list.gioithieu}</p>
            </div>
        </c:forEach>
    </div>

    <hr>
<%--    &laquo;--%>
<%--    &raquo;--%>
    <div class="row text-center">

        <div class="col-lg-12">
            <ul class="pagination">
                <c:if test="${pageid==1}">
                    <li class="disabled"><a href="">Previous</a>
                    </li>
                    <li><a href="homeforward?pageid=${pageid+1}">Next</a>
                    </li>
                </c:if>
                <c:if test="${pageid > 1 && pageid < total}">
                    <li><a href="homeforward?pageid=${pageid-1}">Previous</a>
                    </li>
                    <li><a href="homeforward?pageid=${pageid+1}">Next</a>
                    </li>
                </c:if>
                <c:if test="${pageid == total}">
                    <li><a href="homeforward?pageid=${pageid-1}">Previous</a>
                    </li>
                    <li class="disabled"><a href="">Next</a>
                    </li>
                </c:if>
            </ul>
        </div>

    </div>
</div>
<!-- /.container -->

<div class="container">

    <hr>

    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright © 2021.<a href="">Duy Trầm Cảm</a>, All rights reserved</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- JavaScript -->
<script src="Template/js/jquery-1.10.2.js"></script>
<script src="Template/js/bootstrap.js"></script>

</body>

</html>
