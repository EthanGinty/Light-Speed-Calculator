package com.techelevator.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Planet;
import com.techelevator.model.Ship;

@Component
public class JdbcProjectDao implements ProjectDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcProjectDao(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Ship> getAllShips() {
		ArrayList<Ship> allShips = new ArrayList<>();
		String sqlGetAllShips = "SELECT * FROM ship";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllShips);
		while (results.next()) {
			allShips.add(mapRowToShip(results));
		}
		return allShips;
	}

	@Override
	public List<Planet> getAllPlanets() {
		ArrayList<Planet> allPlanets = new ArrayList<>();
		String sqlGetAllPlanets = "SELECT * FROM planet";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllPlanets);
		while (results.next()) {
			allPlanets.add(mapRowToPlanet(results));
		}
		return allPlanets;
	}

	@Override
	public Ship getShipByName(String name) {
		Ship theShip = new Ship();
		String sqlGetShipByName = "SELECT * FROM ship WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetShipByName, name);
		if(results.next()){
			theShip = mapRowToShip(results);
		}
		return theShip;
	}

	@Override
	public Planet getPlanetByName(String planet) {
		Planet thePlanet = null;
		String sqlGetPlanetByName = "SELECT * FROM planet WHERE planet = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetPlanetByName, planet);
		if(results.next()){
			thePlanet = mapRowToPlanet(results);
		}
		return thePlanet;
	}

	private Ship mapRowToShip(SqlRowSet results) {
		Ship theShip = new Ship();
		theShip.setShipId(results.getInt("shipid"));
		theShip.setName(results.getString("name"));
		theShip.setDescription(results.getString("description"));
		theShip.setSpeed(results.getFloat("speed"));
		theShip.setFranchise(results.getString("franchise"));
		return theShip;
	}

	private Planet mapRowToPlanet(SqlRowSet results) {
		Planet thePlanet = new Planet();
		thePlanet.setPlanetId(results.getInt("planetId"));
		thePlanet.setDistance(results.getFloat("distance"));
		thePlanet.setPlanet(results.getString("planet"));
		return thePlanet;
	}

}
