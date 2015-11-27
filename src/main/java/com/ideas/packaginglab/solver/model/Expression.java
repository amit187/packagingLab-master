/**
 * 
 */
package com.ideas.packaginglab.solver.model;

import java.util.Arrays;
import java.util.List;

/**
 * This class represents Linear expression.
 * @author Amit
 * @since 25 Nov 2015
 */
public class Expression<E extends LinearVariable, Z> {
	
	/**
	 * List of coefficients.
	 */
	private List<ExpressionCoefficient<E>> expressionCoefficients;
	
	/**
	 * Array of computed variables.
	 */
	private Z[] expressionVariables;
	
	/**
	 * Expression optimized value.
	 */
	private E expressionValue;
	

	/**
	 * Expression constrained value
	 */
	private ExpressionConstraint<E> expressionConstraint;

	
	/**
	 * @param expressionCoefficients
	 * @param expressionVariables
	 * @param expressionConstraint
	 */
	public Expression(List<ExpressionCoefficient<E>> expressionCoefficients,
			Z[] expressionVariables,
			ExpressionConstraint<E> expressionConstraint, E expressionValue) {
		super();
		this.expressionCoefficients = expressionCoefficients;
		this.expressionVariables = expressionVariables;
		this.expressionConstraint = expressionConstraint;
		this.expressionValue = expressionValue;
	}


	/**
	 * @return the expressionCoefficients
	 */
	public List<ExpressionCoefficient<E>> getExpressionCoefficients() {
		return expressionCoefficients;
	}

	/**
	 * @param expressionCoefficients the expressionCoefficients to set
	 */
	public void setExpressionCoefficients(
			List<ExpressionCoefficient<E>> expressionCoefficients) {
		this.expressionCoefficients = expressionCoefficients;
	}

	/**
	 * @return the expressionVariables
	 */
	public Z[] getExpressionVariables() {
		return expressionVariables;
	}

	/**
	 * @param expressionVariables the expressionVariables to set
	 */
	public void setExpressionVariables(Z[] expressionVariables) {
		this.expressionVariables = expressionVariables;
	}

	/**
	 * @return the expressionConstraint
	 */
	public ExpressionConstraint<E> getExpressionConstraint() {
		return expressionConstraint;
	}

	/**
	 * @param expressionConstraint the expressionConstraint to set
	 */
	public void setExpressionConstraint(ExpressionConstraint<E> expressionConstraint) {
		this.expressionConstraint = expressionConstraint;
	}

	/**
	 * @return the expressionValue
	 */
	public E getExpressionValue() {
		return expressionValue;
	}

	/**
	 * @param expressionValue the expressionValue to set
	 */
	public void setExpressionValue(E expressionValue) {
		this.expressionValue = expressionValue;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Expression [expressionCoefficients=" + expressionCoefficients
				+ ", expressionVariables="
				+ Arrays.toString(expressionVariables) + ", expressionValue="
				+ expressionValue + ", expressionConstraint="
				+ expressionConstraint + "]";
	}




}
