package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import mg.project.miniprojet.model.Category;
import mg.project.miniprojet.repository.CategoryRepository;


@Service
public class CategoryService {


   @Autowired
   private CategoryRepository repository;


   public Category save(Category category) {
       return repository.save(category);
   }


   public List<Category> findAll() {
       return repository.findAll();
   }
}
