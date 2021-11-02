package management.system.TaskSolver.repositories;

import management.system.TaskSolver.entities.Solution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolutionRepository extends CrudRepository<Solution, Integer> {
//    public Iterable<Message> findAllBytask(task task);
}
