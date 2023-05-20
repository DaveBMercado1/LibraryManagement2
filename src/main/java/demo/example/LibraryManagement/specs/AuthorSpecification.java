package demo.example.LibraryManagement.specs;

import org.springframework.data.jpa.domain.Specification;

import demo.example.LibraryManagement.entities.Author;

public class AuthorSpecification extends GenericSpecification<Author> {

    public static Specification<Author> id(int id) {
        return equal("id", id);
    }

    public static Specification<Author> name(String name) {
        return equal("name", name);
    }

    public static Specification<Author> nameLike(String name) {
        return like("name", name);
    }

}
