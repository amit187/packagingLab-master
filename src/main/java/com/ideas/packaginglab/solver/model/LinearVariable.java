package com.ideas.packaginglab.solver.model;

/**
 * This is the base class for all type of the variables the solver can work on.
 * @author Amit
 *
 */
public abstract class LinearVariable implements Comparable<LinearVariable> {
	
	/**
	 * value 
	 */
	protected Comparable value;
	

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LinearVariable o) {
		if (value == null && o.getValue() == null) {
			return 0;
		}
		if (value != null && o.getValue() == null) {
			return 1;
		}
		if (value == null && o.getValue() != null) {
			return -1;
		}
		return value.compareTo(o.getValue());
		
	}

	/**
	 * @return the value
	 */
	public Comparable getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Comparable value) {
		this.value = value;
	}
	
	/**
	 * This method defines equivalent addition method for two LinearVariables.
	 * @param o
	 * @return
	 */
	public abstract Comparable add(LinearVariable o);

	/**
	 * This method defines equivalent substraction method for two LinearVariables.
	 * @param o
	 * @return
	 */
	public abstract Comparable minus(LinearVariable o) ;
	
	/**
	 * This method defines equivalent division method for two LinearVariables.
	 * @param o
	 * @return
	 */
	public abstract Comparable divide(LinearVariable o) ;
	
	
	
	

}
