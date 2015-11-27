package com.ideas.packaginglab.solver.factory;

import com.ideas.packaginglab.solver.model.DoubleVariable;

/**
 * This class is a factory for different variables. We have used Generic and
 * hence, we need this to create appropriate objects for generic types.
 * 
 * @author Amit
 * @since 25 Nov 2015
 */
public class VariableFactory {

	/**
	 * This method creates Double variable.
	 * @param value
	 * @return
	 */
	public static DoubleVariable createObject(final Double value) {
		return new DoubleVariable(value);
	}

	/**
	 * This method creates default value for a given array.
	 * @param list
	 * @return
	 */
	public static Object getDefaultValue(final Integer[] list) {
		return new Integer(0);
	}

}
