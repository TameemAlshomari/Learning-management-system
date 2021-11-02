package management.system.TaskSolver.restcontrollers;

import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.repositories.UserRepository;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @Autowired
    private UserRepository userRepository;
    
    private User getUser(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get();
    }
    
    @PostMapping("login")
    public ResponseEntity<User> login(Principal principal) {
        return ResponseEntity.ok(getUser(principal));
    }
    
}
