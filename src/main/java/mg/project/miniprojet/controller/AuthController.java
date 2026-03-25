package mg.project.miniprojet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


import mg.project.miniprojet.dto.LoginDTO;
import mg.project.miniprojet.dto.RegisterDTO;
import mg.project.miniprojet.model.User;
import mg.project.miniprojet.service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {


   @Autowired
   private AuthService authService;


   @PostMapping("/register")
   public User register(@RequestBody RegisterDTO dto) {
       return authService.register(dto.getEmail(), dto.getPassword());
   }


   @PostMapping("/login")
    public Object login(@RequestBody LoginDTO dto) {


        String token = authService.login(dto.getEmail(), dto.getPassword());


        if(token == null) {
            return Map.of("message", "Invalid credentials");
        }


        return Map.of("token", token);
    }

}
