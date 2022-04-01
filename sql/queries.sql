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
FROM carbon_dioxide GROUP BY emission_year HAVING avg_metric>100;

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



