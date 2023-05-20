package demo.example.LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.LibraryManagement.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
