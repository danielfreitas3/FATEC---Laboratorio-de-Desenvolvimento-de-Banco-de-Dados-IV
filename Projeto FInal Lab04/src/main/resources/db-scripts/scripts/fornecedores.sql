--liquibase formatted sql

--changeset daniel:03
--comment: cria estrutura da tabela FORNECEDORES
CREATE TABLE fornecedor(
	forn_id INT AUTO_INCREMENT,
	forn_nome VARCHAR(50),
	forn_email VARCHAR(150),
	forn_telefone VARCHAR(15),
	forn_endereco VARCHAR(100),
	PRIMARY KEY(forn_id)
);
--rollback DROP TABLE fornecedores;