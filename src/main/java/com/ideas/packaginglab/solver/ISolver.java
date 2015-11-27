/**
 * 
 */
package com.ideas.packaginglab.solver;

import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.LinearVariable;

/**
 * Base interface for all solver.
 * @author Amit
 *
 */
public interface ISolver<E extends LinearVariable, Z> {

	/**
	 * This method tries to solve given expression and returns result if successful.
	 * @return
	 */
	Expression<E, Z> solve(Expression<E, Z> expression,
			Z changedValue);
	
}
