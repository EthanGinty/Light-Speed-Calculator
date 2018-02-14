<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<c:url var="cssHref" value="/css/main.css" />
<link type="text/css" rel="stylesheet" href="${cssHref}" />
<c:url var="homeHref" value="/" />
<c:url var="resultsHref" value="/results" />

<title>Light Speed Calculator Project</title>
<div id="comparer">
	<header>
		<div class="center logoTitle">
			<a href="${homeHref}"><img id="logo"
				src="img/space_logo_by_avikdey-d3f2ihe.jpg" alt="Web Logo" /></a>
			<h2>Light Speed Calculator</h2>
			<p>Discovering the speeds of your favorite space ships</p>
		</div>
	</header>
	
</div>
<body>