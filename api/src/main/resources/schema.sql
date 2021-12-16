
-- CREATE SCHEMA noshowvaccine
CREATE SCHEMA IF NOT EXISTS noshowvaccine;

-- CREATE TABLE noshowvaccine.member
CREATE TABLE IF NOT EXISTS noshowvaccine.member
(
	id 		        SERIAL PRIMARY KEY,
	username 		VARCHAR(20) UNIQUE NOT NULL,
	password 		VARCHAR(20) NOT NULL,
	name 			VARCHAR(10) not null,
	date_of_birth 	VARCHAR(10) not null,
	gender 			char(1) not null,
	phone_number 	VARCHAR(20) not null,
	reg_at 			TIMESTAMP,
	mod_at 			TIMESTAMP
);
