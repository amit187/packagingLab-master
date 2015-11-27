/**
 * 
 */
package com.ideas.packaginglab.exception;


/**
 * This class represents application specific runtime exception
 * @author Amit
 * @since 25 Nov 2015
 *
 */
public class PackagingUncheckedException extends RuntimeException {

	/**
	 * No argument constructor
	 */
	public PackagingUncheckedException() {
		super();
	}

	/**
	 * One argument constructor
	 * @param message
	 */
	public PackagingUncheckedException(String message) {
		super(message);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackagingUncheckedException [getMessage()=" + getMessage()
				+ ", getCause()=" + getCause() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
