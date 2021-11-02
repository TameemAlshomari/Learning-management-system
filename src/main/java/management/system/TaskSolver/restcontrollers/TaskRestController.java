package management.system.TaskSolver.restcontrollers;

import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.Solution;
import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.repositories.UserRepository;
import management.system.TaskSolver.security.AuthenticatedUser;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import management.system.TaskSolver.repositories.SolutionRepository;


@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {
    
//    @Autowired
//    private TaskRepository taskRepository;
//    
//    @Autowired
//    private SolutionRepository messageRepository;
//    
// 
//    @Autowired
//    private UserRepository userRepository;
//    
//    private User getUser(Principal principal) {
//        String username = principal.getName();
//        return userRepository.findByUsername(username).get();
//    }
//    
//    @GetMapping("")
//    public ResponseEntity<Iterable<Task>> getAll(Principal principal) {
////        return ResponseEntity.ok(taskRepository.findAll());
//        User user = getUser(principal);
////        User user = authenticatedUser.getUser();
//// Another alternative: JsonIgnore or FetchType.EAGER on OneToMany lists        
//        User.Role role = user.getRole();
//        if (role.equals(User.Role.ROLE_ADMIN)) {
//            return ResponseEntity.ok(taskRepository.findAll());
//        } else {
//            return ResponseEntity.ok(user.getTasks());
//        }
//    }
//    
////    @Secured({ "ROLE_USER" })
//    @GetMapping("/{id}")
//    public ResponseEntity<Task> get(@PathVariable Integer id) {
//        Optional<Task> task = taskRepository.findById(id);
//        if (task.isPresent()) {
//            return ResponseEntity.ok(task.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    
//    @PostMapping("")
//    public ResponseEntity<Task> post(@RequestBody Task task, Principal principal) {
//        User user = getUser(principal);
//        task.setUser(user);
//        Task savedtask = taskRepository.save(task);
//        return ResponseEntity.ok(savedtask);
//    }

}
