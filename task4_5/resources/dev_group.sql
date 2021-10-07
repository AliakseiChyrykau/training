CREATE USER 'AlexChir'@'localhost' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON * . * TO 'AlexChir'@'localhost';
FLUSH PRIVILEGES;

DROP DATABASE IF EXISTS dev_group; 
CREATE DATABASE IF NOT EXISTS dev_group CHARACTER SET utf8 COLLATE utf8_general_ci;
USE dev_group;

DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Role VARCHAR(20) NOT NULL
);

INSERT roles(Role)
VALUES
    ('ADMIN'),
	('MANAGER'),
	('DEVELOPER'),
	('CUSTOMER');

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Login VARCHAR(20) NOT NULL,
	Password VARCHAR(20) NOT NULL,
    FirstName VARCHAR(20),
    LastName VARCHAR(20),
	Role_id INT NOT NULL,
	FOREIGN KEY (Role_id)  REFERENCES roles (Id)
);

INSERT INTO `users` (`Id`, `Login`, `Password`, `FirstName`, `LastName`, `Role_id`)
VALUES 
    (NULL, 'dev1', 'dev1', 'Разработчик1', 'Разработчик1', '3'),
	(NULL, 'Man1', 'Man1', 'Менеджер1', 'Менеджер1', '2'),
	(NULL, 'Cust1', 'Cust1', 'Клиент1', 'Клиент1', '4'),
	(NULL, 'admin', 'admin', 'Админ', 'Админ', '1'),
	(NULL, 'dev2', 'dev2', 'Разработчик2', 'Разработчик2', '3'),
	(NULL, 'Cus2', 'Cus2', 'Клиент2', 'Клиент2', '4'),
	(NULL, 'Cus3', 'Cus3', 'Клиент3', 'Клиент3', '4'),
	(NULL, 'Cus4', 'Cus4', 'Клиент4', 'Клиент4', '4'),
	(NULL, 'Man2', 'Man2', 'Менеджер2', 'Менеджер2', '2'),
	(NULL, 'Cus5', 'Cus5', 'Клиент5', 'Клиент5', '4'),
	(NULL, 'dev3', 'dev3', 'Разработчик3', 'Разработчик3', '3'),
	(NULL, 'dev4', 'dev4', 'Разработчик4', 'Разработчик4', '3'),
    (NULL, 'dev5', 'dev5', 'Разработчик5', 'Разработчик5', '3'),
	(NULL, 'dev6', 'dev6', 'Разработчик6', 'Разработчик6', '3');

DROP TABLE IF EXISTS developer_levels;
CREATE TABLE developer_levels
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Dev_Level VARCHAR(20) NOT NULL,
	Price INT NOT NULL
);

INSERT developer_levels(Dev_Level)
VALUES
    ('JUNIOR'),
	('MIDDLE'),
	('SENIOR');

DROP TABLE IF EXISTS technical_tasks;
CREATE TABLE technical_tasks
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Users_id INT NOT NULL,
        Date_create DATE NOT NULL,
	Dev_Level INT NOT NULL,
	Number_dev INT NOT NULL,
	FOREIGN KEY (users_id)  REFERENCES users (Id),
	FOREIGN KEY (Dev_Level)  REFERENCES developer_levels (Id)
);

DROP TABLE IF EXISTS list_works;
CREATE TABLE list_works
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Name VARCHAR(20) NOT NULL,
	Description TEXT NOT NULL,
	Technical_tasks_id INT NOT NULL,
	FOREIGN KEY (Technical_tasks_id)  REFERENCES technical_tasks (Id)
);

DROP TABLE IF EXISTS developer_status;
CREATE TABLE developer_status
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Dev_status VARCHAR(20) NOT NULL
);

INSERT developer_status(Dev_status)
VALUES
    ('FREE'),
	('WORK');

DROP TABLE IF EXISTS developers;
CREATE TABLE developers
(
    users_id INT PRIMARY KEY,
	Dev_Level INT NOT NULL,
	Dev_status_id INT NOT NULL,
	FOREIGN KEY (users_id)  REFERENCES users (Id),
	FOREIGN KEY (Dev_Level)  REFERENCES developer_levels (Id),
	FOREIGN KEY (Dev_status_id)  REFERENCES developer_status (Id)
);

INSERT INTO developers (users_id, Dev_Level, Dev_status_id)
 VALUES 
      ('1', '1', '1'),
	  ('5', '1', '1'),
	  ('11', '1', '1'),
	  ('12', '2', '1'),
	  ('13', '2', '1'),
	  ('14', '3', '1');

DROP TABLE IF EXISTS project_status;
CREATE TABLE project_status
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Pro_status VARCHAR(20) NOT NULL
);

DROP TABLE IF EXISTS projects;
CREATE TABLE projects
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Technical_tasks_id INT NOT NULL,
	Project_status_id INT NOT NULL,
	Summa INT, 
	FOREIGN KEY (Technical_tasks_id)  REFERENCES technical_tasks (Id),
	FOREIGN KEY (Project_status_id)  REFERENCES project_status (Id)
);

DROP TABLE IF EXISTS dev_to_Project;
CREATE TABLE dev_to_Project
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
	Developers_id INT NOT NULL,
	Projects_id INT NOT NULL,
	TIME_Project INT,
	FOREIGN KEY (developers_id)  REFERENCES developers (users_id),
	FOREIGN KEY (projects_id)  REFERENCES projects (Id)
);

DELIMITER $$
CREATE TRIGGER insert_users_trigger AFTER INSERT ON users FOR EACH ROW IF NEW.Role_id = 3 THEN
INSERT INTO developers (users_id, Dev_Level, Dev_status_id) VALUES (NEW.Id, '1', '1');
END IF
$$
DELIMITER ;
