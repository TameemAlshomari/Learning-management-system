
/**
 *
 * @author Tameem
 */

package management.system.TaskSolver.controllers;

import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.Solution;
import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.entities.Solver;
import management.system.TaskSolver.repositories.SolverRepository;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.repositories.SolutionRepository;
import management.system.TaskSolver.repositories.UserRepository;
import management.system.TaskSolver.security.AuthenticatedUser;
import java.security.Principal;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/success")
public class SuccessController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SolverRepository solverRepository;
//    @RequestMapping("/")
//    @Secured({"ROLE_USER", "ROLE_ADMIN" })
//    public String index() {
//        return " ";
//    }
//    
       private User getUser(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get();
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{id}")
    public String success(@PathVariable Integer id, Model model, Solution solution) throws Exception { 
//        User user = getUser(principal);
        Optional<Task> otask = taskRepository.findById(id);
        
         List<Solver> osolvers = solverRepository.findByTasksolver(id);  
         List<String> solvers = new ArrayList<String>(); 
         
            for(Solver s:osolvers){  
             System.out.println(s);                  
             System.out.println(s.usersolver);  
             Optional<User> ouser = userRepository.findById(s.usersolver);
             User user = ouser.get();
             String Username = user.getUsername();
             solvers.add(Username);
            System.out.println(Username); 
            }  
            for(String s:solvers){ 
                 System.out.println("solvers"+s); 
            }
            
  
        if (otask.isPresent()) {
            Task task = otask.get();

            
            model.addAttribute("task", task);
            model.addAttribute("solvers", solvers);
         
            return "success";
        }
        throw new Exception("No such task id");
    }

    
}