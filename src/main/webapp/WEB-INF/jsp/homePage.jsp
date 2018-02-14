<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/Header.jsp" />

<script>
	$(document).ready(function() {

		var $AddShip = $("#addShip");
		$AddShip.on("click", function(event) {
			$("#shipSelect").equals($("#addShip").val());
			$("#shipSelect span").equals($("#addShip").val());
		});
	});
</script>

<c:url var="formAction" value="/results" />
<form method="GET" action="${formAction}">
	<div id="comparer" class="selections">
		<select name="ship" required id="shipSelect">
			<option value="" disabled selected>Ship:</option>
			<c:forEach var="ship" items="${allShips}">
				<option value="${ship.name}"><span>${ship.name}</span></option>
			</c:forEach>
		</select> <select name="destination" required>
			<option value="" disabled selected>Destination:</option>
			<c:forEach var="planet" items="${allPlanets}">
				<option value="${planet.planet}">${planet.planet}</option>
			</c:forEach>
		</select> <input type="submit" name="engage" value="Engage!">
	</div>
</form>
<div class="formatBody">
	<form>
		<c:forEach var="ship" items="${allShips}">
			<div class="homePageShips">
				<c:url value="/img/ships/${ship.name}.jpg" var="shipImg" />
				<img class="shipImage" src="${shipImg}" alt="Ship Image" />
				<div class="shipInfo">
					<h1 id="nameId">${ship.name}</h1>
					<br>
					<p>"${ship.description}"</p>
					<br>
					<p>Maximum speed of Vessel: ${ship.speed} km/s</p>
					<p>(${ship.franchise})</p>
				</div>
				<label for="addShip">Add Ship: </label> <input type="button"
					name="addShip" value="${ship.name}" id="addShip">

			</div>
		</c:forEach>
	</form>
</div>


<c:import url="/WEB-INF/jsp/common/Footer.jsp" />