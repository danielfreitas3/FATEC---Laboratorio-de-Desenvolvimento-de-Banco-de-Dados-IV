--liquibase formatted sql

--changeset daniel:08
--comment: cria estrutura da tabela VENDA
CREATE TABLE venda(
	venda_id INT AUTO_INCREMENT,
	cli_id INT,
	func_id INT,
	prod_id INT,
	venda_formapagamento VARCHAR(20),
	venda_data DATE,
	PRIMARY KEY(venda_id)
);
--rollback DROP TABLE venda;
