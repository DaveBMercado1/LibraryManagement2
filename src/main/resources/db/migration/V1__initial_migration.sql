CREATE TABLE authors (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL
);

CREATE TABLE borrowers (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL
);

CREATE TABLE books (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author_id int NOT NULL,
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

CREATE TABLE borrowed_books (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    borrower_id int NOT NULL,
    book_id int NOT NULL,
    FOREIGN KEY (borrower_id) REFERENCES borrowers(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);