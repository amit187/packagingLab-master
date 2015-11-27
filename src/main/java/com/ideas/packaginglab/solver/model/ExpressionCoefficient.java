package com.ideas.packaginglab.solver.model;

/**
 * This class represents individual coefficeint participating in Linear Expression.
 * @author Amit
 * @since 25 Nov 2015
 */
public class ExpressionCoefficient<E extends LinearVariable> {

	/**
	 * Value to be constrained depending on expression value.
	 */
	private E constrainedValue;
	
	/**
	 * Value to be optimized.
	 */
	private E valueToOptimize;

	/**
	 * @param constrainedValue
	 * @param valueToOptimize
	 */
	public ExpressionCoefficient(E constrainedValue, E valueToOptimize) {
		super();
		this.constrainedValue = constrainedValue;
		this.valueToOptimize = valueToOptimize;
	}

	/**
	 * @return the constrainedValue
	 */
	public E getConstrainedValue() {
		return constrainedValue;
	}

	/**
	 * @param constrainedValue the constrainedValue to set
	 */
	public void setConstrainedValue(E constrainedValue) {
		this.constrainedValue = constrainedValue;
	}

	/**
	 * @return the valueToOptimize
	 */
	public E getValueToOptimize() {
		return valueToOptimize;
	}

	/**
	 * @param valueToOptimize the valueToOptimize to set
	 */
	public void setValueToOptimize(E valueToOptimize) {
		this.valueToOptimize = valueToOptimize;
	}
	
	
	
	
	
}
