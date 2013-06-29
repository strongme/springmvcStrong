package org.strongme.walter.imgdata;

public class ContourPoint {

	private double gisX;
	private double gisY;
	private int count;
	
	public ContourPoint(double gisX, double gisY, int count) {
		super();
		this.gisX = gisX;
		this.gisY = gisY;
		this.count = count;
	}
	public double getGisX() {
		return gisX;
	}
	public void setGisX(double gisX) {
		this.gisX = gisX;
	}
	public double getGisY() {
		return gisY;
	}
	public void setGisY(double gisY) {
		this.gisY = gisY;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}
