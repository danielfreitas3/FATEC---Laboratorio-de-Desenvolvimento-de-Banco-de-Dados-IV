--liquibase formatted sql

--changeset daniel:04
--comment: cria estrutura da tabela CATEGORIAPRODUTOS
CREATE TABLE categoriaproduto(
	catprod_id INT AUTO_INCREMENT,
	catprod_nome VARCHAR(50),
	catprod_descricao VARCHAR(150),
	PRIMARY KEY(catprod_id)
);
--rollback DROP TABLE categoriaprodutos;