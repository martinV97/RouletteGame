package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import utils.Constants;


public class RandomTest {

	public FileManager fileManager;
	private ArrayList<Double> arrayList;
	public RandomTest() {
		super();
		fileManager = new FileManager();
		arrayList = new ArrayList<Double>();
		
	}
	
	public  int halfs(String path){
		try {
			arrayList = (ArrayList<Double>) fileManager.readNumbers(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double min =  Collections.min(arrayList);
		double max =  Collections.max(arrayList);
		double aceptacion = 0.95;
		double alfa = 0.05;
		int n = arrayList.size();
		
		double sum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			sum = sum+arrayList.get(i);
		}
		double averange = sum/arrayList.size();
		double  probabilidad = 0.975;
		double  z = 1.959963985;
		double li= (0.5)-(z*(1/Math.sqrt(12*n)));
		double ls= (0.5)+(z*(1/Math.sqrt(12*n)));
		if((averange>=li)&& (averange<=ls)){
			System.out.println("si pasass");
			return 0;
		}
		else{
			return 1;
		}
	}
	public  boolean variances(String path){
		try {
			arrayList = (ArrayList<Double>) fileManager.readNumbers(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double min =  Collections.min(arrayList);
		double max =  Collections.max(arrayList);
		
		double aceptacion = 0.95;
		double alfa = 0.05;
		double alfam = 0.025;
		double  probabilidad = 0.975;
		
		int n = arrayList.size();
		
		double sum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			sum = sum+arrayList.get(i);
		}
		double averange = sum/arrayList.size();
		double  z = 1.959963985;
		double li= (0.5)-(z*(1/Math.sqrt(12*n)));
		double ls= (0.5)+(z*(1/Math.sqrt(12*n)));
		if((averange>=li)&& (averange<=ls)){
			System.out.println("si");
			return true;
		}
		
		return false;
		
	}
	public boolean chiSquare(String path){
		try {
			arrayList = (ArrayList<Double>) fileManager.readNumbers(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double min =  Collections.min(arrayList);
		double max =  Collections.max(arrayList);
		double intervals = Constants.INTERVALS;
		double intervalo = (max-min)/intervals;
		
		double aceptacion = 0.95;
		double alfa = 0.05;
		double alfam = 0.025;
		
		int n = arrayList.size();
		
		double sum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			sum = sum+arrayList.get(i);
		}
		double averange = sum/arrayList.size();
		double  probabilidad = 0.975;
		double  z = 1.959963985;
		double li= (0.5)-(z*(1/Math.sqrt(12*n)));
		double ls= (0.5)+(z*(1/Math.sqrt(12*n)));
		if((averange>=li)&& (averange<=ls)){
			System.out.println("si");
			return true;
		}
		
		return false;
	}

	
}
