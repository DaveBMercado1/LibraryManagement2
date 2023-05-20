package demo.example.LibraryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.example.LibraryManagement.entities.Author;
import demo.example.LibraryManagement.forms.AuthorForm;
import demo.example.LibraryManagement.services.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String index(Model model) {
        List<Author> authors = authorService.getAll();

        model.addAttribute("message", "Hello from controller!");
        model.addAttribute("authors", authors);
        return "/views/author/index";
    }

    @GetMapping("/{name}")
    public String details(@PathVariable("name") String name, Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "/views/author/details";
    }

    @PostMapping("/save")
    public Author save(@RequestBody AuthorForm authorForm) {
        return authorService.save(authorForm);
    }

    @PutMapping("/update")
    public Author update(@Param("id") Integer id, @RequestBody AuthorForm authorForm) {
        Author author = authorService.getById(id);
        author.setName(authorForm.getName());
        return authorService.save(author);
    }

    @DeleteMapping("/delete")
    public List<Author> delete(@Param("id") Integer id) {
        authorService.delete(id);
        return authorService.getAll();
    }

}
