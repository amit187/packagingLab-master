package com.ideas.packaginglab.solver.util;

import com.ideas.packaginglab.solver.model.LinearVariable;

/**
 * This class contains equivalent arithmatic methods for LinearVariable
 * 
 * @author Amit
 * @since 25 Nov 2015
 *
 */
public class Util {

	/**
	 * This methods compares two operands and returns -1, 0 and 1 depending on
	 * comparison
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static int compareTo(LinearVariable o1, LinearVariable o2) {
		if (o1 != null && o2 != null) {
			return o1.compareTo(o2);
		}
		return 0;
	}

	/**
	 * This methods adds or substracts two operands dependeing on positive/
	 * negative i value.
	 * 
	 * @param o1
	 * @param o2
	 * @param i
	 * @return
	 */
	public static Object adjustConstraint(LinearVariable o1, LinearVariable o2,
			int i) {
		if (o1 != null && o2 != null) {
			if (i > 0) {
				return o1.add(o2);
			} else {
				return o1.minus(o2);
			}
		}
		return null;
	}

	/**
	 * This methods divides two operands
	 * 
	 * @param o1
	 * @param o2
	 * @return
	 */
	public static Comparable divide(LinearVariable o1, LinearVariable o2) {
		if (o1 != null && o2 != null) {
			return o1.divide(o2);
		}
		return null;
	}

}
