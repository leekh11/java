<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<meta charset="UTF-8">
<title>체험정보</title>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=73d334cffe8ebdf6bcc029d7f682e054"></script>
</head>
<body>
	<%-- 	<%@ include file="/WEB-INF/inc/top_menu.jsp"%> --%>
	<div class="container">
		<h3>체험 정보</h3>
		<form action="exprRegist.mg" method="post">
			<table class="table table-bordered" style="text-align: center;">
			<colgroup>
				<col />
				<col style="width:80%;" >
			</colgroup>
				<tbody>
					<tr>
						<th>순번</th>
						<td>${expr.no}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${expr.name}</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>${expr.add1}${expr.add2}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td><img src="${expr.imageUrl}" alt="" width=300 height=300>
							<br> ${expr.content}</td>
					</tr>
					<tr>
						<th>좌표</th>
						<td><div id="map" style="width: 600px; height: 400px;"></div>
							<br> x좌표 : ${expr.mapx} <br> y좌표 : ${expr.mapy}</td>
					</tr>
					<tr>
						<td>이전글></td>
						 <td>
							<a href="exprView.mg?no=${exprPre.no}" style="width: 400px" > 
									${exprPre.name}
							</a>						 
						 </td>
					</tr>
					<tr>
						<td>이후글></td>
						<td>
							<a href="exprView.mg?no=${exprPost.no}" style="width: 400px" > 
									${exprPost.name}
							</a>
						</td>
					</tr>
				</tbody>
			</table>
				<div class="pull-right">
					<a href="exprList.mg" class="btn btn-sm btn-default" style="width: 200px">목록으로</a>
				</div>
		</form>
	</div>

	<script type="text/javascript">
		var x = ${expr.mapx};
		var y = ${expr.mapy};
		var v_name = "${expr.name}";
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(y, x), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	  
	// 마커를 표시할 위치입니다 
	var position =  new kakao.maps.LatLng(y, x);

	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	  position: position,
	  clickable: true // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
	});

	// 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
	// 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
	// marker.setClickable(true);

	// 마커를 지도에 표시합니다.
	marker.setMap(map);

	// 마커를 클릭했을 때 마커 위에 표시할 인포윈도우를 생성합니다
	var iwContent = '<div style="padding:5px;">'+v_name+'</div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	var iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

	// 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({
	    content : iwContent,
	    removable : iwRemoveable
	});

	// 마커에 클릭이벤트를 등록합니다
	kakao.maps.event.addListener(marker, 'click', function() {
	      // 마커 위에 인포윈도우를 표시합니다
	      infowindow.open(map, marker);  
	});
	</script>
</body>
</html>