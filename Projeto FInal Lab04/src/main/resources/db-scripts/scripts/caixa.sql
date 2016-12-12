--liquibase formatted sql

--changeset daniel:09
--comment: cria estrutura da tabela CAIXA
CREATE TABLE caixa(
	caixa_id INT AUTO_INCREMENT,
	caixa_data DATE,
	caixa_movimento DOUBLE,
	PRIMARY KEY(caixa_id)
);
--rollback DROP TABLE caixa;