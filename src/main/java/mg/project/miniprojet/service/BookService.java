package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


import mg.project.miniprojet.model.Book;
import mg.project.miniprojet.repository.BookRepository;


@Service
public class BookService {


   @Autowired
   private BookRepository repository;

   @Autowired
    private BorrowRepository borrowRepository;

   public Book save(Book book) {
       return repository.save(book);
   }


   public List<Book> findAll() {
       return repository.findAll();
   }

    public List<Map<String, Object>> getTopBooks() {


    List<Borrow> borrows = borrowRepository.findAll();


    Map<Long, Long> countMap = borrows.stream()
            .collect(Collectors.groupingBy(
                    b -> b.getBook().getId(),
                    Collectors.counting()
            ));


    List<Map<String, Object>> result = new ArrayList<>();


    for (Map.Entry<Long, Long> entry : countMap.entrySet()) {


        Long bookId = entry.getKey();
        Long count = entry.getValue();


        Optional<Book> bookOpt = repository.findById(bookId);


        if (bookOpt.isPresent()) {
            Map<String, Object> map = new HashMap<>();
            map.put("book", bookOpt.get().getTitle());
            map.put("borrowCount", count);
            result.add(map);
        }
    }


    return result;
    }

}
