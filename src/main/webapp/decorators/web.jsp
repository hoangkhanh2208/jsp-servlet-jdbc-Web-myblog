<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/commons/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><dec:title default="Trang chủ" /></title>

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="<c:url value='/template/web/assets/favicon.ico' />" />
<!-- Core theme CSS (includes Bootstrap)-->

<link href="${pageContext.request.contextPath}/template/web/css/styles.css" rel="stylesheet" />

</head>
<body>
	<!-- header -->
	<%@ include file="/commons/web/header.jsp"%>
	<!-- header -->
	
	<!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">Welcome to Blog Home!</h1>
                    <p class="lead mb-0">A Bootstrap 5 starter layout for your next blog homepage</p>
                </div>
            </div>
        </header>

	<div class="container">
		<div class="row">
			<dec:body />
			
			<!-- side widget -->
			<%@ include file="/commons/web/sideWidget.jsp"%>
			<!-- side widget -->
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/commons/web/footer.jsp"%>
	<!-- footer -->

	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/template/web/js/scripts.js' />"></script>

</body>
</html>