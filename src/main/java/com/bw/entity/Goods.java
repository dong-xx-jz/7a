package com.bw.entity;

public class Goods {
	
	private Integer gid;
	
	private String gname;
	
	private String gnameEng;
	
	private Double size;
	
	private Double price;
	
	private Integer number;
	
	private String label;
	
	private String picurl;
	
	private Integer bid;
	private String bname;
	
	private Integer kid;
	private String kname;
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(Integer gid, String gname, String gnameEng, Double size, Double price, Integer number, String label,
			String picurl, Integer bid, String bname, Integer kid, String kname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gnameEng = gnameEng;
		this.size = size;
		this.price = price;
		this.number = number;
		this.label = label;
		this.picurl = picurl;
		this.bid = bid;
		this.bname = bname;
		this.kid = kid;
		this.kname = kname;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGnameEng() {
		return gnameEng;
	}

	public void setGnameEng(String gnameEng) {
		this.gnameEng = gnameEng;
	}

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getKid() {
		return kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gnameEng=" + gnameEng + ", size=" + size + ", price="
				+ price + ", number=" + number + ", label=" + label + ", picurl=" + picurl + ", bid=" + bid + ", bname="
				+ bname + ", kid=" + kid + ", kname=" + kname + "]";
	}
	
	
	
	

}
