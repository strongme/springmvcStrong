package org.strongme.walter.imgdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProcess {
	
	public static List<ContourPoint> processFileToXYList(String filename) {
		List<ContourPoint> result = new ArrayList<ContourPoint>();
		File file = new File(filename);
		BufferedReader bufferedReader = null;
		if(file.exists()) {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				String curLine = bufferedReader.readLine();
				while(curLine!=null){
					String[] tmp = curLine.split(",");
					double x = Double.valueOf(tmp[0]);
					double y = Double.valueOf(tmp[1]);
					int z = Integer.valueOf(tmp[3]);
					ContourPoint point = new ContourPoint(x, y, z);
					result.add(point);
					curLine =bufferedReader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(bufferedReader!=null)
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		return result;
	}
	
	public static ContourBean processFileToContourBean(String filename) {
		ContourBean result = null;
		File file = new File("D:/"+filename+".txt");
		BufferedReader bufferedReader = null;
		List<Integer> tmpList = new ArrayList<Integer>();
		int maxCount = 0;
		if(file.exists()) {
			try {
				bufferedReader = new BufferedReader(new FileReader(file));
				String curLine = bufferedReader.readLine();
				while(curLine!=null){
					String[] tmp = curLine.split(",");
					int z = Integer.valueOf(tmp[2]);
					tmpList.add(z);
					if(z>maxCount)maxCount=z;
					curLine =bufferedReader.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				if(bufferedReader!=null)
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
		int avg = (int) Math.sqrt(tmpList.size());
		int[][] data = new int[avg][avg];
		int indexOutter = 0;
		int indexInner = 0;
		for(int i=0;i<tmpList.size();i++) {
			if(indexInner>=avg) {
				indexOutter++;
				indexInner=0;
			}
			data[indexOutter][indexInner]=tmpList.get(i);
			indexInner++;
		}
		String rangeStr = filename.substring(0, filename.lastIndexOf("."));
		String[] rangeArr = rangeStr.split(",");
		double minX = Double.valueOf(rangeArr[0]);
		double minY = Double.valueOf(rangeArr[1]);
		double maxX = Double.valueOf(rangeArr[2]);
		double maxY = Double.valueOf(rangeArr[3]);
		result = new ContourBean(minX, minY, maxX, maxY, maxCount, data);
		return result;
	}
	
	public static String arrayToStr(int[][] data) {
		String result = "[";
		for(int i=0;i<data.length;i++) {
			result+="[";
			for(int j=0;j<data[i].length;j++) {
				if(j!=data[i].length-1){
					result+=data[i][j]+",";
				}else {
					result+=data[i][j];
				}
			}
			if(i!=data.length-1) {
				result+="],";
			}else {
				result+="]";
			}
		}
		result+="]";
		return result;
	}

}
