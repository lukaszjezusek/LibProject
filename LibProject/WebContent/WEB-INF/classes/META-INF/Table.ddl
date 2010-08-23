CREATE TABLE APP.Book (id INTEGER NOT NULL, author VARCHAR(255), picsrc VARCHAR(255), title VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE APP.OPENJPA_SEQUENCE_TABLE (ID SMALLINT NOT NULL, SEQUENCE_VALUE BIGINT, PRIMARY KEY (ID));
CREATE TABLE APP.Review (id INTEGER NOT NULL, addDate DATE, content VARCHAR(255), BOOK_ID INTEGER, USER_ID INTEGER, PRIMARY KEY (id));
CREATE TABLE APP.WEBUSER -- User
    (id INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id));
ALTER TABLE APP.Review ADD FOREIGN KEY (BOOK_ID) REFERENCES APP.Book (id);
ALTER TABLE APP.Review ADD FOREIGN KEY (USER_ID) REFERENCES APP.WEBUSER (id);

INSERT INTO APP.Book VALUES (1, 'Kochan, Stephen G.', 'http://ecx.images-amazon.com/images/I/51m1tgiCfcL._SL75_.jpg', 'Programming in Objective-C 2.0, 2/e (Kindle Edition)');
INSERT INTO APP.Book values (2, 'David Sawyer McFarland', 'http://ecx.images-amazon.com/images/I/41Yl38t5vrL._SL160_PIsitb-sticker-arrow-dp,TopRight,12,-18_SH30_OU01_AA115_.jpg', 'CSS: The Missing Manual');
INSERT INTO APP.Book values (3, 'Barry A. Burd', 'http://ecx.images-amazon.com/images/I/51GA8M0nBeL._SL160_PIsitb-sticker-arrow-dp,TopRight,12,-18_SH30_OU01_AA115_.jpg', 'Beginning Programming with Java For Dummies');
