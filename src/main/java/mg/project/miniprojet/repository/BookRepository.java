package mg.project.miniprojet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import mg.project.miniprojet.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}
