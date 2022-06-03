INSERT INTO Flats (ID, AREA, DESCRIPTION, NAME, PRICE) VALUES (1, 75, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin viverra elit quis pretium gravida.', 'Flat1', 299);
INSERT INTO Flats (ID, AREA, DESCRIPTION, NAME, PRICE) VALUES (2, 130, 'Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.', 'Flat2', 599);
INSERT INTO Flats (ID, AREA, DESCRIPTION, NAME, PRICE) VALUES (3, 33, 'Nullam a tempor ex. Suspendisse potenti.', 'Flat3', 199);
INSERT INTO Flats (ID, AREA, DESCRIPTION, NAME, PRICE) VALUES (4, 180, 'Nullam tempus purus a nisl dapibus mollis.', 'Flat4', 1299);
INSERT INTO Flats (ID, AREA, DESCRIPTION, NAME, PRICE) VALUES (5, 100, 'Morbi id bibendum eros, non tincidunt nisl.', 'Flat5', 499);


INSERT INTO persons (ID, NAME) VALUES (1, 'Agnieszka');
INSERT INTO persons (ID, NAME) VALUES (2, 'Barbara');
INSERT INTO persons (ID, NAME) VALUES (3, 'Ewa');
INSERT INTO persons (ID, NAME) VALUES (4, 'Kacper');
INSERT INTO persons (ID, NAME) VALUES (5, 'Tomasz');
INSERT INTO persons (ID, NAME) VALUES (6, 'Karol');
INSERT INTO persons (ID, NAME) VALUES (7, 'Jolanta');
INSERT INTO persons (ID, NAME) VALUES (8, 'Iwona');
INSERT INTO persons (ID, NAME) VALUES (9, 'Ewelina');
INSERT INTO persons (ID, NAME) VALUES (10, 'Grzegorz');

INSERT INTO RESERVATIONS (RENTAL_FROM, RENTAL_TO, TOTAL_COST, FLAT_ID, HOST_ID, TENANT_ID)
VALUES('2022-02-02', '2022-02-03', 100, 1, 1, 2);
INSERT INTO RESERVATIONS (RENTAL_FROM, RENTAL_TO, TOTAL_COST, FLAT_ID, HOST_ID, TENANT_ID)
VALUES('2022-02-05', '2022-02-08', 100, 3, 2, 4);
