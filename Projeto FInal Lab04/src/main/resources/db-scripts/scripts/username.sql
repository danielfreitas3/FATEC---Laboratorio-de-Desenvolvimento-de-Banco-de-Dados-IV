--liquibase formatted sql

--changeset daniel:02
--comment: cria estrutura da tabela USERNAME
CREATE TABLE username (
	user_id INT AUTO_INCREMENT,
	user_nomeusuario VARCHAR(50),	
	user_senha VARCHAR(50),
	PRIMARY KEY(user_id)
);
--rollback DROP TABLE username;
