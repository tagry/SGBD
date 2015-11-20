-- ============================================================
--    suppression des donnees
-- ============================================================

delete from ELEVE ;
delete from RECETTE ;
delete from ETAPE;
delete from ALIMENT ;
delete from NOTE ;
delete from COMPOSE;

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

-- RECETTE

-- ETAPE

-- NOTE

-- COMPOSE