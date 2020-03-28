package com.dts.aoc.dto;

import java.util.Vector;

public class ClassBean {
	
	public String getTopRankProductName() {
		return TopRankProductName;
	}
	public void setTopRankProductName(String topRankProductName) {
		TopRankProductName = topRankProductName;
	}
	public String getProductLikeOrNot() {
		return ProductLikeOrNot;
	}
	public void setProductLikeOrNot(String productLikeOrNot) {
		ProductLikeOrNot = productLikeOrNot;
	}
	public float getProductRank() {
		return ProductRank;
	}
	public void setProductRank(float productRank) {
		ProductRank = productRank;
	}
	public Vector<ClassBean> getVectorProductLikeOrNot() {
		return VectorProductLikeOrNot;
	}
	public void setVectorProductLikeOrNot(Vector<ClassBean> vectorProductLikeOrNot) {
		VectorProductLikeOrNot = vectorProductLikeOrNot;
	}
	private String TopRankProductName;
	private String ProductLikeOrNot;
	private float ProductRank;
	private Vector<ClassBean> VectorProductLikeOrNot;
	
	

	public String getPlace1() {
		return Place1;
	}
	public void setPlace1(String place1) {
		Place1 = place1;
	}
	public String getPlace2() {
		return Place2;
	}
	public void setPlace2(String place2) {
		Place2 = place2;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}

	
	private String Place1;
	private String Place2;
	private int distance;
	
	public InsertProductsBean getProductInformationObject() {
		return ProductInformationObject;
	}
	public void setProductInformationObject(
			InsertProductsBean productInformationObject) {
		ProductInformationObject = productInformationObject;
	}
	private InsertProductsBean ProductInformationObject;

}
