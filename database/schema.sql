-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

-- CREATE statements go here
CREATE TABLE ship (

	ShipID serial,
	Name VARCHAR(64) NOT NULL,
	Description VARCHAR(500),
	Speed float NOT NULL,
	Franchise VARCHAR(64),
	PRIMARY KEY (ShipID)

);

CREATE TABLE planet (

	PlanetID serial,
	Planet VARCHAR(64) NOT NULL,
	Distance float NOT NULL,
	Planet_description VARCHAR(450) NOT NULL,
	PRIMARY KEY (PlanetID)
);

COMMIT;