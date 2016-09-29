--liquibase formatted sql

--changeset daniel:01
--comment: Create CLIENTE table structure
CREATE TABLE Cliente (
	cliente_id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	cliente_nome TEXT,
	cliente_sobrenome TEXT,
	cliente_dataNascimento DATE,
	cliente_celular TEXT,
	cliente_telefone TEXT
);
--rollback DROP TABLE Cliente;

--changeset daniel:02
--comment: Create PRODUTO table structure
CREATE TABLE Produto (
	produto_id	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	produto_nome	TEXT,
	produto_preco	REAL,
	produto_categoria TEXT,
	produto_quantidade INTEGER,
	produto_marca TEXT
	
);
--rollback DROP TABLE Produto;