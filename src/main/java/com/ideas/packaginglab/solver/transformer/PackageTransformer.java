package com.ideas.packaginglab.solver.transformer;

import java.util.ArrayList;
import java.util.List;

import com.ideas.packaginglab.solver.factory.VariableFactory;
import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.model.ExpressionCoefficient;
import com.ideas.packaginglab.solver.model.ExpressionConstraint;
import com.ideas.packaginglab.solver.model.LinearVariable;
import com.ideas.packaginglab.model.Package;
import com.ideas.packaginglab.model.PackageItem;

/**
 * This class transforms between domain object to model object and vice versa
 * 
 * @author Amit
 *
 * @param <E>
 * @param <Z>
 * @since 25 Nov 2015
 */
public class PackageTransformer<E extends LinearVariable, Z> {

	/**
	 * This method transforms domain object to model object.
	 * 
	 * @param _package
	 * @return
	 */
	public Expression<E, Z> readObject(final Package _package) {
		List<ExpressionCoefficient<E>> expressionCoefficients = new ArrayList<ExpressionCoefficient<E>>();
		for (final PackageItem packageItem : _package.getQueuedPackageItems()) {
			expressionCoefficients.add(new ExpressionCoefficient<E>(
					(E) VariableFactory.createObject(packageItem.getWeight()),
					(E) VariableFactory.createObject((packageItem.getCost()))));
		}
		Expression<E, Z> exp = new Expression<E, Z>(expressionCoefficients,
				null, new ExpressionConstraint<E>(
						(E) VariableFactory.createObject(_package
								.getWeightAllowed())),
				(E) VariableFactory.createObject(0.0));
		return exp;

	}

	/**
	 * This method transforms model object to domain object.
	 * 
	 * @param exp
	 * @param changeValue
	 * @return
	 */
	public Package writeObject(final Expression<E, Z> exp, Z changeValue) {
		final Z[] soluationVariable = exp.getExpressionVariables();
		Package _package = new Package();
		List<PackageItem> items = new ArrayList<PackageItem>();

		for (int i = 0; i < soluationVariable.length; ++i) {
			if (changeValue.equals(soluationVariable[i])) {
				_package.addPackageItem(new PackageItem(i + 1, 0.0, 0.0));
			}
		}
		return _package;

	}
}
