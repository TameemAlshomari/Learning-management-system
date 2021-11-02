package management.system.TaskSolver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.Solution;
import management.system.TaskSolver.entities.User;
import management.system.TaskSolver.repositories.TaskRepository;
import management.system.TaskSolver.repositories.UserRepository;
import management.system.TaskSolver.security.AuthenticatedUser;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import management.system.TaskSolver.repositories.SolutionRepository;

@Controller
public class MainController {
    
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Task> tasks =  taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "index";
    }
}
