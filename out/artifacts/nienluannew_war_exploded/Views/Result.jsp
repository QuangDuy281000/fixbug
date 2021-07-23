<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/7/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="Businnes, Portfolio, Corporate">
    <meta name="Author" content="WebThemez">
    <title>NameFood Page</title>
    <link rel="stylesheet" href="Template/css/normalize.css">
    <link rel="stylesheet" href="Template/css/bootstrap.min.css">
    <link rel="stylesheet" href="Template/css/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="Template/elegant_font/style.css" />

    <link rel="stylesheet" href="Template/css/magnific-popup.css">
    <link rel="stylesheet" href="Template/css/slider-pro.css">
    <link rel="stylesheet" href="Template/css/owl.carousel.css">
    <link rel="stylesheet" href="Template/css/owl.theme.css">
    <link rel="stylesheet" href="Template/css/owl.transitions.css">
    <link rel="stylesheet" href="Template/css/animate.css">
    <link rel="stylesheet" href="Template/elegant_font/style.css">
    <link rel="stylesheet" href="Template/css/style.css">
    <!-- Bootstrap core CSS -->
    <link href="Template/css-3/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS for the '3 Col Portfolio' Template -->
    <link href="Template/css-3/3-col-portfolio.css" rel="stylesheet">
</head>

<body>
<!-- Preloader -->
<div class="preloader">
    <div class="status"></div>
</div>

<!-- Header End -->
<header>
    <!-- Navigation Menu start-->

    <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
        <div class="container">
            <div class="navbar-header" style="width: 300px;">
                <a class="navbar-brand" href="pageforward" style="font-size: 30px; color: chartreuse;"> QD FOOD</a>
            </div>
        </div>
    </nav>
</header>
<section id="about" class="about-sec section-wrapper description">
    <div class="container">
        <div class="row">
            <!-- Section Header -->
            <div class="col-md-12 col-sm-12 col-xs-12 section-header wow fadeInDown">
                <h2><span class="highlight-text">${danhsach.danhmuctu}</span></h2>

                <p class="col-md-8 col-sm-10 col-xs-12 col-md-offset-2 col-sm-offset-1">${danhsach.gioithieu}</p>
            </div>
            <!-- Section Header End -->

            <div class="col-md-6 col-sm-6 col-xs-12 custom-sec-img wow fadeInDown">
                <img src="Template/images/features.jpg" alt="Custom Image">
            </div>

            <div class="col-md-6 col-sm-6 col-xs-12 customized-text wow fadeInDown black-ed">
                <div class="row">
                    <div class="col-md-11">
                        <strong>Nguyên liệu</strong>
                        <p>${danhsach.nguyenlieu}
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-11">
                        <strong>Cách làm</strong>
                        <p>${danhsach.cachlam}
                        </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-11">
                        <strong>Chú ý</strong>
                        <p>${danhsach.chuy==''?"Không có":danhsach.chuy}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Portfolio Section End -->
<div class="row text-center">

    <div class="col-lg-12">
        <ul class="pagination">
            <li><a href="homeforward?pageid=1">Back</a>
            </li>
        </ul>
    </div>

</div>
<div class="container">
    <hr>

    <footer style="background-color: white">
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright © 2021.<a href="">Duy Trầm Cảm</a>, All rights reserved</p>
            </div>
        </div>
    </footer>

</div>
<!-- Footer End -->

<script src="Template/js/jquery-1.11.3.min.js"></script>
<script src="Template/js/bootstrap.min.js"></script>
<script src="Template/js/modernizr.min.js"></script>
<script src="Template/js/jquery.easing.1.3.js"></script>
<script src="Template/js/jquery.scrollUp.min.js"></script>
<script src="Template/js/jquery.easypiechart.js"></script>
<script src="Template/js/isotope.pkgd.min.js"></script>
<script src="Template/js/jquery.fitvids.js"></script>
<script src="Template/js/jquery.stellar.min.js"></script>
<script src="Template/js/jquery.waypoints.min.js"></script>
<script src="Template/js/wow.min.js"></script>
<script src="Template/js/jquery.nav.js"></script>
<script src="Template/js/imagesloaded.pkgd.min.js"></script>
<script src="Template/js/smooth-scroll.min.js"></script>
<script src="Template/js/jquery.magnific-popup.min.js"></script>
<script src="Template/js/jquery.sliderPro.min.js"></script>
<script src="Template/js/owl.carousel.min.js"></script>
<script src="Template/contact/jqBootstrapValidation.js"></script>
<script src="Template/contact/contact_me.js"></script>
<script src="Template/js/custom.js"></script>

</body>

</html>
