
-- CREATE SCHEMA noshowvaccine
CREATE SCHEMA IF NOT EXISTS noshowvaccine;

CREATE EXTENSION IF NOT EXISTS Cube;
CREATE EXTENSION IF NOT EXISTS earthdistance;

-- CREATE TABLE noshowvaccine.member
CREATE TABLE IF NOT EXISTS noshowvaccine.member
(
	id 		        SERIAL          PRIMARY KEY,
	username 		VARCHAR(20)     UNIQUE NOT NULL,
	password 		VARCHAR(20)     NOT NULL,
	name 			VARCHAR(10)     NOT NULL,
	birth 	        VARCHAR(10)     NOT NULL,
	gender 			char(1)         NOT NULL,
	telephone    	VARCHAR(20)     NOT NULL,
	noshow          char(1)         NOT NULL,
	last_update 	TIMESTAMP       NOT NULL
);

-- CREATE TABLE noshowvaccine.location
CREATE TABLE IF NOT EXISTS noshowvaccine.location
(
	id 		        SERIAL          PRIMARY KEY,
	latitude 		REAL            NOT NULL,
	longitude 		REAL            NOT NULL
);


-- CREATE TABLE noshowvaccine.institution
CREATE TABLE IF NOT EXISTS noshowvaccine.institution
(
	id 		        SERIAL          PRIMARY KEY,
    locatoin_id     integer         REFERENCES noshowvaccine.location(id),
	username 		VARCHAR(20)     UNIQUE NOT NULL,
	password 		VARCHAR(20)     NOT NULL,
	name 			VARCHAR(20)     NOT NULL,
	corp_num 	    VARCHAR(20)     NOT NULL,
	telephone    	VARCHAR(20)     NOT NULL,
	address    	    VARCHAR(4000)   NOT NULL,
	open_time       char(5)         NOT NULL,
    close_time      char(5)         NOT NULL,
	last_update 	TIMESTAMP       NOT NULL
);
