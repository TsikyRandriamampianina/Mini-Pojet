package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;


import mg.project.miniprojet.service.BorrowService;
import mg.project.miniprojet.model.Borrow;


@RestController
@RequestMapping("/api/users")
public class UserController {


   @Autowired
   private BorrowService borrowService;


   @GetMapping("/{id}/stats")
   public Map<String, Object> stats(@PathVariable Long id) {


       List<Borrow> borrows = borrowService.findByUser(id);


       Map<String, Object> result = new HashMap<>();
       result.put("userId", id);
       result.put("totalBorrows", borrows.size());


       return result;
   
   }
            }