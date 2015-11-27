/**
 * 
 */
package com.ideas.packaginglab.model;

/**
 * This class represents package item. A package item has attributes like identifier, weight and cost
 * @author Amit
 * @since 25 Nov 2015
 */
public class PackageItem {
	
	/**
	 *  identifier of the item
	 */
	private int index;
	
	/**
	 * weight of the item
	 */
	private double weight;
	
	/**
	 * cost of the item
	 */
	private double cost;

	
	/**
	 * @param index
	 * @param weight
	 * @param cost
	 */
	public PackageItem(int index, double weight, double cost) {
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PackageItem [index=" + index + ", weight=" + weight + ", cost="
				+ cost + "]";
	}
	
	

}
