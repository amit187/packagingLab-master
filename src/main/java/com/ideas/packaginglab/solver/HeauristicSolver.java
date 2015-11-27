/**
 * 
 */
package com.ideas.packaginglab.solver;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

import com.ideas.packaginglab.comparator.CoefficientComparator;
import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.ExpressionCoefficient;
import com.ideas.packaginglab.solver.model.LinearVariable;
import com.ideas.packaginglab.solver.util.Util;

/**
 * This class uses a heauristic to select the next possible item rather than checking all possible combination and hence non greedy.
 * @author Amit
 * @param <E>
 * @param <Z>
 * @since 25 Nov 2015
 */
public class HeauristicSolver<E extends LinearVariable, Z>  extends BaseSolver<E, Z>{

	
	/* (non-Javadoc)
	 * @see com.ideas.packaginglab.solver.ISolver#solve()
	 */
	@Override
	public Expression<E, Z> solve(final Expression<E, Z> expression,
			Z changedValue) {
		initialState(expression, changedValue);
		E weightAllowed = expression.getExpressionConstraint().getLimitValue();
		Collections.sort(expression.getExpressionCoefficients(), new CoefficientComparator());
		List<ExpressionCoefficient<E>> coefficients = expression.getExpressionCoefficients();
		for (int i=0; i < coefficients.size(); i++) {
			if(Util.compareTo(weightAllowed, coefficients.get(i).getConstrainedValue()) > 0) {
				expression.getExpressionVariables()[i] = changedValue;
				weightAllowed = (E) Util.adjustConstraint(weightAllowed, coefficients.get(i).getConstrainedValue(), -1);
			}
		}
		return expression;
	}
}
