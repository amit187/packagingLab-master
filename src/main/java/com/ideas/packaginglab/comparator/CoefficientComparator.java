/**
 * 
 */
package com.ideas.packaginglab.comparator;

import java.util.Comparator;

import com.ideas.packaginglab.solver.model.ExpressionCoefficient;
import com.ideas.packaginglab.solver.model.LinearVariable;
import com.ideas.packaginglab.solver.util.Util;

/**
 * This class compares two coefficients. This is a heauritstic which tryies to maximize cost unit per weight unit.
 * @author Amit
 * @param <E>
 * @since 25 Nov 2015
 *
 */
public class CoefficientComparator<E extends LinearVariable> implements
		Comparator<ExpressionCoefficient<E>> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(ExpressionCoefficient<E> o1, ExpressionCoefficient<E> o2) {
		if (o1 != null && o2 != null) {
			Comparable l1 = Util.divide(o1.getValueToOptimize(),
					(o1.getConstrainedValue()));
			Comparable l2 = Util.divide(o2.getValueToOptimize(),
					(o2.getConstrainedValue()));
			return l1 != null ? l1.compareTo(l2) : 0;
		}

		return 0;
	}

}
