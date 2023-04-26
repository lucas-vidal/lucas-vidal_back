USE lucas_vidal;

CREATE TABLE users (
	username CHAR(50) PRIMARY KEY,
	password CHAR(50),
	name CHAR(50),
	surname CHAR(50),
    img CHAR(50)
);

CREATE TABLE about (
  id INT PRIMARY KEY AUTO_INCREMENT,
  about TEXT
);

CREATE TABLE experience (
  id INT PRIMARY KEY AUTO_INCREMENT,
  position TEXT,
  company TEXT,
  form DATE,
  until DATE,
  description TEXT,
  link CHAR(100)
);

CREATE TABLE education (
  id INT PRIMARY KEY AUTO_INCREMENT,
  institute TEXT,
  certificate TEXT,
  form DATE,
  until DATE,
  link CHAR(100)
);

CREATE TABLE projects (
  id INT PRIMARY KEY AUTO_INCREMENT,
  title CHAR(100),
  description TEXT,
  link CHAR(100)
);

CREATE TABLE skills (
  id INT PRIMARY KEY AUTO_INCREMENT,
  skill CHAR(50),
  value INT
);