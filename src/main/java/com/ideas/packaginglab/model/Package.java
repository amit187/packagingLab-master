/**
 * 
 */
package com.ideas.packaginglab.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ideas.packaginglab.exception.PackagingUncheckedException;

/**
 * This class represents a package. A package has many package items
 * 
 * @author Amit
 * @since 25 Nov 2015
 */
public class Package {

	/**
	 * identifier of the package
	 */
	private int index;

	/**
	 * weight allowed for the package
	 */
	private double weightAllowed;

	/**
	 * current weight of the package
	 */
	private double currentWeight = 0;

	/**
	 * package items assigned for this package
	 */
	private List<PackageItem> assignedPackageItems;

	/**
	 * package items queued for this package
	 */
	private List<PackageItem> queuedPackageItems;
	
	public Package() {
		super();
	}

	/**
	 * Constuctor with params
	 * 
	 * @param index
	 * @param weightAllowed
	 * @param queuedPackageItems
	 */
	public Package(int index, double weightAllowed,
			List<PackageItem> queuedPackageItems) {
		super();
		if (weightAllowed > 100) {
			throw new PackagingUncheckedException("Given weight "
					+ weightAllowed + " exceeds Maximum weight allowed");
		}
		if (queuedPackageItems != null) { 
			if(queuedPackageItems.size() > 15) {
				throw new PackagingUncheckedException("Number of items exceeds maximum possible items");
			}
			for(PackageItem item : queuedPackageItems) {
				if(item.getCost() > 100 || item.getWeight() > 100) {
					throw new PackagingUncheckedException("Item cost or weight exceeds maximum possible unit set");
				}
			}
		}
		this.index = index;
		this.weightAllowed = weightAllowed;
		this.queuedPackageItems = queuedPackageItems;
	}

	/**
	 * clears package items
	 */
	public void clearPackageItems() {
		if (assignedPackageItems != null) {
			assignedPackageItems.clear();
		}
		currentWeight = 0;
	}

	/**
	 * Adds a productItem to package and returns added -> true / not added ->
	 * false
	 * 
	 * @param packageItem
	 * @return successful addition
	 */
	public boolean addPackageItem(final PackageItem packageItem) {
		if (assignedPackageItems == null) {
			assignedPackageItems = new ArrayList<PackageItem>();
		}
		if (currentWeight + packageItem.getWeight() <= weightAllowed) {
			assignedPackageItems.add(packageItem);
			currentWeight += packageItem.getWeight();
			return true;
		} else {
			throw new PackagingUncheckedException(
					"Package Item can not be added as it's weight "
							+ weightAllowed + " exceeds Maximum weight allowed");
		}
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the weightAllowed
	 */
	public double getWeightAllowed() {
		return weightAllowed;
	}

	/**
	 * @param weightAllowed
	 *            the weightAllowed to set
	 */
	public void setWeightAllowed(double weightAllowed) {
		this.weightAllowed = weightAllowed;
	}

	/**
	 * @param queuedPackageItems the queuedPackageItems to set
	 */
	public void setQueuedPackageItems(List<PackageItem> queuedPackageItems) {
		this.queuedPackageItems = queuedPackageItems;
	}

	/**
	 * @return the queuedPackageItems
	 */
	public List<PackageItem> getQueuedPackageItems() {
		return queuedPackageItems;
	}

	/**
	 * @return the assignedPackageItems
	 */
	public List<PackageItem> getAssignedPackageItems() {
		return assignedPackageItems;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Package [index=" + index + ", weightAllowed=" + weightAllowed
				+ ", queuedPackageItems=" + queuedPackageItems
				+ ", assignedPackageItems=" + assignedPackageItems + "]";
	}
}
