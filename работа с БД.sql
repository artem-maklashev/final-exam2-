DROP DATABASE IF EXISTS animals;
CREATE DATABASE animals;

USE animals;

DROP TABLE IF EXISTS animals_type;
CREATE TABLE animals_type(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animal_type varchar(50)
);

INSERT INTO animals_type(animal_type) 
VALUES
	("pets"),
	("packanimals");

DROP TABLE IF EXISTS pets_type;
CREATE TABLE pets_type(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animals_type_id INT UNSIGNED NOT NULL DEFAULT 1,
	pets_type varchar(50),
	FOREIGN KEY (animals_type_id) REFERENCES animals_type(id)
);

INSERT INTO pets_type(pets_type) 
VALUES
	("cat"),
	("dog"),
	("humster");



DROP TABLE IF EXISTS cats;
CREATE TABLE cats (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  pets_type_id INT UNSIGNED NOT NULL DEFAULT 1,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120) ,
  
  FOREIGN KEY (pets_type_id) REFERENCES pets_type(id)
  );

INSERT INTO cats(name, birthday, command)
VALUES
	("Luna", "2023-06-15", "ко мне, кушать"),
	("Tomas", "2020-02-18", "кувырок");

DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  pets_type_id INT UNSIGNED NOT NULL DEFAULT 2,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120),
  
  FOREIGN KEY (pets_type_id) REFERENCES pets_type(id)
);

INSERT INTO dogs(name, birthday, command)
VALUES
	("Rex", "2021-03-08", "ко мне, лапу, сидеть, лежать"),
	("Tomas", "2022-09-16", "ко мне, место, лежать");

DROP TABLE IF EXISTS humsters;
CREATE TABLE humsters (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  pets_type_id INT UNSIGNED NOT NULL DEFAULT 3,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120) ,  
  FOREIGN KEY (pets_type_id) REFERENCES pets_type(id)
);

INSERT INTO humsters(name, birthday, command)
VALUES
	("Popcorn", "2023-03-08", ""),
	("Chewy", "2022-11-01", "");

## Вьючные животные
DROP TABLE IF EXISTS ackanimals_type;
CREATE TABLE packanimals_type(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animals_type_id INT UNSIGNED NOT NULL DEFAULT 2,
	packanimals_type varchar(50),
	FOREIGN KEY (animals_type_id) REFERENCES animals_type(id)
);

INSERT INTO pets_type(packanimals_type) 
VALUES
	("horse"),
	("camel"),
	("donkey");



DROP TABLE IF EXISTS horses;
CREATE TABLE horses (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  packanimals_type_id INT UNSIGNED NOT NULL DEFAULT 1,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120) ,
  
  FOREIGN KEY (packanimals_type_id) REFERENCES packanimals_type(id)
  );

INSERT INTO horses(name, birthday, command)
VALUES
	("Shadow", "2018-04-13", "но"),
	("Spirit", "2021-10-25", "пррр");









### продолжить от сюда
DROP TABLE IF EXISTS dogs;
CREATE TABLE dogs (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  pets_type_id INT UNSIGNED NOT NULL DEFAULT 2,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120),
  
  FOREIGN KEY (pets_type_id) REFERENCES pets_type(id)
);

INSERT INTO dogs(name, birthday, command)
VALUES
	("Rex", "2021-03-08", "ко мне, лапу, сидеть, лежать"),
	("Tomas", "2022-09-16", "ко мне, место, лежать");

DROP TABLE IF EXISTS humsters;
CREATE TABLE humsters (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  pets_type_id INT UNSIGNED NOT NULL DEFAULT 3,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120) ,  
  FOREIGN KEY (pets_type_id) REFERENCES pets_type(id)
);

INSERT INTO humsters(name, birthday, command)
VALUES
	("Popcorn", "2023-03-08", ""),
	("Chewy", "2022-11-01", "");

