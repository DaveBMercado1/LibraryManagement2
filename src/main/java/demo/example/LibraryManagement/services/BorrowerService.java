package demo.example.LibraryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.LibraryManagement.entities.Borrower;
import demo.example.LibraryManagement.forms.BorrowerForm;
import demo.example.LibraryManagement.repositories.BorrowerRepository;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrower> getAll() {
        return borrowerRepository.findAll();
    }

    public Borrower getById(Integer id) {
        return borrowerRepository.findById(id).get();
    }

    public BorrowerForm getForm(int id) {
        return new BorrowerForm(getById(id));
    }

    public Borrower save(BorrowerForm borrowerForm) {
        Borrower borrower = borrowerForm.getId() == null ? null : getById(borrowerForm.getId());
        return save(borrowerForm.toEntity(borrower));
    }

    public Borrower save(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    public void delete(Integer id) {
        borrowerRepository.delete(getById(id));
    }

}
