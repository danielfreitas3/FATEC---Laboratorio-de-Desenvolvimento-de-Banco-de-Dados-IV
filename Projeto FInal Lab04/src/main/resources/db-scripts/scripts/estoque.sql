--liquibase formatted sql

--changeset daniel:07
--comment: cria estrutura da tabela ESTOQUE
CREATE TABLE estoque(
	estoq_id INT AUTO_INCREMENT,
	prod_id INT,
	forn_id INT,
	estoq_quantidade INT,
	PRIMARY KEY (estoq_id)	
);
--rollback DROP TABLE estoque;
