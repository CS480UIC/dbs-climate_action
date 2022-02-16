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
