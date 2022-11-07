package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String model;
	private Double maxMPH;
	private Double range;
	private Double price;
	private String getModel() {
		return model;
	}
	private void setModel(String model) {
		this.model = model;
	}
	private Double getMaxMPH() {
		return maxMPH;
	}
	private void setMaxMPH(Double maxMPH) {
		this.maxMPH = maxMPH;
	}
	private Double getRange() {
		return range;
	}
	private void setRange(Double range) {
		this.range = range;
	}
	private Double getPrice() {
		return price;
	}
	private void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maxMPH, model, price, range);
	}
	public Jet(String model, Double maxMPH, Double range, Double price) {
		super();
		this.model = model;
		this.maxMPH = maxMPH;
		this.range = range;
		this.price = price;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		return Objects.equals(maxMPH, other.maxMPH) && Objects.equals(model, other.model)
				&& Objects.equals(price, other.price) && Objects.equals(range, other.range);
		
		}else if (!model.equals(other.model)) {
					return false;
			}
		return false;
		}
	@Override
	public String toString() {
		return "Jet [model=" + model + ", maxMPH=" + maxMPH + ", range=" + range + ", price=" + price + ", getModel()="
				+ getModel() + ", getMaxMPH()=" + getMaxMPH() + ", getRange()=" + getRange() + ", getPrice()="
				+ getPrice() + ", hashCode()=" + hashCode() + ", getSpeedinMach()=" + getSpeedinMach() + ", getClass()="
				+ getClass() + ", toString()=" + super.toString() + "]";
	}
	
	public abstract void fly();{
		System.out.println("Flying!");
		System.out.println("I can fly for " + range / maxMPH + "hours");
		}
	public Double getSpeedinMach() {
		Double mach = maxMPH/767.3;
		return mach;
	}}
