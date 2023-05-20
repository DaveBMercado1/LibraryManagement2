package demo.example.LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import demo.example.LibraryManagement.entities.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Integer>, JpaSpecificationExecutor<Borrower> {

}
