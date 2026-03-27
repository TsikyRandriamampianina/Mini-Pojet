package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import mg.project.miniprojet.model.Borrow;
import mg.project.miniprojet.model.User;
import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.service.BorrowService;


@RestController
@RequestMapping("/api/borrows")
public class BorrowController {


   @Autowired
   private BorrowService service;


   @PostMapping
   public Borrow borrow(@RequestBody Borrow borrow) {
       return service.borrow(borrow.getUser(), borrow.getBook());
   }


   @GetMapping
   public List<Borrow> getAll() {
       return service.findAll();
   }
}
