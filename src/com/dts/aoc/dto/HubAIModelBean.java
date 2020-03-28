package com.dts.aoc.dto;

import java.util.Vector;

public class HubAIModelBean {
	public String getUserName1() {
		return UserName1;
	}
	public void setUserName1(String userName1) {
		UserName1 = userName1;
	}
	public String getUserName2() {
		return UserName2;
	}
	public void setUserName2(String userName2) {
		UserName2 = userName2;
	}
	public int getSimilarity() {
		return Similarity;
	}
	public void setSimilarity(int similarity) {
		Similarity = similarity;
	}
	public float getProbability() {
		return Probability;
	}
	public void setProbability(float probability) {
		Probability = probability;
	}
	private String UserName1;
	private String UserName2;
	private int Similarity;
	private float Probability;
	
	
	private String NameSimilarityProduct;


	public String getNameSimilarityProduct() {
		return NameSimilarityProduct;
	}
	public void setNameSimilarityProduct(String nameSimilarityProduct) {
		NameSimilarityProduct = nameSimilarityProduct;
	}
	
	private Vector<HubAIModelBean> CollectionNameSimilarityProduct;


	public Vector<HubAIModelBean> getCollectionNameSimilarityProduct() {
		return CollectionNameSimilarityProduct;
	}
	public void setCollectionNameSimilarityProduct(
			Vector<HubAIModelBean> collectionNameSimilarityProduct) {
		CollectionNameSimilarityProduct = collectionNameSimilarityProduct;
	}
	

}
