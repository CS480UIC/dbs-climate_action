/* deleteDB.sql */
CREATE DATABASE dbs_climate_action;
USE dbs_climate_action;
DROP TABLE population;
DROP TABLE deforestation;
DROP TABLE carbon_dioxide;
DROP TABLE aqi;
DROP TABLE natural_disaster;
DROP TABLE state;

/* initializeDB.sql */
CREATE DATABASE IF NOT EXISTS dbs_climate_action;
USE dbs_climate_action;

CREATE TABLE state(
code VARCHAR(3) UNIQUE NOT NULL,
name VARCHAR(20) UNIQUE NOT NULL,
area INT UNSIGNED NOT NULL,
PRIMARY KEY(code)
);

INSERT INTO state VALUES 
    ('AZ','Arizona',113998),
    ('FL','Florida',65758),
    ('IL','Illinois',57915),
    ('NV','Nevada',110567),
    ('NY','New York',54556);

CREATE TABLE population(
p_id VARCHAR(3) UNIQUE NOT NULL,
recorded_year INT NOT NULL,
p_value INT UNSIGNED NOT NULL,
PRIMARY KEY(p_id,recorded_year),
FOREIGN KEY(p_id) REFERENCES state(code)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO population VALUES 
    ('AZ',2017,3003855),
    ('FL',2017,20977089),
    ('IL',2020,12667017),
    ('NV',2020,3138259),
    ('NY',2021,19835913);

CREATE TABLE deforestation(
def_id VARCHAR(3) UNIQUE NOT NULL,
year INT NOT NULL,
def_metric DECIMAL(10,2) NOT NULL,
PRIMARY KEY(def_id,year),
FOREIGN KEY(def_id) REFERENCES state(code)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO deforestation VALUES 
    ('AZ',2020,18744.44),
    ('FL',2020,0.24),
    ('IL',2020,382.14),
    ('NV',2020,272.79),
    ('NY',2020,3310.15);

CREATE TABLE carbon_dioxide(
co_id VARCHAR(3) UNIQUE NOT NULL,
emission_year INT NOT NULL,
co_metric DECIMAL(6,2) NOT NULL,
PRIMARY KEY(co_id,emission_year),
FOREIGN KEY(co_id) REFERENCES state(code)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO carbon_dioxide VALUES 
    ('AZ',2017,85.60),
    ('FL',2017,226.60),
    ('IL',2017,201.10),
    ('NV',2017,36.20),
    ('NY',2017,156.70);

CREATE TABLE aqi(
aqi_id VARCHAR(3) UNIQUE NOT NULL,
measuring_year INT NOT NULL,
aqi_metric INT UNSIGNED NOT NULL,
reporting_city VARCHAR(20) NOT NULL,
reporting_date DATE NOT NULL,
PRIMARY KEY(aqi_id,measuring_year,reporting_city),
FOREIGN KEY(aqi_id) REFERENCES state(code)
ON DELETE CASCADE
ON UPDATE CASCADE
);

INSERT INTO aqi VALUES 
    ('AZ',2020,53,'Tuscon','2020-11-21'),
    ('FL',2019,43,'Jacksonville','2019-03-15'),
    ('IL',2020,41,'Bloomington','2020-08-15'),
    ('NV',2018,48,'Reno','2018-06-29'),
    ('NY',2018,54,'NewYork','2018-05-10');

CREATE TABLE natural_disaster(
n_id INT UNIQUE NOT NULL,
disaster_name VARCHAR(20) NOT NULL,
occurence_date DATE NOT NULL,
damage_cost DECIMAL(8,3) NOT NULL,
PRIMARY KEY(n_id)
);

INSERT INTO `natural_disaster` VALUES 
    (1,'tornado','2021-12-10',3.900),
    (2,'earthquake','2019-07-04',5.300),
    (3,'hurricane','2021-06-30',65.250),
    (4,'hurricane','2019-08-24',5.100),
    (5,'wildfire','2018-11-08',26.340);

CREATE TABLE state_natural_disaster(
code VARCHAR(3) UNIQUE NOT NULL,
n_id INT NOT NULL,
PRIMARY KEY(code,n_id),
FOREIGN KEY(code) REFERENCES state(code)
ON DELETE CASCADE 
ON UPDATE CASCADE,
FOREIGN KEY(n_id) REFERENCES natural_disaster(n_id)
ON DELETE CASCADE
ON UPDATE CASCADE
);

CREATE TABLE user(
username VARCHAR(50) primary key,
password VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL
);

CREATE TABLE entity1 (
username VARCHAR(50) primary key,
password VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL
);

/* queries.sql */
/* 7.1 */
SELECT *
FROM population
WHERE p_id= 'IL' AND recorded_year = 2020 
ORDER BY p_value;

SELECT *
FROM natural_disaster
WHERE disaster_name='Tornado' 
ORDER BY damage_cost;

SELECT *
FROM deforestation
WHERE def_metric > 10000 ORDER BY def_id;

/* 7.2 */
SELECT emission_year, AVG(co_metric) AS avg_metric
FROM carbon_dioxide 
GROUP BY emission_year HAVING avg_metric>100;

SELECT concat(aqi_id,"_",reporting_city) AS func_example,aqi_metric 
from aqi;

SELECT DAY(reporting_date), MONTH(reporting_date), YEAR(reporting_date) 
FROM aqi;


/* 7.3 */
SELECT * 
FROM population AS p 
LEFT JOIN deforestation AS d 
ON p.p_id=d.def_id;

SELECT * FROM population 
WHERE p_id IN (SELECT CODE FROM state WHERE area>100000);

SELECT p_id FROM
population AS p
WHERE EXISTS
(SELECT * FROM aqi WHERE
aqi.aqi_id=p.p_id 
AND 
aqi_metric>50);
