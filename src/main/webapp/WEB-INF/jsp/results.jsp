<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/Header.jsp" />

<div class="formatBody">
	<div class="travelInfo">
	<c:url value="/img/destinations/${planet.planet}.jpg"
		var="destinationImg" />
	<img class= "planetImage" src="${destinationImg}" alt="Ship Image" />
		<h2>The ${ship.name} traveling to ${planet.planet}</h2>
		<p>
			Traveling at ${ship.speed} km/s the ${ship.name} would reach
			${planet.planet} in
			<fmt:formatNumber value="${planet.distance / ship.speed}"
				maxFractionDigits="15" />
			seconds.
		</p>


	</div>
</div>
<c:import url="/WEB-INF/jsp/common/Footer.jsp" />