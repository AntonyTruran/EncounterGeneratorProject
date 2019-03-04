INSERT INTO Biome (biomeID,biomeReference,biomeName) VALUES (DEFAULT,'DUNLL','dungeon (low level)');
INSERT INTO Creature (creatureId, creatureName, challengeRating,type,environment,climate,alignment,combatRole) VALUES (default,'dire rats',0.3,'animal','urban','temperate','NN','swarm');
INSERT INTO Creature (creatureId, creatureName, challengeRating,type,environment,climate,alignment,combatRole) VALUES (default,'fire beetles',0.3,'underground','temperate','NN','swarm');

INSERT INTO EncounterChart (id, creatureName, biomeReference, number, maxChance, minChance) VALUES (default,'dire rats','DUNLL','1d6',6,1);
INSERT INTO EncounterChart (id, creatureName, biomeReference, number, maxChance, minChance) VALUES (default,'fire beetles','DUNLL',12,7);