package management.system.TaskSolver.controllers;

import management.system.TaskSolver.entities.Solver;
import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.Solution;
import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.repositories.SolutionRepository;
import management.system.TaskSolver.repositories.SolverRepository;
import management.system.TaskSolver.repositories.UserRepository;
import management.system.TaskSolver.security.AuthenticatedUser;
import java.security.Principal;
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
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private UserRepository userRepository;
        @Autowired
    private SolverRepository solverRepository;

//    @Autowired
//    private AuthenticatedUser authenticatedUser;

    private User getUser(Principal principal) {
        String username = principal.getName();
        return userRepository.findByUsername(username).get();
    }

    @Secured({ "ROLE_GUEST", "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("")
    public String list(Model model, Principal principal) {

        model.addAttribute("tasks",  taskRepository.findAll());
        return "list"; //list.html
    }
    
  
    @Secured({ "ROLE_GUEST", "ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{id}")
    public String get(@PathVariable Integer id, Model model, Solution solution) throws Exception {
        Optional<Task> otask = taskRepository.findById(id);
        if (otask.isPresent()) {
            Task task = otask.get();
            model.addAttribute("task", task);

            return "task";
        }
        throw new Exception("No such task id");
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN" })
    @PostMapping("/{id}/solution")
    public String addSolution(Solver solver,Principal principal,@PathVariable Integer id, @Valid Solution solution, BindingResult bindingResult, Model model) throws Exception {
        if (bindingResult.hasErrors()) {
            return get(id, model, solution);
        }

        
        Task task = taskRepository.findById(id).get();
        solution.setId(null);
        solution.setTask(task);
        solutionRepository.save(solution);
        User user = getUser(principal);

        
        solver.setId(null);
        solver.tasksolver = id;
        solver.usersolver = user.getId();   
        solverRepository.save(solver);
        
        List<Solver> osolvers = solverRepository.findByTasksolver(id);  
         List<String> solvers = new ArrayList<String>(); 
         
            for(Solver s:osolvers){  
             System.out.println(s);                  
             System.out.println(s.usersolver);  
             Optional<User> ouser = userRepository.findById(s.usersolver);
             User myuser = ouser.get();
             String Username = myuser.getUsername();
             solvers.add(Username);
            System.out.println(Username); 
            }  
            for(String s:solvers){ 
                 System.out.println("solvers"+s); 
            }
    
        return "redirect:/success/{id}";
    }
 
    //logic explained
    // If there are  common letters between query and the task name , then fetch the task
    // I made this but based on common letter no matter to give attention to the order of this commom letter
    @Secured({"ROLE_USER", "ROLE_ADMIN" })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String query, Model model) throws Exception  {
        ArrayList<Task> otask =   (ArrayList<Task>) taskRepository.findAll();
        List<Task> results = new ArrayList<Task>(); 
            for(Task s:otask){ 
                 if (s.getTitle().contains(query)){                   
                       results.add(s);                   
                 }               
            }
            
            if( !results.isEmpty()){
                model.addAttribute("results", results);
                return "search"; 
            }
            else{
                throw new Exception("No such task id");
            }  

    }    

}
