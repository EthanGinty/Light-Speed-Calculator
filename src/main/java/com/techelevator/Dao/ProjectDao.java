package com.techelevator.Dao;

import java.util.List;

import org.springframework.context.annotation.Configuration;

import com.techelevator.model.Planet;
import com.techelevator.model.Ship;

@Configuration
public interface ProjectDao {
	
	List<Ship> getAllShips();
	Ship getShipByName(String shipName);
	List<Planet> getAllPlanets();
	Planet getPlanetByName(String planetName);
}
