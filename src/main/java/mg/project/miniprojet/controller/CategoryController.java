package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import mg.project.miniprojet.model.Category;
import mg.project.miniprojet.service.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {


   @Autowired
   private CategoryService service;


   @PostMapping
   public Category create(@RequestBody Category category) {
       return service.save(category);
   }


   @GetMapping
   public List<Category> getAll() {
       return service.findAll();
   }
}
