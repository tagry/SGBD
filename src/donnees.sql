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

commit;

-- RECETTE

insert into RECETTE values (1, 2, 'GATEAU AU CHOCOLAT', 'D', 10, 2, 10, 25);
insert into RECETTE values (2, 2, 'CREPE', 'D', 10, 1, 15, 30);

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

commit;
