/**
 * 
 */
package com.ideas.packaginglab.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

import com.ideas.packaginglab.model.Package;
import com.ideas.packaginglab.model.PackageItem;
import com.ideas.packaginglab.solver.ISolver;
import com.ideas.packaginglab.solver.factory.SolverFactory;
import com.ideas.packaginglab.solver.factory.SolverType;
import com.ideas.packaginglab.solver.model.DoubleVariable;
import com.ideas.packaginglab.solver.model.Expression;
import com.ideas.packaginglab.solver.transformer.PackageTransformer;

/**
 * This class contains testcases for given 4 problems and matches them against given answers.
 * @author Amit
 * @since 
 */
public class PackagingTestCase {

	
	/**
	 * This method creates solver of the given type and assigns items to package.
	 * @param _package
	 * @param type
	 * @return
	 */
	private List<PackageItem> assignItems(Package _package, SolverType type) {
		SolverFactory<DoubleVariable, Integer> factory = new SolverFactory<DoubleVariable, Integer>();
		PackageTransformer<DoubleVariable, Integer> transformer = new PackageTransformer<DoubleVariable, Integer>();
		;
		Expression<DoubleVariable, Integer> exp = transformer
				.readObject(_package);
		ISolver<DoubleVariable, Integer> solver = factory.getSolver(type);
		Package assignedPackaged = transformer.writeObject(solver.solve(
				exp, new Integer(1)),
				new Integer(1));
		List<PackageItem> assignedItems = assignedPackaged
				.getAssignedPackageItems();
		return assignedItems;
	}

	/**
	 * Creates problem 1 arrangements.
	 * @return
	 */
	private Package createPackage1() {
		List<PackageItem> productItems = new ArrayList<PackageItem>();

		productItems.add(new PackageItem(1, 53.38, 45));
		productItems.add(new PackageItem(2, 88.62, 98));
		productItems.add(new PackageItem(3, 78.48, 3));
		productItems.add(new PackageItem(4, 72.30, 76));
		productItems.add(new PackageItem(5, 30.18, 9));
		productItems.add(new PackageItem(6, 46.34, 48));
		Package _package = new Package(1, 81, productItems);
		return _package;
	}


	@Test
	public void test1() {
		Package _package = createPackage1();
		List<PackageItem> assignedItems = assignItems(_package, SolverType.GREEDY);
		Assert.assertEquals(assignedItems.size(), 1);
		Assert.assertEquals(assignedItems.get(0).getIndex(), 4);

	}

	/**
	 * Creates problem 2 arrangements.
	 * @return
	 */
	private Package createPackage2() {
		List<PackageItem> productItems = new ArrayList<PackageItem>();
		productItems.add(new PackageItem(1,15.3,34));
		Package _package = new Package(2, 8, productItems);
		return _package;
		
	}
	
	@Test
	public void test2() {
		Package _package = createPackage2();
		List<PackageItem> assignedItems = assignItems(_package, SolverType.NONGREEDY);
		Assert.assertEquals(assignedItems, null);

	}

	/**
	 * Creates problem 3 arrangements.
	 * @return
	 */
	private Package createPackage3() {
		List<PackageItem> productItems = new ArrayList<PackageItem>();

		productItems.add(new PackageItem(1, 85.31, 29));
		productItems.add(new PackageItem(2, 14.55, 74));
		productItems.add(new PackageItem(3, 3.98, 16));
		productItems.add(new PackageItem(4, 26.24, 55));
		productItems.add(new PackageItem(5, 63.69, 52));
		productItems.add(new PackageItem(6, 76.25, 75));

		productItems.add(new PackageItem(7, 60.02, 74));
		productItems.add(new PackageItem(8, 93.18, 35));
		productItems.add(new PackageItem(9, 89.95, 78));
		Package _package = new Package(3, 75, productItems);
		return _package;
	}

	@Test
	public void test3() {
		Package _package = createPackage3();
		List<PackageItem> assignedItems = assignItems(_package, SolverType.GREEDY);
		Assert.assertEquals(assignedItems.size(), 2);
		Assert.assertEquals(assignedItems.get(0).getIndex(), 2);
		Assert.assertEquals(assignedItems.get(1).getIndex(), 7);

	}

	/**
	 * Creates problem 4 arrangements.
	 * @return
	 */
	private Package createPackage4() {
		List<PackageItem> productItems = new ArrayList<PackageItem>();

		productItems.add(new PackageItem(1, 90.72, 13));
		productItems.add(new PackageItem(2, 33.80, 40));
		productItems.add(new PackageItem(3, 43.15, 10));
		productItems.add(new PackageItem(4, 37.97, 16));
		productItems.add(new PackageItem(5, 46.81, 36));
		productItems.add(new PackageItem(6, 48.77, 79));

		productItems.add(new PackageItem(7, 81.80, 45));
		productItems.add(new PackageItem(8, 19.36, 79));
		productItems.add(new PackageItem(9, 6.76, 64));

		Package _package = new Package(4, 56, productItems);
		return _package;
	}


	@Test
	public void test4() {
		Package _package = createPackage4();
		List<PackageItem> assignedItems = assignItems(_package, SolverType.GREEDY);
		Assert.assertEquals(assignedItems.size(), 2);
		Assert.assertEquals(assignedItems.get(0).getIndex(), 8);
		Assert.assertEquals(assignedItems.get(1).getIndex(), 9);

	}

	
}
