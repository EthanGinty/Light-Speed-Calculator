package com.techelevator;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.Dao.ProjectDao;
import com.techelevator.model.Planet;
import com.techelevator.model.Ship;

@Controller
public class ProjectController {

	private ProjectDao projectDao;

	@Autowired
	public ProjectController(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@RequestMapping(path = { "/", "/homePage" }, method = RequestMethod.GET)
	public String getShipList(ModelMap model) {
		model.addAttribute("allShips", projectDao.getAllShips());
		model.addAttribute("allPlanets", projectDao.getAllPlanets());
		return "homePage";
	}

	@RequestMapping(path = { "/results" }, method = RequestMethod.GET)
	public String getResults(ModelMap model, HttpServletRequest request) {
		Ship ship = new Ship();
		Planet planet = new Planet();
		ship.setName(request.getParameter("ship"));
		model.put("ship", projectDao.getShipByName(ship.getName()));
		planet.setPlanet(request.getParameter("destination"));
		model.put("planet", projectDao.getPlanetByName(planet.getPlanet()));
		return "results";
	}

}
