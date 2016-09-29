--liquibase formatted sql

--changeset nadalete:01
--comment: Create STOCK table structure
CREATE TABLE Stock (
	stock_id	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	stock_code	TEXT,
	stock_name	TEXT
);
--rollback DROP TABLE Stock;

--changeset nadalete:02
--comment: Create CATEGORY table structure
CREATE TABLE Category (
	category_id	INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE,
	category_name	TEXT,
	category_desc	TEXT
);
--rollback DROP TABLE Category;

--changeset nadalete:03
--comment: Create Stock_Category table structure
CREATE TABLE Stock_Category (
	stock_id	INTEGER,
	category_id	INTEGER,
	PRIMARY KEY(`stock_id`,`category_id`),
	FOREIGN KEY(stock_id) REFERENCES Stock(stock_id),
	FOREIGN KEY(category_id) REFERENCES Category(category_id)
);
--rollback DROP TABLE Stock_Category;