/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management.system.TaskSolver.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import management.system.TaskSolver.entities.Solver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Tameem
 */
public interface SolverRepository extends CrudRepository<Solver, Integer> {

  
    List<Solver> findByTasksolver(Integer tasksolver);
}
