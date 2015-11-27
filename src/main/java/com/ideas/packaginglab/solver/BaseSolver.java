package com.ideas.packaginglab.solver;

import java.lang.reflect.Array;

import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.LinearVariable;

public abstract class BaseSolver<E extends LinearVariable, Z> implements ISolver<E, Z>{

	protected Expression<E, Z> expression;
	protected Z changedValue;

	public BaseSolver() {
		super();
	}

	protected void initialState(final Expression<E, Z> expression,
			Z changedValue ) {
		this.expression = expression;
		this.changedValue = changedValue;
		int totalVaribles = expression.getExpressionCoefficients().size();
		Z[] variables = (Z[]) Array.newInstance(changedValue.getClass(),
				totalVaribles);
		expression.setExpressionVariables(variables);
	
	}

	@Override
	public abstract Expression<E, Z> solve(Expression<E, Z> expression, Z changedValue);

}