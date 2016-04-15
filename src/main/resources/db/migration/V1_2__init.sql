CREATE TABLE PERSON (
	id INT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name varchar(255) not null,
	last_name varchar(255) not null
);

insert into PERSON (first_name, last_name) values ('Dave', 'Syer');