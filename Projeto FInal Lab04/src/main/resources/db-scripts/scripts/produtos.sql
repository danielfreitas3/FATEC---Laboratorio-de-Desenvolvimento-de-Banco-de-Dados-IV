--liquibase formatted sql

--changeset daniel:05
--comment: cria estrutura da tabela PRODUTOS
CREATE TABLE produto(
	prod_id INT AUTO_INCREMENT,
	catprod_id INT,
	prod_preco DOUBLE,
	prod_nome VARCHAR(50),
	prod_tipo VARCHAR(50),
	PRIMARY KEY(prod_id)
);
--rollback DROP TABLE produtos;
