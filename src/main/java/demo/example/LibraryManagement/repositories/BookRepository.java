package demo.example.LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.example.LibraryManagement.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
