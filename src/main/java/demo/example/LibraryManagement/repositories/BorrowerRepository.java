package demo.example.LibraryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import demo.example.LibraryManagement.entities.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Integer>, JpaSpecificationExecutor<Borrower> {

}
