package com.ideas.packaginglab.solver.model;

/**
 * This class represents Double variable. 
 * More such classes can be created to extend the logic to work on other types like String, hex etc.
 * @author Amit
 * @since 25 Nov 2015
 */
public class DoubleVariable extends LinearVariable{
	
	/**
	 * One argument constructor
	 * @param d
	 */
	public DoubleVariable(Comparable d) {
		value = d;
	}

	/* (non-Javadoc)
	 * @see com.ideas.packaginglab.solver.model.LinearVariable#add(com.ideas.packaginglab.solver.model.LinearVariable)
	 */
	@Override
	public Comparable add(LinearVariable o) {
		
		if (o == null) {
			return value;
		}
		
		if (value == null) {
			return o;
		}
		
		if(o.getValue().getClass().isAssignableFrom(Double.class)) {
			return new DoubleVariable(new Double(value.toString()) + new Double(o.getValue().toString()));
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.ideas.packaginglab.solver.model.LinearVariable#minus(com.ideas.packaginglab.solver.model.LinearVariable)
	 */
	@Override
	public Comparable minus(LinearVariable o) {
		
		if (o == null) {
			return value;
		}
		
		if (value == null) {
			return o;
		}
		
		if(o.getValue().getClass().isAssignableFrom(Double.class)) {
			return new DoubleVariable(new Double(value.toString()) - new Double(o.getValue().toString()));
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.ideas.packaginglab.solver.model.LinearVariable#divide(com.ideas.packaginglab.solver.model.LinearVariable)
	 */
	@Override
	public Comparable divide(LinearVariable o) {
		
		if (o == null) {
			return value;
		}
		
		if (value == null) {
			return o;
		}
		
		if(o.getValue().getClass().isAssignableFrom(Double.class) && new Double(0.0).equals(o.getValue())) {
			return new DoubleVariable(new Double(value.toString()) / new Double(o.getValue().toString()));
		}
		return null;
	}
	
}
