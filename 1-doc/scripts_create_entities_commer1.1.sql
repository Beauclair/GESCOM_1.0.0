 DROP TABLE TAB_DVS;
 
 CREATE TABLE TAB_DVS (	
COD_DVS	VARCHAR(30),
LIB_DVS	VARCHAR(100),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY(COD_DVS)
);

COMMENT TAB_DVS IS 'Table des D�vises';
COMMENT TAB_DVS.COD_DVS IS 'Code de la D�vise';
COMMENT TAB_DVS.LIB_DVS IS 'Libell� de la D�vise';
COMMENT TAB_DVS.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_DVS.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_DVS.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_DVS.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';

DROP TABLE TAB_BNQ;

CREATE TABLE TAB_BNQ (	
COD_BNQ	VARCHAR(30) ,
LIB_BNQ	VARCHAR(100),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_BNQ)
);

COMMENT TAB_BNQ IS 'Table des Banques';
COMMENT TAB_BNQ.COD_BNQ IS 'Code de la Banque';
COMMENT TAB_BNQ.LIB_BNQ IS 'Libell� de la Banque';
COMMENT TAB_BNQ.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_BNQ.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_BNQ.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_BNQ.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';


DROP TABLE TAB_PRO;

CREATE TABLE TAB_PRO (	
COD_PRO	VARCHAR(30) ,
LIB_PRO	VARCHAR(100),
LIB_POSI_TARIF VARCHAR(100),
LIB_COLI VARCHAR(100),
VAL_QTE NUMERIC(19,2),
VAL_TOTAL_QTE NUMERIC(19,2),
LIB_POI_NET NUMERIC(19,2),
VAL_PRIX_DVS NUMERIC(19,2),
VAL_TOTAL_PRIX_DVS NUMERIC(19,2),
VAL_PRIX_CFA NUMERIC(19,2),
VAL_TOTAL_PRIX_CFA NUMERIC(19,2),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_PRO)
);

COMMENT TAB_PRO IS 'Table des Produits';
COMMENT TAB_PRO.COD_PRO IS 'Code Produit';
COMMENT TAB_PRO.LIB_PRO IS 'Libell� Produit';
COMMENT TAB_PRO.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_PRO.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_PRO.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_PRO.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';


DROP TABLE TAB_PAYS;

CREATE TABLE TAB_PAYS (	
COD_PAYS	VARCHAR(30) ,
LIB_PAYS	VARCHAR(100),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_PAYS)
);

COMMENT TAB_PAYS IS 'Table des Pays';
COMMENT TAB_PAYS.COD_PAYS IS 'Code Pays';
COMMENT TAB_PAYS.LIB_PAYS IS 'Libell� Pays';
COMMENT TAB_PAYS.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_PAYS.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_PAYS.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_PAYS.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';


DROP TABLE TAB_ACT;

CREATE TABLE TAB_ACT (	
NUM_COD_ACT	VARCHAR(30) ,
LIB_NAT_ACT_DEC	VARCHAR(100),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (NUM_COD_ACT)
);

COMMENT TAB_ACT IS 'Table des Activit�s';
COMMENT TAB_ACT.NUM_COD_ACT IS 'Code Activit�';
COMMENT TAB_ACT.LIB_NAT_ACT_DEC IS 'Libell� de l''Activit�';
COMMENT TAB_ACT.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_ACT.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_ACT.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_ACT.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';

DROP TABLE TAB_TRANS;

CREATE TABLE TAB_TRANS (	
COD_TRANS	VARCHAR(30) ,
LIB_TRANS	VARCHAR(100),
LIB_ADR	VARCHAR(255),
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_TRANS)
);

COMMENT TAB_TRANS IS 'Table des Transitaires';
COMMENT TAB_TRANS.COD_TRANS IS 'Code Transitaire';
COMMENT TAB_TRANS.LIB_TRANS IS 'Libell� Transitaire';
COMMENT TAB_TRANS.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_TRANS.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_TRANS.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_TRANS.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';


DROP TABLE TAB_FOUR;

CREATE TABLE TAB_FOUR (	
COD_FOUR	VARCHAR(30) ,
LIB_FOUR	VARCHAR(100),
LIB_ADR    VARCHAR(100),
LIB_BOI_POS VARCHAR(100),
LIB_EMAIL VARCHAR(100),
LIB_Fax VARCHAR(100),
LIB_TEL VARCHAR(30) ,
COD_PAYS	VARCHAR(30) ,
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_FOUR),
CONSTRAINT FK_COD_FOUR FOREIGN KEY (COD_PAYS) REFERENCES TAB_PAYS(COD_PAYS)
);

COMMENT TAB_FOUR IS 'Table des Fournisseurs';
COMMENT TAB_FOUR.COD_FOUR IS 'Code Fournisseur';
COMMENT TAB_FOUR.LIB_FOUR IS 'Libell� Fournisseur';
COMMENT TAB_FOUR.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_FOUR.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_FOUR.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_FOUR.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';

DROP TABLE TAB_IMP;

