INSERT INTO authors (`name`) VALUES ("Neil Gaiman");
INSERT INTO authors (`name`) VALUES ("Jennifer Lynn Barnes");
INSERT INTO authors (`name`) VALUES ("Rick Riordan");
INSERT INTO authors (`name`) VALUES ("She who shall not be named");

INSERT INTO borrowers (`name`, email) VALUES ("Dave", "dave@example.com");
INSERT INTO borrowers (`name`, email) VALUES ("Kim", "kim@example.com");
INSERT INTO borrowers (`name`, email) VALUES ("Mark", "mark@example.com");

INSERT INTO books (title, author_id) VALUES ("The lightning thief", 3);
INSERT INTO books (title, author_id) VALUES ("The sword of summer", 3);
INSERT INTO books (title, author_id) VALUES ("Good Omens", 1);
INSERT INTO books (title, author_id) VALUES ("The inheritance games", 2);
INSERT INTO books (title, author_id) VALUES ("The Hawthorne Legacy", 2);
INSERT INTO books (title, author_id) VALUES ("Harry Potter", 4);

INSERT INTO borrowed_books (borrower_id, book_id) VALUES (1, 2);
INSERT INTO borrowed_books (borrower_id, book_id) VALUES (2, 5);
INSERT INTO borrowed_books (borrower_id, book_id) VALUES (3, 1);
