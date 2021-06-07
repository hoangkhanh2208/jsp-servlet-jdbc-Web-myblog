<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container">
		<a class="navbar-brand" href="#!">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">About</a></li>
				<li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
				<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Blog</a></li>
				<c:if test="${not empty USERMODEL }" > 
					<li class="nav-item"><a class="nav-link" href="#">${USERMODEL.fullName}</a></li>
					<li class="nav-item"><a class="nav-link" href="<c:url value= '/thoat?action=logout'/>">Thoát</a></li>
				</c:if>
				<c:if test="${empty USERMODEL }" > 
					<li class="nav-item"><a class="nav-link" href="<c:url value= '/dang-nhap?action=login'/>">Login</a></li>
				</c:if>
				
			</ul>
		</div>
	</div>
</nav>