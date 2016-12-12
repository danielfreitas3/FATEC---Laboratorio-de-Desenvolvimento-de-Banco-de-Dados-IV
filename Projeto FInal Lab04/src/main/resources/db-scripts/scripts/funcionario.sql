--liquibase formatted sql

--changeset daniel:01
--comment: cria estrutura da tabela FUNCIONARIO
CREATE TABLE funcionario (
	func_matricula INT AUTO_INCREMENT,
	user_id INT,
	func_nome VARCHAR (50),
	func_sobrenome VARCHAR(50),
	func_email VARCHAR(150),
	func_dataCadastro DATE,
	func_dataNascimento DATE,
	func_rg VARCHAR(12),
	func_endereco VARCHAR(100),
	func_salario DOUBLE,
	PRIMARY KEY(func_matricula)
);
--rollback DROP TABLE username;