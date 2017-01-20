package com.maxmedia.madisonmiller.model;

import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by Joshua King on 1/20/17.
 */
public class HomeScreenItem implements Serializable, Comparable<HomeScreenItem> {
	private              boolean isFavorited;
	private              String  productDescription;
	@DrawableRes private int     productImage;
	private              String  productName;
	private              String  productPrice;

	public HomeScreenItem (String productName, String productDescription, String productPrice, int productImage) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}

	@Override public boolean equals (Object o) {
		if (this == o) { return true; }
		if (!(o instanceof HomeScreenItem)) { return false; }

		HomeScreenItem that = (HomeScreenItem) o;

		return getProductImage() == that.getProductImage();
	}

	@Override public int hashCode () {
		return getProductImage();
	}

	@Override public int compareTo (HomeScreenItem other) {
		return getProductImage() - other.getProductImage();
	}

	public boolean isFavorited () {
		return isFavorited;
	}

	public void setFavorited (boolean favorited) {
		isFavorited = favorited;
	}

	public String getProductPrice () {
		return productPrice;
	}

	public String getProductDescription () {

		return productDescription;
	}

	public int getProductImage () {
		return productImage;
	}

	public String getProductName () {
		return productName;
	}
}
