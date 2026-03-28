package mg.project.miniprojet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import mg.project.miniprojet.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
