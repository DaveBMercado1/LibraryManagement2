package demo.example.LibraryManagement.forms;

import demo.example.LibraryManagement.entities.Author;
import demo.example.LibraryManagement.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookForm {

    private int id;

    private String title;

    private int authorId;

    public Book toEntity(Book book, Author author) {
        if (book == null) {
            book = new Book();
        }

        book.setTitle(title);
        book.setAuthor(author);

        return book;
    }

}
