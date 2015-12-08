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
insert into ALIMENT values (17, 'TOMATE', 'UNITE');
insert into ALIMENT values (18, 'MOZZARELLA', 'BOULE');
insert into ALIMENT values (19, 'PERSIL', 'BRANCHE');
insert into ALIMENT values (20, 'PATE', 'GRAMME');
insert into ALIMENT values (21, 'CREME FRAICHE', 'CENTILITRE');
insert into ALIMENT values (22, 'JAUNE D OEUF', 'UNITE');
insert into ALIMENT values (23, 'LARDON', 'GRAMME');
insert into ALIMENT values (24, 'OIGNON', 'UNITE');
insert into ALIMENT values (25, 'SEL', 'PINCEE');


commit;

-- RECETTE

insert into RECETTE values (1, 2, 'GATEAU AU CHOCOLAT', 'D', 10, 2, 10, 25, 6);
insert into RECETTE values (2, 2, 'CREPE', 'D', 15, 1, 15, 30, 8);
insert into RECETTE values (3, 2, 'TIRAMISU', 'D', 10, 1, 15, 0, 8);
insert into RECETTE values (4, 2, 'TOMATE MOZZARELLA', 'E', 10, 1, 15, 0, 4); 
insert into RECETTE values (5, 2, 'PATE CARBONARA', 'P', 10, 1, 10, 10, 4);

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
insert into ETAPE values (13, 3, 'MELANGEZ LES JAUNES, LE SUCRE ET LE SUCRE VANILLE');
insert into ETAPE values (14, 3, 'AJOUTEZ LE MASCARPONE AU FOUET');
insert into ETAPE values (15, 3, 'MONTEZ LES BLANCS EN NEIGE ET LES INCORPORER DELICATEMENT A LA SPATULE AU MELANGE');
insert into ETAPE values (16, 3, 'PREPAREZ DU CAFE NOIR');
insert into ETAPE values (17, 3, 'MOUILLEZ LES BISCUITS DANS LE CAFE');
insert into ETAPE values (18, 3, 'TAPISSEZ LE FOND DU MOULE AVEC LES BISCUITS');
insert into ETAPE values (19, 3, 'RECOUVRIR D UNE COUCHE DE CREME, OEUF, SUCRE ET MASCARPONE');
insert into ETAPE values (20, 3, 'ALTERNEZ BISCUITS ET CREME');
insert into ETAPE values (21, 3, 'TERMINEZ PAR UNE COUCHE DE CREME');
insert into ETAPE values (22, 3, 'SOUPOUDREZ DE CACAO');
insert into ETAPE values (23, 3, 'METTRE AU REFRIGIRATEUR 4 HEURES MINIMUM');
insert into ETAPE values (24, 4, 'COUPEZ LES TOMATES ET LA MOZZARELLA EN TRANCHE');
insert into ETAPE values (25, 4, 'ALIGNEZ UNE TRANCHE DE MOZZARELLA PUIS UNE TRANCHE DE TOMATE ET AINSI DE SUITE');
insert into ETAPE values (26, 4, 'SOUPOUDREZ DE PERSIL ET D HUILE');
insert into ETAPE values (27, 5, 'METTRE A CUIRE LES PATES');
insert into ETAPE values (28, 5, 'EMINCEZ LES OIGNONS ET LES FAIRE REVENIR A LA POELE');
insert into ETAPE values (29, 5, 'DES QUE LES OIGNONS SONT DORES, AJOUTEZ LES LARDONS');
insert into ETAPE values (30, 5, 'DANS UN SALADIER, MELANGEZ LA CREME FRAICHE, LES OEUFS ET LE SEL');
insert into ETAPE values (31, 5, 'DES QUE LES LARDONS SONT DORES, AJOUTEZ LES A LA CREME');
insert into ETAPE values (32, 5, 'DES QUE LES PATES SONT CUITES, EGOUTEZ LES ET INCORPOREZ LA CREME');
insert into ETAPE values (33, 5, 'SERVEZ CHAUD');

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
insert into COMPOSE values (17, 4, 8, 1);
insert into COMPOSE values (18, 4, 2, 1);
insert into COMPOSE values (19, 4, 1, 0);
insert into COMPOSE values (9, 4, 4, 1);
insert into COMPOSE values (20, 5, 500, 1);
insert into COMPOSE values (21, 5, 50, 1);
insert into COMPOSE values (22, 5, 3, 0);
insert into COMPOSE values (23, 5, 250, 1);
insert into COMPOSE values (24, 5, 1, 0);
insert into COMPOSE values (25, 5, 1, 0);



commit;
