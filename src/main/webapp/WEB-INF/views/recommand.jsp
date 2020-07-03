<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Martine</title>
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
    <!-- themify CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/themify-icons.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/flaticon.css">
    <!-- fontawesome CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome/css/all.min.css">
    <!-- magnific CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gijgo.min.css">
    <!-- niceselect CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/nice-select.css">
    <!-- slick CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
   <!--::header part start::-->
   <header class="main_menu">
        <div class="main_menu_iner">
            <div class="container">
                <div class="row align-items-center ">
                    <div class="col-lg-12">
                        <nav class="navbar navbar-expand-lg navbar-light justify-content-between">
                            <a class="navbar-brand" href="index.html"> <img src="${pageContext.request.contextPath}/images/13.png" width=70 height=70 alt="logo"> </a>
                            <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>

                            <div class="collapse navbar-collapse main-menu-item justify-content-center"
                                id="navbarSupportedContent">
                                <ul class="navbar-nav">
                                    <li class="nav-item">
                                        <a class="nav-link" href="about.html">About</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="packages.html">추 천</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#">여행지 순위</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown_1"
                                            role="button" data-toggle="dropdown" aria-haspopup="true"
                                            aria-expanded="false">
                                            my page
                                        </a>
                                        <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                            <a class="dropdown-item" href="#">회원정보</a>
                                            <a class="dropdown-item" href="#">내글보기</a>
                                            <a class="dropdown-item" href="#">내가담은여행지</a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <a href="#" class="btn_1 d-none d-lg-block">login</a>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- Header part end-->
      <!-- breadcrumb start-->
    <section class="breadcrumb breadcrumb_bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb_iner">
                        <div class="breadcrumb_iner_item text-center">
                            <h2>Recommand</h2>
                            <p>It does your choice</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- breadcrumb start-->
    
    
	<section class="top_place section_padding">
        <div class="container">	
            <div class="row justify-content-center">
                <div class="col-xl-6">
                    <div class="section_tittle text-center">
                        <h2>여행 지역을 고르세요</h2>
                        <p>Waters make fish every without firmament saw had. Morning air subdue. Our. Air very one. Whales grass is fish whales winged.</p>
                    </div>
                </div>
            </div>
		    <div style="text-align:center;">
	           	<img alt="" src="${pageContext.request.contextPath}/images/map/map.png" width="300" height="450"
	           		style="position: relative; top: -280px;">
			    <div class="ctnn">
			        <a href="#" class="butt2 b-green rot-135" style="color:white;" >서 울</a>
			        <a href="#" class="butt2 b-red rot-135" style="color:white;">인 천</a>
			        <a href="#" class="butt2 b-orange rot-135" style="color:white;">대 전</a>
			        <a href="#" class="butt2 b-pink rot-135" style="color:white;">세 종</a>
			        <a href="#" class="butt2 b-blue rot-135" style="color:white;">광 주</a>
			        <a href="#" class="butt2 b-navy rot-135" style="color:white;">대 구</a>
			        <a href="#" class="butt2 b-steelblue rot-135" style="color:white;">울 산</a>
			        <a href="#" class="butt2 b-lightslategray rot-135" style="color:white;">부 산</a>
			        <hr/>
			        <a href="#" class="butt2 b-green rot-135" style="color:white;" >&nbsp;경 기 도&nbsp;</a>
			        <a href="#" class="butt2 b-pink rot-135" style="color:white;">&nbsp;강 원 도&nbsp;</a><br>
			        <a href="#" class="butt2 b-lightslategray rot-135" style="color:white;">전라북도</a>
			        <a href="#" class="butt2 b-red rot-135" style="color:white;">충청북도</a>
			        <a href="#" class="butt2 b-blue rot-135" style="color:white;">경상북도</a>
			        <a href="#" class="butt2 b-sand rot-135" style="color:white;">전라남도</a>
			        <a href="#" class="butt2 b-orange rot-135" style="color:white;">충청남도</a>
			        <a href="#" class="butt2 b-navy rot-135" style="color:white;">경상남도</a><br>
			        <a href="#" class="butt2 b-steelblue rot-135" style="color:white;">&nbsp;제 주 도&nbsp;</a>
			    </div>
		    </div>
        </div>  
    </section>

    <!-- footer part start-->
    <footer class="footer-area">
        <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="copyright_part_text text-center">
                        <p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- footer part end-->

    <!-- jquery plugins here-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- magnific js -->
    <script src="${pageContext.request.contextPath}/js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="${pageContext.request.contextPath}/js/owl.carousel.min.js"></script>
    <!-- masonry js -->
    <script src="${pageContext.request.contextPath}/js/masonry.pkgd.js"></script>
    <!-- masonry js -->
    <script src="${pageContext.request.contextPath}/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/gijgo.min.js"></script>
    <!-- contact js -->
    <script src="${pageContext.request.contextPath}/js/jquery.ajaxchimp.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/mail-script.js"></script>
    <script src="${pageContext.request.contextPath}/js/contact.js"></script>
    <!-- custom js -->
    <script src="${pageContext.request.contextPath}/js/custom.js"></script>
</body>
</html>
