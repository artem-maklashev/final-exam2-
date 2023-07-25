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
DROP TABLE IF EXISTS packanimals_type;
CREATE TABLE packanimals_type(
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
	animals_type_id INT UNSIGNED NOT NULL DEFAULT 2,
	packanimals_type varchar(50),
	FOREIGN KEY (animals_type_id) REFERENCES animals_type(id)
);

INSERT INTO packanimals_type(packanimals_type) 
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


DROP TABLE IF EXISTS camels;
CREATE TABLE camels (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  packanimals_type_id INT UNSIGNED NOT NULL DEFAULT 2,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120),
  
  FOREIGN KEY (packanimals_type_id) REFERENCES packanimals_type(id)
);

INSERT INTO camels(name, birthday, command)
VALUES
	("Marlboro", "2015-03-08", "встать"),
	("Lucky", "2018-07-01", "вперед");

DROP TABLE IF EXISTS donkeys;
CREATE TABLE donkeys (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  
  packanimals_type_id INT UNSIGNED NOT NULL DEFAULT 3,
  name VARCHAR(50) NOT NULL,
  birthday DATE,
  command VARCHAR(120) ,  
  FOREIGN KEY (packanimals_type_id) REFERENCES packanimals_type(id)
);

INSERT INTO donkeys(name, birthday, command)
VALUES
	("Eeyore", "2019-03-08", "Но"),
	("Accer", "2021-12-31", "Стой");

## Удаляем из базы данных верблюдов
DROP TABLE camels;

## Создаем таблицу молодые животные
DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals (
  id INT AUTO_INCREMENT NOT NULL,
  name VARCHAR(50) NOT NULL,
  age INT NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO young_animals (name, age)
SELECT name, TIMESTAMPDIFF(MONTH, birthday, NOW()) AS Возраст_мес
FROM (
	SELECT name, birthday FROM cats 
	UNION ALL
	SELECT name, birthday FROM dogs 
) AS animals
WHERE birthday > DATE_SUB(NOW(), INTERVAL 3 YEAR) AND birthday < DATE_SUB(NOW(), INTERVAL 1 YEAR);

	
WHERE age > 1 AND age < 3;