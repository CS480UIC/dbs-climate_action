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
 ### state - code 1-1(1), name M-1(1), area M-1(1)
 
 ### population - p_id 1-1(1), recorded_year M-1(1), p_value M-1(1)
 
 ### natural_disaster - n_id 1-1(1), disaster_name M-1(1), occurence_year M-1(1), damage_cost 1-1(1)
 
 ### deforestation - def_id 1-1(1), year M-1(1), def_metric M-1(1)
 
 ### aqi - aqi_id 1-1(1), measuring_year M-1(1), aqi_metric M-1(1), reporting_city M-1(1)
 
 ### carbon_dioxide - co_id 1-1(1), emission_year M-1(1), co_metric M-1(1)
 
 ### state_natural_disaster - code 1-1(1), n_id 1-1(1)


# Attribute Data Types

### state
--name VARCHAR UNIQUE NOT NULL

--code VARCHAR UNIQUE NOT NULL PRIMARY KEY

--area DECIMAL(4,2) NOT NULL

### population
--p_id INTEGER UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY

--recorded_year INTEGER NOT NULL PRIMARY KEY

--p_value INTEGER NOT NULL


 ### aqi
 --aqi_id INTEGER UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY
  
 --measuring_year INTEGER NOT NULL PRIMARY KEY
  
 --aqi_metric DECIMAL(4,2) NOT NULL
 
 --reproting_city VARCHAR(4,2) NOT NULL PRIMARY KEY
  
 ### carbon_dioxide
 --co_id INTEGER UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY
  
 --emission_year INTEGER NOT NULL PRIMARY KEY
  
 --co_metric DECIMAL(3,2) NOT NULL
  
  ### natural_disaster
  --n_id INTEGER UNIQUE NOT NULL PRIMARY KEY
  
  --disaster_name VARCHAR(20) NOT NULL

  --occurence_year INTEGER NOT NULL

  --damage_cost DECIMAL (3,2) NOT NULL
  
  ### state_natural_disaster
  --code UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY
  --n_id UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY

### deforestation
 --def_id INTEGER UNIQUE NOT NULL PRIMARY KEY, FOREIGN KEY

 --year INTEGER NOT NULL PRIMARY KEY
 
 --def_metric DECIMAL (3,2) NOT NULL
 
# Dependent entities and dependency relationships:
 -- state is independent
 -- natural_disaster is independent
 -- population is dependent on state
 -- deforestation is dependent on state
 -- carbon_dioxide is dependent on state
 -- aqi is dependent on state
 -- state_natural_disaster is dependent on state and natural_disaster

# Cascade and restrict rules on foreign keys that implement dependency relationships

### CASCADE:
 -- p_id for Update and Delete
 -- def_id for Update and Delete
 -- co_id for Update and Delete
 -- aqi_id for Update and Delete
 -- state_natural_disaster.code for Update and Delete
 -- state_natural_disaster.n_id for Update and Delete
 
### RESTRICT:
 -- No restrict actions
