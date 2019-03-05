INSERT INTO Biome (biomeReference,biomeName) VALUES ('DUNLL','dungeon (low level)');
INSERT INTO Creature (creatureName, challengeRating,type,environment,climate,alignment,combatRole) VALUES ('dire rats',0.3,'animal','urban','temperate','NN','swarm');
INSERT INTO Creature (creatureName, challengeRating,type,environment,climate,alignment,combatRole) VALUES ('fire beetles',0.3, 'vermin', 'underground','temperate','NN','swarm');

INSERT INTO EncounterChart (id, monsterKey, biomeKey, number, maxChance, minChance) VALUES (default,'dire rats','DUNLL','1d6', 6, 1);
INSERT INTO EncounterChart (id, monsterKey, biomeKey, number, maxChance, minChance) VALUES (default,'fire beetles','DUNLL', '1d6', 12, 7);