drop table if exists Locadora;
create database if not exists Locadora;
use Locadora;

CREATE TABLE CLIENTE (
	codigoCliente int auto_increment not null,
    nome varchar(50),
    CPF varchar(14),
    email varchar(30),
    endereco varchar(50),
    dataNascimento Date,
    PRIMARY KEY (codigoCliente)
);

CREATE TABLE FILME (
	codigoFilme int auto_increment not null,
    titulo varchar(20),
    genero varchar(20),
    sinopse varchar(50),
    duracao int,
    PRIMARY KEY(codigoFilme)	
);

CREATE TABLE ATOR (
	codigoAtor int auto_increment not null,
    nome varchar(30),
    nacionalidade varchar(20),
    PRIMARY KEY(codigoAtor)
);

CREATE TABLE FILME_ATOR (
	codigoFilme int not null,
    codigoAtor int not null,
    PRIMARY KEY(codigoFilme, codigoAtor),
    FOREIGN KEY (codigoFilme) REFERENCES Ator(codigoAtor),
    FOREIGN KEY (codigoAtor) REFERENCES Filme(codigoFilme)
);

CREATE TABLE ITEM (
	codigoItem int auto_increment not null,
    codigoFilme int,
    codigoCliente int,
    preco float,
    tipo varchar(20),
    dataLocacao Date,
    dataDevolucao Date,
    PRIMARY KEY (codigoItem),
    FOREIGN KEY (codigoFilme) REFERENCES Filme(codigoFilme),
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigoCliente)
);

SELECT * FROM filme
