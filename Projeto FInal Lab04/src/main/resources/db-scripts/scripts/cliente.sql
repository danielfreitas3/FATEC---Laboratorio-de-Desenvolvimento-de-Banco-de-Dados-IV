--liquibase formatted sql

--changeset daniel:06
--comment: cria estrutura da tabela CLIENTE
CREATE TABLE cliente(
	cli_id INT AUTO_INCREMENT,
	cli_nome VARCHAR(50),
	cli_sobrenome VARCHAR(50),
	cli_email VARCHAR(150),
	cli_rg VARCHAR(12),
	cli_endereco VARCHAR(100),
	cli_datacadastro DATE,
	cli_datanascimento DATE,
	PRIMARY KEY(cli_id)
);
--rollback DROP TABLE cliente;
