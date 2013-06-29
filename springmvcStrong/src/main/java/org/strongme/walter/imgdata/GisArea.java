package org.strongme.walter.imgdata;

public class GisArea {

	// ��ǰ��ͼ�������½�X
	private double minX;
	// ��ǰ��ͼ�������½�Y
	private double minY;
	// ��ǰ��ͼ�������Ͻ�X
	private double maxX;
	// ��ǰ��ͼ�������Ͻ�Y
	private double maxY;
	// ��ǰ�����ڵľ�����
	private int caseCountIn;

	public GisArea(double minX, double minY, double maxX, double maxY) {
		super();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		caseCountIn = 0;
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

	public int getCaseCountIn() {
		return caseCountIn;
	}

	public void setCaseCountIn(int caseCountIn) {
		this.caseCountIn = caseCountIn;
	}

	// ��: 23.2312132,231.21312,342
	public String toDot3DString() {
		double centerX = (maxX - minX) / 2+minX;
		double centerY = (maxY - minY) / 2+minY;
		return centerX + "," + centerY + "," + caseCountIn;
	}

	@Override
	public String toString() {
		return minX + "," + minY + "," + maxX + "," + maxY;
	}

}
