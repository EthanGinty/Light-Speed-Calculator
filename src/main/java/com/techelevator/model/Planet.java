package com.techelevator.model;

public class Planet {
	
	
	private int planetId;
	private String planet;
	private String planetDescription;
	private float distance;
	
	public String getPlanetDescription() {
		return planetDescription;
	}
	public void setPlanetDescription(String planetDescription) {
		this.planetDescription = planetDescription;
	}
	public int getPlanetId() {
		return planetId;
	}
	public void setPlanetId(int planetId) {
		this.planetId = planetId;
	}

	public String getPlanet() {
		return planet;
	}
	public void setPlanet(String planet) {
		this.planet = planet;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}

}