CREATE TABLE TAB_IMP (	
COD_NIU	VARCHAR(30) ,
LIB_IMP	VARCHAR(100),
LIB_ADR    VARCHAR(100),
LIB_BOI_POS VARCHAR(100),
LIB_EMAIL VARCHAR(100),
LIB_Fax VARCHAR(100),
LIB_TEL VARCHAR(30) ,
ETAT_ENT	VARCHAR(30),
COD_EXE_FIS	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY (COD_NIU)
);

COMMENT TAB_IMP IS 'Table des Importateurs';
COMMENT TAB_IMP.COD_IMP IS 'Code Importateur';
COMMENT TAB_IMP.LIB_IMP IS 'Libell� Importateur';
COMMENT TAB_IMP.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_IMP.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_IMP.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_IMP.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';


CREATE TABLE TAB_INC_COD (
  COD_INC_COD varchar(45) ,
  LIB_DESC varchar(45) ,
  VAL_INC_COD decimal(10,0),
  ETAT_ENT	VARCHAR(30),
  COD_EXE_FIS	VARCHAR(30),
  BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
  COD_USR_CRT	VARCHAR(30),
  COD_USR_MOD	VARCHAR(30),
  DAT_CRT	VARCHAR(30),
  DAT_MOD	VARCHAR(30), 
  COD_SITE_ID	VARCHAR(30),
  PRIMARY KEY (COD_INC_COD)
);

DROP TABLE TAB_AUT_SPE_IMP;
 
 CREATE TABLE TAB_AUT_SPE_IMP (	
COD_AUT	VARCHAR(30),
COD_IMP VARCHAR(30),
NUM_AUT	VARCHAR(30),
COD_ACT VARCHAR(30),
COD_FOUR VARCHAR(30),
COD_TRANS VARCHAR(30),
COD_BNQ	VARCHAR(30),
LIB_INT VARCHAR(200),
VAL_TOTAL_QTE NUMERIC(20,2) DEFAULT 0,
VAL_TOTAL_PRIX_DVS NUMERIC(20,2) DEFAULT 0,
VAL_TOTAL_PRIX_CFA NUMERIC(20,2) DEFAULT 0,
COD_PAYS_ORI VARCHAR(30),
COD_PAYS_PRO VARCHAR(30),
LIB_MOTIF VARCHAR(200),
COD_DVS VARCHAR(30),
LIB_DVS VARCHAR(200),
TAUX_DVS NUMERIC(5,2) DEFAULT 0,
LIB_BUR_DED	VARCHAR(200),
ENU_MOD_PAIE VARCHAR(30),
ENU_MOD_TRANS VARCHAR(30),
ENU_REL_FOUR VARCHAR(30),
DAT_AUT	VARCHAR(30),
BOO_ACT	 NUMERIC(1,0) DEFAULT 0,
COD_USR_CRT	VARCHAR(30),
COD_USR_MOD	VARCHAR(30),
DAT_CRT	VARCHAR(30),
DAT_MOD	VARCHAR(30), 
COD_SITE_ID	VARCHAR(30),
PRIMARY KEY(COD_AUT)
CONSTRAINT FK_TAB_AUT_SPE_IMP_TAB_IMP FOREIGN KEY (COD_IMP) REFERENCES TAB_IMP(COD_IMP)
CONSTRAINT FK_TAB_AUT_SPE_IMP_TAB_ACT FOREIGN KEY (COD_ACT) REFERENCES TAB_ACT(COD_ACT)
CONSTRAINT FK_TAB_AUT_SPE_IMP_TAB_FOUR FOREIGN KEY (COD_FOUR) REFERENCES TAB_FOUR(COD_FOUR)
CONSTRAINT FK_TAB_AUT_SPE_IMP_TAB_TRANS FOREIGN KEY (COD_TRANS) REFERENCES TAB_TRANS(COD_TRANS)
CONSTRAINT FK_TAB_AUT_SPE_IMP_TAB_BNQ FOREIGN KEY (COD_BNQ) REFERENCES TAB_BNQ(COD_BNQ)
);

COMMENT TAB_AUT_SPE_IMP IS 'Table des Autorisations Sp�ciales d''importation';
COMMENT TAB_AUT_SPE_IMP.COD_AUT IS 'Code de l''Autorisations Sp�ciales d''importation';
COMMENT TAB_AUT_SPE_IMP.LIB_DVS IS 'Libell� de l''Autorisations Sp�ciales d''importation';
COMMENT TAB_AUT_SPE_IMP.COD_USR_CRT IS 'Code de l''utilisateur ayant cr�� l''enregistrement';
COMMENT TAB_AUT_SPE_IMP.COD_USR_MOD IS 'Code de l''utilisateur ayant effectu� la derni�re modification sur l''enregistrement';
COMMENT TAB_AUT_SPE_IMP.DAT_CRT IS 'Date de cr�ation de l''enregistrement';
COMMENT TAB_AUT_SPE_IMP.DAT_MOD IS 'Date de la derni�re modification de l''enregistrement';

