package com.itguo.dao;

public class ProductBean {
	private String pname;
	private String market_price;
	private String shop_price;

	public ProductBean() {
		super();
	}

	public ProductBean(String pname) {
		super();
		this.pname = pname;
	}

	public ProductBean(String pname, String market_price, String shop_price) {
		super();
		this.pname = pname;
		this.market_price = market_price;
		this.shop_price = shop_price;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getMarket_price() {
		return market_price;
	}

	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}

	public String getShop_price() {
		return shop_price;
	}

	public void setShop_price(String shop_price) {
		this.shop_price = shop_price;
	}

}
