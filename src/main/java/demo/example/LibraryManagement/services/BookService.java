package demo.example.LibraryManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.LibraryManagement.entities.Author;
import demo.example.LibraryManagement.entities.Book;
import demo.example.LibraryManagement.forms.BookForm;
import demo.example.LibraryManagement.repositories.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public void save(BookForm bookForm) {
        Book book = bookRepository.findById(bookForm.getId()).get();
        Author author = authorService.getById(bookForm.getAuthorId());
        bookRepository.save(bookForm.toEntity(book, author));
    }

}
