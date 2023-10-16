CREATE TABLE IF NOT EXISTS Affiliate (
     id serial NOT NULL,
     city varchar(255),
     name varchar(255),
     type_company varchar(255),
     contract_value DOUBLE PRECISION);

INSERT INTO Affiliate (city, name, type_company, contract_value)
VALUES ('Barbacena', 'Morada Hamburgueria', 'Restaurante', 5986.99);

INSERT INTO Affiliate (city, name, type_company, contract_value)
VALUES ('São Paulo', 'Mamonas Lanches', 'Lanchonete', 9845.99);

INSERT INTO Affiliate (city, name, type_company, contract_value)
VALUES ('Rio de Janeiro', 'Padoca Flair', 'Pizzaria', 6874.99);