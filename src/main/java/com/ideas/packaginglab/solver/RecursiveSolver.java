/**
 * 
 */
package com.ideas.packaginglab.solver;

import java.util.List;

import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.ExpressionCoefficient;
import com.ideas.packaginglab.solver.model.ExpressionConstraint;
import com.ideas.packaginglab.solver.model.LinearVariable;
import com.ideas.packaginglab.solver.util.Util;

/**
 * @author Amit
 *
 */
public class RecursiveSolver<E extends LinearVariable, Z> extends BaseSolver<E, Z>{


	/* (non-Javadoc)
	 * @see com.ideas.packaginglab.solver.ISolver#solve()
	 */
	@Override
	public Expression<E, Z> solve(final Expression<E, Z> expression,
			Z changedValue) {
		initialState(expression, changedValue);
		return solveRecursively(expression);
	}
	

	/**
	 * Recursion breaking condition as size == 1.
	 * @param expression
	 * @param isNotValid
	 * @param adjustedConstraint
	 * @param adjustedValueToOptimize
	 * @return
	 */
	private Expression<E, Z> checkForRecursionBreakingCondition(
			Expression<E, Z> expression, boolean isNotValid,
			ExpressionConstraint<E> adjustedConstraint,
			E adjustedValueToOptimize) {

		List<ExpressionCoefficient<E>> coefficients = expression
				.getExpressionCoefficients();
		Z[] expressionVariables = expression.getExpressionVariables();
		ExpressionConstraint<E> expressionConstraint = expression
				.getExpressionConstraint();

		if (coefficients.size() == 1) {
			if (isNotValid) {
				return new Expression<E, Z>(coefficients.subList(1,
						coefficients.size()), expression
						.getExpressionVariables().clone(),
						new ExpressionConstraint<E>(expressionConstraint
								.getLimitValue()),
						expression.getExpressionValue());
			} else {
				expressionVariables[expressionVariables.length
						- coefficients.size()] = changedValue;
				return new Expression<E, Z>(coefficients.subList(1,
						coefficients.size()), expression
						.getExpressionVariables().clone(), adjustedConstraint,
						adjustedValueToOptimize);
			}
		}
		return null;

	}

	/**
	 * This method will calculate the expression with and without the given item and return 
	 * the case where the expression value is optimum.
	 * 					  0
	 * 				0			1
	 * 			0		1	0		0
	 *               
	 * @param expression
	 * @return
	 */
	private Expression<E,Z> solveRecursively(Expression<E, Z> expression) {

		List<ExpressionCoefficient<E>> coefficients = expression
				.getExpressionCoefficients();
		Z[] expressionVariables = expression.getExpressionVariables();
		ExpressionConstraint<E> expressionConstraint = expression
				.getExpressionConstraint();
		E constrainedValue = coefficients.get(0).getConstrainedValue();
		E valueToOptimize = coefficients.get(0).getValueToOptimize();
		E expressionValue = expression.getExpressionValue();

		ExpressionConstraint<E> adjustedConstraint = new ExpressionConstraint<E>(
				(E) Util.adjustConstraint(expressionConstraint.getLimitValue(),
						constrainedValue, -1));
		E adjustedValueToOptimize = (E) Util.adjustConstraint(expressionValue,
				valueToOptimize, 1);

		boolean isNotValid = Util.compareTo(constrainedValue, expression
				.getExpressionConstraint().getLimitValue()) > 0;

		Expression solvedExpressed = checkForRecursionBreakingCondition(expression, isNotValid, adjustedConstraint, adjustedValueToOptimize);
		if(solvedExpressed != null) {
			return solvedExpressed;
		}
		if (isNotValid) {
			return solveRecursively(new Expression<E, Z>(
					coefficients.subList(1, coefficients.size()),
					expressionVariables.clone(), new ExpressionConstraint<E>(
							expressionConstraint.getLimitValue()),
					expressionValue));
		}
		/**
		 * Computing expression without the given coefficient
		 */
		Expression<E, Z> exp1 = solveRecursively(new Expression<E, Z>(
				coefficients.subList(1, coefficients.size()),
				expressionVariables.clone(), expressionConstraint,
				expressionValue));

		/**
		 * Computing expression with the given coefficient
		 */

		Expression<E, Z> exp2 = solveRecursively(new Expression<E, Z>(
				coefficients.subList(1, coefficients.size()),
				expressionVariables.clone(), adjustedConstraint,
				adjustedValueToOptimize));
		exp2.getExpressionVariables()[expressionVariables.length
				- coefficients.size()] = changedValue;

		/**
		 * Compare and return the optimal case.
		 */
		if (Util.compareTo(exp1.getExpressionValue(), exp2.getExpressionValue()) == 0) {
			if (Util.compareTo(exp1.getExpressionConstraint().getLimitValue(),
					exp2.getExpressionConstraint().getLimitValue()) > 0) {
				return exp1;
			} else {
				return exp2;
			}
		} else if (Util.compareTo(exp1.getExpressionValue(),
				exp2.getExpressionValue()) > 0) {
			return exp1;
		} else {
			return exp2;
		}

	}

	
}
