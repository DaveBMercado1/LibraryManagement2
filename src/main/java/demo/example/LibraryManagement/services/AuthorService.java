package demo.example.LibraryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.LibraryManagement.entities.Author;
import demo.example.LibraryManagement.forms.AuthorForm;
import demo.example.LibraryManagement.repositories.AuthorRepository;
import demo.example.LibraryManagement.specs.AuthorSpecification;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public Author getById(Integer id) {
        return authorRepository.findById(id).get();
    }

    public Author getByName(String name) {
        return authorRepository.findOne(AuthorSpecification.name(name)).get();
    }

    public AuthorForm getForm(int id) {
        return new AuthorForm(getById(id));
    }

    public Author save(AuthorForm authorForm) {
        Author author = authorForm.getId() == null ? null : getById(authorForm.getId());
        return save(authorForm.toEntity(author));
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public void delete(Integer id) {
        authorRepository.delete(getById(id));
    }

}
