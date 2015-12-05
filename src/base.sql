-- ============================================================
--   Nom de la base   :  RECETTE                               
--   Nom de SGBD      :  ORACLE Version 7.0                    
--   Date de creation :  13/11/2015  16:44                       
-- ============================================================

drop table ELEVE cascade constraints;

drop table RECETTE cascade constraints;

drop table ETAPE cascade constraints;

drop table ALIMENT cascade constraints;

drop table NOTE cascade constraints;

drop table COMPOSE cascade constraints;

-- ============================================================
-- TYPE
-- ===================================
--create TYPE NOTE_VALUE AS ENUM('0','1','2','3','4','5');

-- ============================================================
--   Table : ELEVE                                            
-- ============================================================
create table ELEVE
(
    NUMERO_ELEVE                    NUMBER(4)              not null,
    NOM_ELEVE                       VARCHAR(20)               not null,
    PRENOM_ELEVE                    VARCHAR(20)                       ,
    constraint pk_eleve primary key (NUMERO_ELEVE)
);

-- ============================================================
--   Table : RECETTE                                       
-- ============================================================
create table RECETTE
(
    NUMERO_RECETTE              NUMBER(4)               not null,
    NUMERO_CREATEUR             NUMBER(4)               not null,
    NOM_RECETTE                 VARCHAR(30)                not null,
    CATEGORIE                   CHAR(1)                         ,
    BUDGET                      NUMBER(3)                       ,
    DIFFICULTE                  NUMBER(1)                       ,
    TEMPS_DE_PREPARATION        NUMBER(3)                       ,
    TEMPS_DE_CUISSON            NUMBER(3)                       ,
    constraint pk_recette primary key (NUMERO_RECETTE)
);

-- ============================================================
--   Table : ALIMENT                                              
-- ============================================================
create table ALIMENT
(
    NUMERO_ALIMENT                NUMBER(4)              not null,
    NOM_ALIMENT                   VARCHAR(20)               not null,
    MESURE                        VARCHAR(30)               not null,
    constraint pk_aliment primary key (NUMERO_ALIMENT)
);

-- ============================================================
--   Table : ETAPE                                              
-- ============================================================
create table ETAPE
(
    NUMERO_ETAPE                    NUMBER(5)              not null,
    NUMERO_RECETTE                  NUMBER(4)              not null,
    DESCRIPTION                     VARCHAR(200)              not null,
    constraint pk_etape primary key (NUMERO_ETAPE)
);

-- ============================================================
--   Table : NOTE                                              
-- ============================================================
create table NOTE
(
    NUMERO_ELEVE                    NUMBER(4)              not null,
    NUMERO_RECETTE                  NUMBER(4)              not null,
    NOTE_GASTRONOMIQUE              NUMBER(1)                      ,
    NOTE_BUDGET                     NUMBER(1)                      ,
    NOTE_DIFFICULTE                 NUMBER(1)                      ,
    constraint pk_note primary key (NUMERO_ELEVE, NUMERO_RECETTE)
);

-- ============================================================
--   Table : COMPOSE                                              
-- ============================================================
create table COMPOSE
(
    NUMERO_ALIMENT                  NUMBER(5)              not null,
    NUMERO_RECETTE                  NUMBER(4)              not null,
    QUANTITE                        NUMBER(5)                      ,
    MOT_CLE                         NUMBER(1)              not null,
    constraint pk_compose primary key (NUMERO_ALIMENT, NUMERO_RECETTE)
);


alter table COMPOSE
    add constraint fk1_compose foreign key (NUMERO_ALIMENT)
       references ALIMENT (NUMERO_ALIMENT);

alter table COMPOSE
    add constraint fk2_compose foreign key (NUMERO_RECETTE)
       references RECETTE (NUMERO_RECETTE);

alter table NOTE
    add constraint fk1_note foreign key (NUMERO_ELEVE)
       references ELEVE (NUMERO_ELEVE);

alter table NOTE
    add constraint fk2_note foreign key (NUMERO_RECETTE)
       references RECETTE (NUMERO_RECETTE);

alter table RECETTE
    add constraint fk1_recette foreign key (NUMERO_CREATEUR)
       references ELEVE (NUMERO_ELEVE);

alter table ETAPE
    add constraint fk1_etape foreign key (NUMERO_RECETTE)
       references RECETTE (NUMERO_RECETTE);
