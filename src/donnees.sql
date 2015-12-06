-- ============================================================
--    suppression des donnees
-- ============================================================

delete from COMPOSE;
delete from NOTE ;
delete from ETAPE;
delete from RECETTE ;
delete from ELEVE ;
delete from ALIMENT ;


commit;

-- ============================================================
--    creation des donnees
-- ============================================================

-- ELEVE

insert into ELEVE values (1, 'SOULAIMANA','WARDI');
insert into ELEVE values (2, 'GOURRIN','NICOLAS');
insert into ELEVE values (3, 'AGRY','TOM');

commit;

-- ALIMENT

insert into ALIMENT values (1, 'PATATE', 'GRAMME');
insert into ALIMENT values (2, 'OEUF', 'UNITE');
insert into ALIMENT values (3, 'LAIT', 'CENTILITRE');
insert into ALIMENT values (4, 'FARINE', 'GRAMME');
insert into ALIMENT values (5, 'SUCRE', 'GRAMME');
insert into ALIMENT values (6, 'BEURRE', 'GRAMME');
insert into ALIMENT values (7, 'CHOCOLAT', 'GRAMME');
insert into ALIMENT values (8, 'LEVURE', 'SACHET');
insert into ALIMENT values (9, 'HUILE', 'CUILLERE A SOUPE');
insert into ALIMENT values (10, 'BIERE', 'CENTILITRE');
insert into ALIMENT values (11, 'SUCRE ROUX', 'GRAMME');
insert into ALIMENT values (12, 'SUCRE VANILLE', 'SACHET');
insert into ALIMENT values (13, 'MASCARPONE', 'GRAMME');
insert into ALIMENT values (14, 'BISCUIT A LA CUILLERE', 'UNITE');
insert into ALIMENT values (15, 'CAFE', 'CENTILITRE');
insert into ALIMENT values (16, 'POUDRE DE CACAO', 'GRAMME');


commit;

-- RECETTE

insert into RECETTE values (1, 2, 'GATEAU AU CHOCOLAT', 'D', 10, 2, 10, 25);
insert into RECETTE values (2, 2, 'CREPE', 'D', 15, 1, 15, 30);
insert into RECETTE values (3, 2, 'TIRAMISU', 'D', 10, 1, 15, 0);

commit;

-- ETAPE

insert into ETAPE values (1, 1, 'PRECHAUFFEZ LE FOUR A 180 DEGRES');
insert into ETAPE values (2, 1, 'FAITES FONDRE LE CHOCOLAT AU BAIN-MARIE');
insert into ETAPE values (3, 1, 'AJOUTEZ LE BEURRE');
insert into ETAPE values (4, 1, 'DANS UN SALADIER, MELANGEZ LES OEUFS ET LE SUCRE, LA LEVURE, PUIS LA FARINE');
insert into ETAPE values (5, 1, 'VERSEZ LE CHOCOLAT FONDU, PUIS MELANGEZ JUSQU A OBTENTION D UNE PATE HOMOGENE');
insert into ETAPE values (6, 1, 'VERSEZ LA PREPARATION DANS UN MOULE A MANQUE BEURRE ET FARINE');
insert into ETAPE values (7, 1, 'FAITES CUIRE ENVIRON 25 MINUTES');
insert into ETAPE values (8, 2, 'DANS UN SALADIER, VERSEZ LA MOITIE DE LA FARINE, PUIS RAJOUTEZ LES OEUFS UN A UN');
insert into ETAPE values (9, 2, 'RAJOUTEZ ENSUITE UN PEU DE LAIT PUIS DE LA FARINE PUIS A NOUVEAU DU LAIT ET AINSI DE SUITE');
insert into ETAPE values (10, 2, 'RAJOUTEZ L HUILE ET LA BIERE');
insert into ETAPE values (11, 2, 'LAISSEZ REPOSER UNE HEURE ET VOTRE PATE EST PRETE');
insert into ETAPE values (12, 3, 'SEPARER LES BLANCS D OEUFS DES JAUNES');
insert into ETAPE values (12, 3, 'MELANGEZ LES JAUNES, LE SUCRE ET LE SUCRE VANILLE');
insert into ETAPE values (13, 3, 'AJOUTEZ LE MASCARPONE AU FOUET');
insert into ETAPE values (14, 3, 'MONTEZ LES BLANCS EN NEIGE ET LES INCORPORER DELICATEMENT A LA SPATULE AU MELANGE');
insert into ETAPE values (15, 3, 'PREPAREZ DU CAFE NOIR');
insert into ETAPE values (16, 3, 'MOUILLEZ LES BISCUITS DANS LE CAFE');
insert into ETAPE values (17, 3, 'TAPISSEZ LE FOND DU MOULE AVEC LES BISCUITS');
insert into ETAPE values (18, 3, 'RECOUVRIR D UNE COUCHE DE CREME, OEUF, SUCRE ET MASCARPONE');
insert into ETAPE values (19, 3, 'ALTERNEZ BISCUITS ET CREME');
insert into ETAPE values (20, 3, 'TERMINEZ PAR UNE COUCHE DE CREME');
insert into ETAPE values (21, 3, 'SOUPOUDREZ DE CACAO');
insert into ETAPE values (22, 3, 'METTRE AU REFRIGIRATEUR 4 HEURES MINIMUM');

commit;

-- NOTE

insert into NOTE values (1, 1, 4, 5, 4);
insert into NOTE values (1, 2, 3, 5, 4);

commit;

-- COMPOSE

insert into COMPOSE values (2, 1, 4, 0);
insert into COMPOSE values (7, 1, 200, 1);
insert into COMPOSE values (6, 1, 125, 1);
insert into COMPOSE values (5, 1, 200, 0);
insert into COMPOSE values (4, 1, 100, 0);
insert into COMPOSE values (8, 1, 1, 0);
insert into COMPOSE values (2, 2, 5, 1);
insert into COMPOSE values (4, 2, 500, 1);
insert into COMPOSE values (3, 2, 100, 1);
insert into COMPOSE values (9, 2, 3, 0);
insert into COMPOSE values (10, 2, 15, 0);
insert into COMPOSE values (2, 3, 3, 0);
insert into COMPOSE values (11, 3, 100, 0);
insert into COMPOSE values (12, 3, 1, 0);
insert into COMPOSE values (13, 3, 250, 1);
insert into COMPOSE values (14, 3, 24, 1);
insert into COMPOSE values (15, 3, 50, 1);
insert into COMPOSE values (16, 3, 30, 0);


commit;
