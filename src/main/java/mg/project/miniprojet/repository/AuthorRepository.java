package mg.project.miniprojet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import mg.project.miniprojet.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Long> {
}
