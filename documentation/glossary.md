# Entities

### state
--Name: state

--Synonyms: country, nation, land

--Description: Stores every state in the United States of America along with their respective codes.

### population
--Name: population

--Synonyms: residents, people

--Description: This entity stores the population for each state in the U.S.A. for a given year.

### aqi
 --Name: aqi
 
 --Synonyms: Air Quality Index
 
 --Description: This entity stores the year wise air quality index for each state of the U.S.A.
 
### carbon_dioxide
 --Name: carbon_dioxide
 
 --Synonyms: CO2, Carbonic Acid, Methane
 
 --Description: This entity stores the carbon-di-oxide emission produced by each state in the U.S.A. on the yearly basis.
 
 ### natural disaster
--Name: natural_disaster

--Synonyms: inevitable accidents, a phenomenon 

--Description: shows if any natural event such as a flood, earthquake or hurricane occurs in a state.

### deforestation
--Name: deforestation

--Synonyms: urbanization, desertification

--Description: shows how much land is cleared to make room for urban growth. 


# Relationships

### state_has_population:
Every state has some population given an year. This relationship defines the population value for each state for each year.

### state_reports_aqi:
This relationship states the air quality index reported by each state for a given year.

### state_emits_carobon_dioxide:
This relationship states the levels of carbon dioxide emitted by each state per year.

### state_encounters_natural_disaster:
This relationship shows that a state encounters a natural disaster. A particular state can encounter multiple natural disasters, though it isn’t required to encounter a natural disaster. 

### state_causes_deforestation:
This relationship show that a state can cause deforestation. 


 # Attributes
 ### state - id 1-1(1), name M-1(1), code M-1(1)
 
 ### population - p_id 1-1(1), year M-1(1), p_value M-1(1)
 
 ### natural_disaster - n_id 1-1(1), year M-1(1), n_metric 1-1(1)
 
 ### deforestation - def_id 1-1(1), year M-1(1), def_metric M-1(1)
 
 ### aqi - aqi_id 1-1(1), year M-1(1), aqi_metric M-1(1)
 
 ### carbon_dioxide - co_id 1-1(1), year M-1(1), co_metric M-1(1)


# Attribute Data Types

### state
--name VARCHAR

--code VARCHAR

--id INTEGER

### population
--p_id INTEGER

--year INTEGER

--p_value INTEGER


 # aqi
  --aqi_id INTEGER
  
  --year INTEGER
  
  --aqi_metric DECIMAL(4,2)
  
 # carbon_dioxide
  --co_id INTEGER
  
  --year INTEGER
  
  --co_metric DECIMAL(3,2)
