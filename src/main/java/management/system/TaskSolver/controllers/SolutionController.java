package management.system.TaskSolver.controllers;

import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.Solution;
import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.repositories.SolutionRepository;
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

@Controller
@RequestMapping("/solution")
public class SolutionController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SolutionRepository solutionRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    @Secured({"ROLE_USER", "ROLE_ADMIN" })
    public String index() {
        return " ";
    }
//    
    @Secured({"ROLE_USER", "ROLE_ADMIN" })
    @GetMapping("/{id}")
    public String get(@PathVariable Integer id, Model model, Solution solution) throws Exception {
        Optional<Task> otask = taskRepository.findById(id);
        if (otask.isPresent()) {
            Task task = otask.get();
            model.addAttribute("task", task);

            return "solution";
        }
        throw new Exception("No such task id");
    }
   

    
}