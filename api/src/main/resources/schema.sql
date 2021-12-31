
-- CREATE SCHEMA noshowvaccine
CREATE SCHEMA IF NOT EXISTS noshowvaccine;

-- CREATE EXTENSIONS
CREATE EXTENSION IF NOT EXISTS Cube;
CREATE EXTENSION IF NOT EXISTS earthdistance;

-- -- CREATE TABLE noshowvaccine.user
-- DROP TABLE IF EXISTS noshowvaccine."user" CASCADE ;
-- CREATE TABLE noshowvaccine."user"
-- (
--     id SERIAL PRIMARY KEY,
--     username VARCHAR(20) UNIQUE NOT NULL,
--     password VARCHAR(200) NOT NULL,
--     role     VARCHAR(20)  NOT NULL
-- );
--
-- -- CREATE TABLE noshowvaccine.member
-- DROP TABLE IF EXISTS noshowvaccine.member;
-- -- select setval(noshowvaccine.user_id_seq, 1, false);
-- CREATE TABLE noshowvaccine.member
-- (
--     id SERIAL PRIMARY KEY,
--     user_id INTEGER REFERENCES noshowvaccine."user"(id),
-- 	name VARCHAR(10) NOT NULL,
-- 	birth VARCHAR(10) NOT NULL,
-- 	gender char(1) NOT NULL,
-- 	telephone VARCHAR(20) NOT NULL,
-- 	noshow char(1) NOT NULL,
-- 	shot int NOT NULL,
-- 	vaccination_date TIMESTAMP NULL,
-- 	last_update TIMESTAMP NOT NULL
-- );
-- ALTER TABLE noshowvaccine.member
--     ADD CONSTRAINT fk_member_user FOREIGN KEY (user_id) REFERENCES noshowvaccine."user"(id);
-- ALTER TABLE noshowvaccine.member ALTER COLUMN shot SET DEFAULT 0;
-- ALTER TABLE noshowvaccine.member ALTER COLUMN noshow SET DEFAULT 0;

-- CREATE TABLE noshowvaccine.location
DROP TABLE IF EXISTS noshowvaccine.location CASCADE;
CREATE TABLE noshowvaccine.location
(
    id SERIAL PRIMARY KEY,
    latitude REAL NOT NULL,
    longitude REAL NOT NULL
);

-- CREATE TABLE noshowvaccine.institution
DROP TABLE IF EXISTS noshowvaccine.institution;
CREATE TABLE noshowvaccine.institution
(
	id SERIAL PRIMARY KEY,
    location_id integer REFERENCES noshowvaccine.location(id),
	username VARCHAR(20) UNIQUE NOT NULL,
	password VARCHAR(200) NOT NULL,
	name VARCHAR(20) NOT NULL,
	corp_num VARCHAR(20) NOT NULL,
	telephone VARCHAR(20) NOT NULL,
	address VARCHAR(4000) NOT NULL,
	open_time char(5) NOT NULL,
    close_time char(5) NOT NULL,
	last_update TIMESTAMP NOT NULL
);


