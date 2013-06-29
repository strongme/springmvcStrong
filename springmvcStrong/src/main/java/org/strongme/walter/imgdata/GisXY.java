package org.strongme.walter.imgdata;



public class GisXY {
	
	private double gisX;
	private double gisY;
	private int rowIndex;
	private int colIndex;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public GisXY(double gisX, double gisY) {
		super();
		this.gisX = gisX;
		this.gisY = gisY;
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
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getColIndex() {
		return colIndex;
	}
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
	
	
}
