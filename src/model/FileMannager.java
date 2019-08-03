package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileMannager {

	private FileWriter fileWriter;
	
	
	public FileMannager() {
		
	}
	
	public void writeNumber(ArrayList<Double> lanzamientos,String ruta) {
		try {
			fileWriter = new FileWriter(new File(ruta),true);
			for (int i = 0; i < lanzamientos.size(); i++) {
				fileWriter.write(Double.toString(lanzamientos.get(i))+"\n");
			}
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
