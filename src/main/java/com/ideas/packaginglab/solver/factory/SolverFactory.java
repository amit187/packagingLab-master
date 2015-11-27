package com.ideas.packaginglab.solver.factory;

import com.ideas.packaginglab.solver.HeauristicSolver;
import com.ideas.packaginglab.solver.ISolver;
import com.ideas.packaginglab.solver.RecursiveSolver;
import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.LinearVariable;

/**
 * This class is a factory for creating various types of solver.
 * @author Amit
 *
 * @param <E>
 * @param <Z>
 */
public class SolverFactory<E extends LinearVariable, Z>  {
	
	/**
	 * This method creates various Solver depending on type passed.
	 * @param type
	 * @param expression
	 * @param changedValue
	 * @return
	 */
	public ISolver<E, Z> getSolver(SolverType type) {
		if(SolverType.NONGREEDY.equals(type)) {
			return new HeauristicSolver<E, Z>();
		} else {
			return new RecursiveSolver<E, Z>();
		}
	}

}
