package mg.project.miniprojet.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import mg.project.miniprojet.model.User;
import mg.project.miniprojet.model.Role;
import mg.project.miniprojet.repository.UserRepository;


@Service
public class AuthService {


   @Autowired
   private UserRepository userRepository;


   public User register(String email, String password) {


       User user = new User();
       user.setEmail(email);
       user.setPassword(password);
       user.setRole(Role.USER);


       return userRepository.save(user);
   }


   public User login(String email, String password) {


       Optional<User> user = userRepository.findByEmail(email);


       if(user.isPresent() && user.get().getPassword().equals(password)) {
           return user.get();
       }


       return null;
   }
}
