package mg.project.miniprojet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import mg.project.miniprojet.model.Borrow;
import java.util.List;


public interface BorrowRepository extends JpaRepository<Borrow, Long> {


   List<Borrow> findByUserId(Long userId);
}
