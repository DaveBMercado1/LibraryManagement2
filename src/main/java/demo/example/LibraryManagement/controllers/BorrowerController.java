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

import demo.example.LibraryManagement.entities.Borrower;
import demo.example.LibraryManagement.forms.BorrowerForm;
import demo.example.LibraryManagement.services.BorrowerService;

@Controller
@RequestMapping("/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping
    public String index(Model model) {
        List<Borrower> borrowers = borrowerService.getAll();

        model.addAttribute("authors", borrowers);
        return "/views/author/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("borrowerForm", new BorrowerForm());
        return "/views/borrower/edit";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        BorrowerForm borrowerForm = borrowerService.getForm(id);
        model.addAttribute("borrowerForm", borrowerForm);
        return "/views/borrower/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        borrowerService.delete(id);
        return String.format("redirect:/%s/", "borrower");
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BorrowerForm borrowerForm) {
        borrowerService.save(borrowerForm);
        return String.format("redirect:/%s/", "borrower");
    }

}
