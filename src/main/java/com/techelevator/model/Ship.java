package com.techelevator.model;

public class Ship implements Comparable<Ship>{
	
	private int shipId;
	private String name;
	private String description;
	private float speed;
	private String franchise;
	
	public int getShipId() {
		return shipId;
	}
	public void setShipId(int shipId) {
		this.shipId = shipId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public String getFranchise() {
		return franchise;
	}
	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}
	
	public int compareTo(Ship o) {
		if(this.getSpeed() < o.getSpeed()) {
			return 1;
		} else {
			return -1;
		}
	}
	

	}


