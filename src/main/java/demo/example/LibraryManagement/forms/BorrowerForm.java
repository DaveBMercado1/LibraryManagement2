package demo.example.LibraryManagement.forms;

import demo.example.LibraryManagement.entities.Borrower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowerForm {

    private Integer id;

    private String name;

    private String email;

    public BorrowerForm(Borrower borrower) {
        this.id = borrower.getId();
        this.name = borrower.getName();
        this.email = borrower.getEmail();
    }

    public Borrower toEntity(Borrower borrower) {
        if (borrower == null) {
            borrower = new Borrower();
        }

        borrower.setName(name);
        borrower.setEmail(email);

        return borrower;
    }

}
