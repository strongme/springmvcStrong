package org.strongme.walter.imgdata;

public class ContourBean {
	
	private double minX;
	private double minY;
	private double maxX;
	private double maxY;
	private int maxCount;
	private int[][] data;
	private String dataStr;
	
	public ContourBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ContourBean(double minX, double minY, double maxX, double maxY,
			int maxCount, String dataStr) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxCount = maxCount;
		this.dataStr = dataStr;
	}

	public ContourBean(double minX, double minY, double maxX, double maxY,
			int maxCount, int[][] data) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.maxCount = maxCount;
		this.data = data;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int[][] getData() {
		return data;
	}
	public void setData(int[][] data) {
		this.data = data;
	}
	public double getMinX() {
		return minX;
	}
	public void setMinX(double minX) {
		this.minX = minX;
	}
	public double getMinY() {
		return minY;
	}
	public void setMinY(double minY) {
		this.minY = minY;
	}
	public double getMaxX() {
		return maxX;
	}
	public void setMaxX(double maxX) {
		this.maxX = maxX;
	}
	public double getMaxY() {
		return maxY;
	}
	public void setMaxY(double maxY) {
		this.maxY = maxY;
	}


	public String getDataStr() {
		return dataStr;
	}


	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	
	
	
}
