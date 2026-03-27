package mg.project.miniprojet.model;


import jakarta.persistence.*;
import java.util.Date;


@Entity
public class Borrow {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;


   @ManyToOne
   private User user;


   @ManyToOne
   private Book book;


   private Date borrowDate;
   private Date returnDate;


   public Borrow() {}


   public Long getId() { return id; }
   public User getUser() { return user; }
   public Book getBook() { return book; }
   public Date getBorrowDate() { return borrowDate; }
   public Date getReturnDate() { return returnDate; }


   public void setId(Long id) { this.id = id; }
   public void setUser(User user) { this.user = user; }
   public void setBook(Book book) { this.book = book; }
   public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate; }
   public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
}
