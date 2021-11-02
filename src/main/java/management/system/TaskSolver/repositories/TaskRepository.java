package management.system.TaskSolver.repositories;


import management.system.TaskSolver.entities.Task;
import management.system.TaskSolver.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {
//        public Iterable<Task> findAllBytask(Task task);
       public Iterable<Task> findAllByUser(User user);
}
