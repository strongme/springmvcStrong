package org.strongme.walter.imgdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AreaConfig {
	
	//��ʾ��ǰ��ͼ����
	private GisArea area;
	//��ǰ��ͼ����Ҫ���ֵķ�����  x*x   
	private int gridSeperateCount;
	//��¼�������������飬��һ����ά��������ֵ�ֱ��ʾ�к���
	private GisArea[][] caseDistribution;
	//��¼�����о��������ֵ
	private int maxCaseCount;
	
	public AreaConfig(GisArea area, int gridSeperateCount) {
		super();
		this.area = area;
		this.gridSeperateCount = gridSeperateCount;
		caseDistribution = new GisArea[gridSeperateCount][gridSeperateCount];
		initDistribution();
	}

	/**
	 * ��ʼ����¼��������������
	 */
	private void initDistribution() {
		double startX  = area.getMinX();
		double startY = area.getMinY();
		double avgWidth = (area.getMaxX()-area.getMinX())/gridSeperateCount;
		double avgHeight = (area.getMaxY()-area.getMinY())/gridSeperateCount;
		for(int i=0;i<gridSeperateCount;i++) {
			for(int j=0;j<gridSeperateCount;j++) {
				double minX = startX + avgWidth*j;
				double maxX = startX + avgWidth*(j+1);
				double minY = startY + avgHeight*i;
				double maxY = startY + avgHeight*(i+1);
				GisArea gisArea = new GisArea(minX, minY, maxX, maxY);
				caseDistribution[i][j] = gisArea;
			}
		}
	}
	
	/**
	 * ���ݵ�ǰ��������ԣ���ȡ���ڴ�Χ����ķֲ�λ�ò�������Ӧ�ļ���������caseDistribution�е�����λ��row and col
	 * @param gisXY ��ǰ�����
	 * @return 
	 */
	public void distributeGisXYByXY(GisXY gisXY) {
		int rowIndex = -1;
		int colIndex = -1;
		//���ڵ����ͼ���ԣ�����������������������������   ������Χ�� 0~gridSeperateCount-1
		//��  gisY 
		double min = area.getMinY();
		double max = area.getMaxY();
		double current = gisXY.getGisY();
		double avg = (Math.abs(max-min))/gridSeperateCount;
		rowIndex =  (int) Math.floor((Math.abs(current-min))/avg);
		//�� gisX
		min = area.getMinX();
		max = area.getMaxX();
		current = gisXY.getGisX();
		avg = (Math.abs(max-min))/gridSeperateCount;
		colIndex =  (int) Math.floor((Math.abs(current-min))/avg);
		if(rowIndex<0||colIndex<0) {
			System.out.println("����");
		}
		if(rowIndex>=gridSeperateCount||colIndex>=gridSeperateCount||rowIndex<0||colIndex<0) return;
		gisXY.setRowIndex(rowIndex);
		gisXY.setColIndex(colIndex);
		int curCount =  caseDistribution[rowIndex][colIndex].getCaseCountIn();
		 caseDistribution[rowIndex][colIndex].setCaseCountIn(curCount+1);
		if( caseDistribution[rowIndex][colIndex].getCaseCountIn()>maxCaseCount) {
			maxCaseCount =  caseDistribution[rowIndex][colIndex].getCaseCountIn();
		}
	}
	
	public void distributeGisXYByXY(List<GisXY> gises) {
		for(GisXY gisXy : gises) {
			distributeGisXYByXY(gisXy);
		}	
	}
	
	/**
	 * ������ֲ�����д���ļ��Թ�����������
	 * @param filepath
	 * @return �����ļ�ȫ·��
	 */
	public String writeDistributionInfoToFile(String filepath,String filename) {
		File dir = new File(filepath);
		if(!filepath.endsWith("/")&&!filepath.endsWith("\\")) {
			filepath += "/";
		}
		File dataFile = new File(filepath+filename);
		FileOutputStream outStream = null;
		try {
			if(!dir.exists()) {dir.mkdir();}
			if(!dataFile.exists()) {dataFile.createNewFile();}
			outStream = new FileOutputStream(dataFile);
			for(GisArea[] row : caseDistribution) {
				for(GisArea col : row) {
					outStream.write((col.toDot3DString()+"\r\n").getBytes());
				}
				outStream.flush();
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(outStream!=null) {
				try {
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return filepath+filename;
	}
	
	
	public int getMaxCaseCount() {
		return maxCaseCount;
	}

	/*public static void main(String[] args) {
		
		 *  minX = 0 minY = 0 maxX = 999.999 maxY =
	     * 99682.996826
		 
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		GisXYDao gisXYDao = (GisXYDao) context.getBean("gisxyDao");
		long n1 = System.currentTimeMillis();
		List<GisXY> r = gisXYDao.getAll();
		long n2 = System.currentTimeMillis();
		System.out.println("TIme : "+(n2-n1));
		double minX = 0.0;
		double minY = 0.0;
		double maxX =199.14917;
		double maxY = 39.972033;
		GisArea area = new GisArea(minX, minY, maxX, maxY);
		AreaConfig areaConfig = new AreaConfig(area, 100);
		areaConfig.distributeGisXYByXY(r);
		areaConfig.writeDistributionInfoToFile("H:/data",);
	}*/
	
}





