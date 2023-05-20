package demo.example.LibraryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("authorForm", new AuthorForm());
        return "/views/author/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        AuthorForm authorForm = authorService.getForm(id);
        model.addAttribute("authorForm", authorForm);
        return "/views/author/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        authorService.delete(id);
        return String.format("redirect:/%s", "author");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute AuthorForm authorForm) {
        authorService.save(authorForm);
        return String.format("redirect:/%s", "author");
    }

}
