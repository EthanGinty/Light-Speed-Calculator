<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsp/common/Header.jsp" />
<script>
	
	function addShip(event) {
		var button = event.target;
		document.getElementById('racingShips').value += button.value + ', ';
		console.log(event);
	}
	
</script>

<c:url var="formAction" value="/results">
	<param name="racingShips" value="racingShips" />
</c:url>
<form method="GET" action="${formAction}">
	<div id="comparer" class="selections">
		<label for="racingShips">Ships in race: <input type="text"
			name="racingShips" id="racingShips" value="" required>
		</label>
		<select id="destinationSelection" name="destination" required>
			<option value="" disabled selected>Destination:</option>
			<c:forEach var="planet" items="${allPlanets}">
				<option value="${planet.planet}">${planet.planet}</option>
			</c:forEach>
		</select> 
		<input type="submit" name="engage" value="Engage!" />
	</div>
</form>

<div class="formatBody">
	<c:forEach var="ship" items="${allShips}">
		<div class="homePageShips">
			<c:url value="/img/ships/${ship.name}.jpg" var="shipImg" />
			<img class="shipImage" src="${shipImg}" alt="Ship Image" />
			<div class="shipInfo">
				<h1 id="nameId">${ship.name}</h1>
				<br>
				<p>"${ship.description}"</p>
				<br>
				<p>(${ship.franchise})</p>
			</div>
			<button onclick="addShip(event)" type="button" class ="addShip"
				value="${ship.name}">Add ${ship.name}</button>
		</div>
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/Footer.jsp" />