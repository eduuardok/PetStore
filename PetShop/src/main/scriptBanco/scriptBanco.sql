create database petshop;

use petshop;

create table cachorro (
id int not null auto_increment,
nome varchar(100),
raca varchar(100),
peso double(10,2),
porte varchar(15),
altura double(10,2),
cor varchar(50),
status_adocao varchar(20),
primary key (id));

insert into cachorro (nome, raca, peso, porte, altura, cor, status_adocao) values ('Clebson', 'Bull Terrier', 10.0, 'Médio', 0.5, 'Branco', 'Disponível adoção');
