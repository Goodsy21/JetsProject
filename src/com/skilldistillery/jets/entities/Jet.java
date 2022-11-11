package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String type;
	private String model;
	private Double maxMPH;
	private Double range;
	private Double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getMaxMPH() {
		return maxMPH;
	}

	public void setMaxMPH(Double maxMPH) {
		this.maxMPH = maxMPH;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxMPH, model, range, price);
	}

	@Override
	public String toString() {
		return "Jet [type=" + type + ", model=" + model + ", maxMPH=" + maxMPH + ", range=" + range + ", price=" + price
				+ "]";
	}

	public void fly() {
		System.out.println(
				"This is " + this.getModel() + " I can fly for " + this.getRange() / this.getMaxMPH() + " hours");
	}

	public Double getSpeedinMach() {
		Double mach = maxMPH / 767.3;
		return mach;
	}
}
