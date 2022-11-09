package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {
	private String type;
	private String model;
	private Double maxMPH;
	private Double range;
	private Double price;

//	public void fastestJet() {
//        double fastest = 0;
//        for (Jet jet : jets) {
//            fastest = Math.max(fastest, jet.maxMPH());
//        }
//        System.out.println("The fastest jet(s) are listed below:");
//        System.out.println(fastest);
//        for (Jet jet2 : jets) {
//            if (jet2.maxMPH() >= fastest) {
//                System.out.println(jet2);
//                fastest();
//            }
//        }
//    } 
	
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
		return Objects.hash(maxMPH, model, price, range);
	}


//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Jet other = (Jet) obj;
//		if (model == null) {
//			if (other.model != null)
//				return false;
//			return Objects.equals(maxMPH, other.maxMPH) && Objects.equals(model, other.model)
//					&& Objects.equals(price, other.price) && Objects.equals(range, other.range);
//
//		} else if (!model.equals(other.model)) {
//			return false;
//		}
//		return false;
//	}

	@Override
	public String toString() {
		return "Jet [type=" + type + ", model=" + model + ", maxMPH=" + maxMPH + ", range=" + range + ", price=" + price+ "]";
	}

	public void fly() {
		
	}

	public Double getSpeedinMach() {
		Double mach = maxMPH / 767.3;
		return mach;
	}
}
