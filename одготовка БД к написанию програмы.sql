## Создаем таблицу с общими типами животных для подготовки к написанию программы
DROP TABLE IF EXISTS animals_kind;
CREATE TABLE animals_kind (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type varchar(50), 
  animals_type_id INT UNSIGNED NOT NULL,
  FOREIGN KEY (animals_type_id) REFERENCES animals_type(id)
);

INSERT INTO animals_kind (type, animals_type_id)
SELECT pets_type, animals_type_id
FROM pets_type
UNION ALL
SELECT packanimals_type, animals_type_id
FROM packanimals_type;

## Приводим в соответствие id в таблице animals
UPDATE animals 
SET type_id = type_id +3
WHERE animal_type_id =2;

ALTER TABLE animals 
ADD FOREIGN KEY (type_id)
REFERENCES animals_kind(id);