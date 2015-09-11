INSERT INTO UTILISATEUR (UTI_ID, UTI_LOGIN, UTI_PWD)  VALUES (1, 'jeremy', '123456');

INSERT INTO UTILISATEUR (UTI_ID, UTI_LOGIN, UTI_PWD)  VALUES (2, 'pauline', 'popo');


INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX,PRD_IMAGE, UTI_ID) 
VALUES (666, 'Pokemon Pikachu', 'Superbe Pokemon Pikachu qui quand on lui tire la queue crie PIKACHU', 3.50, '/resources/img/produits/1.jpg', 1);

INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX,PRD_IMAGE, UTI_ID) 
VALUES (667, 'Pokemon Tortank', 'Superbe Pokemon Tortank qui crache de l''O', 2.43, '/resources/img/produits/2.png', 1);

INSERT INTO PRODUIT (PRD_ID, PRD_TITRE, PRD_DESCRIPTION, PRD_PRIX,PRD_IMAGE, UTI_ID) 
VALUES (668, 'Pokemon Florizarre', 'Florizarre qui fouette avec ses liannes', 8.67, '/resources/img/produits/3.png', 2);



INSERT INTO COMMENTAIRE (COM_ID, COM_CONTENU, PRD_ID, UTI_ID) 
VALUES (1, 'Le pikachu est-il fournit avec les piles ?', 666, 1);


-- commentaire avec accent éééààà