<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/Header.jsp" />

<div class="formatBody">
	<div id="resultsBackground">
		<c:url value="/img/destinations/${planet.planet}.jpg"
			var="destinationImg" />
		<img id="planetImage" src="${destinationImg}" alt="Ship Image" />
		<div id="planetInfo">
			<h2><u>Traveling to ${planet.planet}</u></h2>
			<br>
			<p>${planet.planetDescription}</p>
			<br><br>
			<table class="table">
				<tr>
					<th>Rank</th>
					<th>Ship</th>
					<th>Speed km/s</th>
					<th>Time to Reach Destination</th>
					<th>Franchise</th>
				</tr>
				<c:set var="rank" value="1" />
				<c:forEach var="ship" items="${racingShips}">
					<tr>
						<td class = "container">${rank}</td>
						<td class = "container">${ship.name}</td>
						<td class = "container">${ship.speed}</td>
						<td class = "container"><fmt:formatNumber value="${planet.distance/ship.speed}"
								maxFractionDigits="4" /> seconds</td>
						<td class = "container">${ship.franchise}</td>
					</tr>
					<c:set var="rank" value="${rank + 1}" />
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/Footer.jsp" />