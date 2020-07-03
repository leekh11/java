<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pfold.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/custom2.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/modernizr.custom.79639.js"></script> 
		<!--[if lte IE 8]><style>.support-note .note-ie{display:block;}</style><![endif]-->
		<style>
			body {
				background-image: url(images/bg2.jpg);
			}
		</style>
</head>
<body>
	<div class="container">
		
			<header>
			
				<h1><strong>Tour 관리자</strong> Manager</h1>
				<h3>tour.mg</h3>
				
				<div class="support-note"><!-- let's check browser support with modernizr -->
					<span class="no-csstransforms3d">CSS 3D transforms are not supported in your browser</span>
					<span class="note-ie">Sorry, only modern browsers.</span>
				</div>
				
			</header>
			
			<section class="main demo-2">
				
				<div id="grid" class="grid clearfix">
				
					<div class="uc-container">
						<div class="uc-initial-content">
							<img src="${pageContext.request.contextPath}/images/thumbs/3.jpg" alt="image03" />
							<span class="icon-eye"></span>
						</div>
						<div class="uc-final-content">
							<img src="${pageContext.request.contextPath}/images/large/3.jpg" alt="image03-large" />
							<div class="title"><h3>공지사항</h3> by 윤현웅<a href="<%=request.getContextPath()%>/notice/noticeList.mg" class="icon-link"></a></div>
							<span class="icon-cancel"></span>
						</div>
					</div><!-- / uc-container -->

					<div class="uc-container">
						<div class="uc-initial-content">
							<img src="${pageContext.request.contextPath}/images/thumbs/1.jpg" alt="image01" />
							<span class="icon-eye"></span>
						</div>
						<div class="uc-final-content">
							<img src="${pageContext.request.contextPath}/images/large/1.jpg" alt="image01-large" />
							<div class="title"><h3>회원관리</h3> by 이경훈<a href="<%=request.getContextPath()%>/member/memberList.wow" class="icon-link"></a></div>
							<span class="icon-cancel"></span>
						</div>
					</div><!-- / uc-container -->

					<div class="uc-container">
						<div class="uc-initial-content">
							<img src="${pageContext.request.contextPath}/images/thumbs/2.jpg" alt="image02" />
							<span class="icon-eye"></span>
						</div>
						<div class="uc-final-content">
							<img src="${pageContext.request.contextPath}/images/large/2.jpg" alt="image02-large" />
							<div class="title"><h3>데이터 관리</h3> by 이재현<a href="<%=request.getContextPath()%>/data/data.mg" class="icon-link"></a></div>
							<span class="icon-cancel"></span>
						</div>
					</div><!-- / uc-container -->

					<div class="uc-container">
						<div class="uc-initial-content">
							<img src="${pageContext.request.contextPath}/images/thumbs/4.jpg" alt="image04" />
							<span class="icon-eye"></span>
						</div>
						<div class="uc-final-content">
							<img src="${pageContext.request.contextPath}/images/large/4.jpg" alt="image04-large" />
							<div class="title"><h3>게시물 관리</h3>by 최윤정<a href="<%=request.getContextPath()%>/board/boardListM.mg" class="icon-link"></a></div>
							<span class="icon-cancel"></span>
						</div>
					</div><!-- / uc-container -->

				</div><!-- / grid -->
				<p class="info"><strong>tour.mg :</strong>관리자 전용 페이지 입니다.</p>
			</section>

		</div>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pfold.js"></script>
		<script type="text/javascript">
			$(function() {

				// say we want to have only one item opened at one moment
				var opened = false;

				$( '#grid > div.uc-container' ).each( function( i ) {

					var $item = $( this ), direction;

					switch( i ) {
						case 0 : direction = ['right','bottom']; break;
						case 1 : direction = ['left','bottom']; break;
						case 2 : direction = ['right','top']; break;
						case 3 : direction = ['left','top']; break;
					}
					
					var pfold = $item.pfold( {
						folddirection : direction,
						speed : 300,
						onEndFolding : function() { opened = false; },
						centered : true
					} );

					$item.find( 'span.icon-eye' ).on( 'click', function() {

						if( !opened ) {
							opened = true;
							pfold.unfold();
						}


					} ).end().find( 'span.icon-cancel' ).on( 'click', function() {

						pfold.fold();

					} );

				} );
				
			});
		</script>
</body>
</html>