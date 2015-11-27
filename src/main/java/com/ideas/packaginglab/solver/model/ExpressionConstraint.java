/**
 * 
 */
package com.ideas.packaginglab.solver.model;

/**
 * This class represents constraints for Linear Expression
 * @author Amit
 * @since 25 Nov 2015
 */
public class ExpressionConstraint<V extends LinearVariable> {

	/**
	 * Limit value.
	 */
	private V limitValue;

	/**
	 * @return the limitValue
	 */
	public V getLimitValue() {
		return limitValue;
	}

	/**
	 * @param limitValue the limitValue to set
	 */
	public void setLimitValue(V limitValue) {
		this.limitValue = limitValue;
	}

	/**
	 * @param limitValue
	 */
	public ExpressionConstraint(V limitValue) {
		super();
		this.limitValue = limitValue;
	}


	
	
	
}
