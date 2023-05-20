package demo.example.LibraryManagement.forms;

import demo.example.LibraryManagement.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorForm {

    private Integer id;

    private String name;

    public AuthorForm(Author author) {
        this.id = author.getId();
        this.name = author.getName();
    }

    public Author toEntity(Author author) {
        if (author == null) {
            author = new Author();
        }

        author.setName(name);

        return author;
    }

}
