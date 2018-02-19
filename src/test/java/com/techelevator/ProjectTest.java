package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.Dao.JdbcProjectDao;
import com.techelevator.model.Planet;
import com.techelevator.model.Ship;

public class ProjectTest {
	
	private static SingleConnectionDataSource dataSource;
	private JdbcProjectDao dao;
	

	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/myproject2");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
 
	
	@Before
	public void setup() {
		dao = new JdbcProjectDao(getDataSource());
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Test
	public void get_ship_list_test() {
		List<Ship> shipList = dao.getAllShips();
		assertNotNull(shipList);
	}
	@Test
	public void get_planet_list_test() {
		List<Planet> planetList = dao.getAllPlanets();
		assertNotNull(planetList);
	}
	
	@Test
	public void get_ship_by_name_test() {
		Ship theShip = dao.getShipByName("USS Defiant");
		assertEquals("2758086.4", theShip.getSpeed());
		assertEquals("Star Trek: Deep Space Nine", theShip.getFranchise());
	}
	@Test
	public void get_planet_by_name_test() {
		Planet thePlanet = dao.getPlanetByName("Jupiter");
		assertEquals("5.88E8", thePlanet.getDistance());
	}
	@Test
	public void get_Ships_by_franchise_test() {
		List<Ship> starWarsShips = dao.getShipsByFranchise("Star Wars");
		assertNotNull(starWarsShips);
		assertEquals("Millenium Falcon", starWarsShips.get(0).getName());
	}
}
