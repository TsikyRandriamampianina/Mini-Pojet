package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


import mg.project.miniprojet.model.Borrow;
import mg.project.miniprojet.model.User;
import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.repository.BorrowRepository;


@Service
public class BorrowService {


   @Autowired
   private BorrowRepository repository;


   public Borrow borrow(User user, Book book) {


       Borrow borrow = new Borrow();
       borrow.setUser(user);
       borrow.setBook(book);
       borrow.setBorrowDate(new Date());


       return repository.save(borrow);
   }


   public List<Borrow> findAll() {
       return repository.findAll();
   }


   public List<Borrow> findByUser(Long userId) {
       return repository.findByUserId(userId);
   }
}
